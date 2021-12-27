package de.signWritingEditor.server.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.LookupOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolToHeadSymbolConverter;

public class SignImageService {
	private static final String PROPERTY_SYMBOL_PROVIDER_URL = "esf.symbolprovider.url";
	private static final String LAST_PNG = "07-01-003-01-01-08.png";
	private static final String ISWA_ZIP = "../setup/ISWA2010_PNGs_4x.zip";

	private static final int SYMBOL_PNG_SCALE_FACTOR = 4;
	private static final double MAX_SCALE_FACTOR = SYMBOL_PNG_SCALE_FACTOR;

	private static final Logger LOG = Logger.getLogger(SignImageService.class);

	private static Map<Double, Map<Symbol, Image>> scaleFactorToSymbolImageCache = new HashMap<Double, Map<Symbol, Image>>();
	private final String symbolProviderUrl;
	private final DictionaryService dictionaryService;

	// Use SignImageFileSystemCache for activate caching
	private SignImageCache signImageCache;

	public SignImageService(ConfigurationService configurationService, DictionaryService dictionaryService) {
		assert configurationService != null : "Precondition failed: configurationService != null";
		assert dictionaryService != null : "Precondition failed: dictionaryService != null";

		this.dictionaryService = dictionaryService;
		this.symbolProviderUrl = configurationService.getProperty(PROPERTY_SYMBOL_PROVIDER_URL);

		extractIswaZipOnFirstRun();
		signImageCache = new SignImageFileSystemCache(configurationService);
	}

	private void extractIswaZipOnFirstRun() {
		File lastPng = new File(symbolProviderUrl + LAST_PNG);
		if (!lastPng.exists()) {
			try {
				extractIswaZip();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void extractIswaZip() throws IOException {
		LOG.info("extracting " + ISWA_ZIP + " to " + symbolProviderUrl);
		if (new File(symbolProviderUrl).mkdir()) {
			LOG.info("created directory " + symbolProviderUrl);
		}
		// the biggest png is merely 15k, so larger buffers would be pointless
		byte[] buffer = new byte[16384];
		try (ZipInputStream input = new ZipInputStream(new FileInputStream(ISWA_ZIP))) {
			int countPngsExtracted = 0;
			for (ZipEntry entry; (entry = input.getNextEntry()) != null; input.closeEntry()) {
				File png = new File(symbolProviderUrl, entry.getName());
				try (FileOutputStream output = new FileOutputStream(png)) {
					int countBytesRead;
					while ((countBytesRead = input.read(buffer)) > 0) {
						output.write(buffer, 0, countBytesRead);
					}
				}
				++countPngsExtracted;
				if (countPngsExtracted % 1000 == 0) {
					LOG.info(countPngsExtracted + " " + png);
				}
			}
		}
	}

	public double getMaxScaleFactor() {
		double result = MAX_SCALE_FACTOR;

		assert result > 0 : "Postcondition failed: result > 0";
		return result;
	}

	public BufferedImage createSignImage(SignItem signItem, double scaleFactor, boolean transparent)
			throws IOException {
		assert signItem != null : "Precondition failed: signItem != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		// mwe Bugfix: Alte Dokumente ohne SignSource konnten nicht als PDF
		// erzeugt werden
		SignId newSignId = signItem.getSignId();
		newSignId = getCorrectSignId(newSignId);

		SimpleSign sign = signItem.hasLocalSign() ? signItem.getLocalSign() : dictionaryService.getSign(newSignId);

		return createSignImage(sign, scaleFactor, transparent);
	}

	public BufferedImage createSignImage(SignId signId, double scaleFactor, boolean transparent) throws IOException {
		assert signId != null : "Precondition failed: signId != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		BufferedImage result = null;

		if (signImageCache.containsSignImage(signId, scaleFactor, transparent)) {
			result = signImageCache.getSignImage(signId, scaleFactor, transparent);
		} else {
			signId = getCorrectSignId(signId);
			SimpleSign sign = dictionaryService.getSign(signId);
			result = createSignImage(sign, scaleFactor, transparent);

			try {
				signImageCache.addSignImage(signId, scaleFactor, transparent, result);
			} catch (Exception exception) {
				LOG.error("Could not cache sign image with id " + signId, exception);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public BufferedImage createSignImage(SimpleSign sign, double scaleFactor, boolean transparent) throws IOException {
		assert sign != null : "Precondition failed: sign != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		int scaledSignWidth = (int) (sign.getWidth() * scaleFactor);
		int scaledSignHeight = (int) (sign.getHeight() * scaleFactor);

		// Since it is not allowed to create images with size 0, 0 create it
		// with size 1, 1 in that case:
		BufferedImage result = new BufferedImage(Math.max(scaledSignWidth, 1), Math.max(scaledSignHeight, 1),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = result.createGraphics();

		if (!transparent) {
			graphics.setColor(java.awt.Color.WHITE);
			graphics.fillRect(0, 0, scaledSignWidth, scaledSignHeight);
		}

		drawPositionedSymbols(graphics, sign.getPlainSymbols(), scaleFactor);

		graphics.dispose();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public BufferedImage createHeadSymbolImage(HeadSymbol headSymbol, double scaleFactor) throws IOException {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		int scaledHeadSymbolWidth = scaleToInt(headSymbol.getWidth(), scaleFactor);
		int scaledHeadSymbolHeight = scaleToInt(headSymbol.getHeight(), scaleFactor);

		BufferedImage result = new BufferedImage(scaledHeadSymbolWidth, scaledHeadSymbolHeight,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = result.createGraphics();

		// Fill heads with white to prevent double overlap
		// Assume that line width is 1 in original size
		double lineWidth = scaleFactor;
		double innerHeadCircleWidth = scale(HeadSymbol.HEAD_CIRCLE_WIDTH, scaleFactor) - 2 * lineWidth;
		double innerHeadCircleHeight = scale(HeadSymbol.HEAD_CIRCLE_HEIGHT, scaleFactor) - 2 * lineWidth;
		graphics.setColor(java.awt.Color.WHITE);
		graphics.fill(new Ellipse2D.Double(getLeftOrTop(scaledHeadSymbolWidth / 2, innerHeadCircleWidth),
				scaledHeadSymbolHeight - innerHeadCircleHeight - lineWidth, innerHeadCircleWidth,
				innerHeadCircleHeight));

		drawPositionedSymbols(graphics, SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol,
				headSymbol.getX(), headSymbol.getY(), headSymbol.getZ()), scaleFactor);

		graphics.dispose();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public BufferedImage createPositionedSymbolsImage(List<PositionedSymbol> positionedSymbols, double scaleFactor,
			boolean transparent) throws IOException {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		int canvasWidth = calculateCanvasWidth(positionedSymbols);
		int canvasHeight = calculateCanvasHeight(positionedSymbols);

		BufferedImage result = createPositionedSymbolsImage(positionedSymbols, canvasWidth, canvasHeight, scaleFactor,
				transparent);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public BufferedImage createPositionedSymbolsImage(List<PositionedSymbol> positionedSymbols, int canvasWidth,
			int canvasHeight, double scaleFactor, boolean transparent) throws IOException {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";
		assert canvasWidth > 0 : "Precondition failed: canvasWidth > 0";
		assert canvasHeight > 0 : "Precondition failed: canvasHeight > 0";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		int scaledSymbolGroupWidth = scaleToInt(canvasWidth, scaleFactor);
		int scaledSymbolGroupHeight = scaleToInt(canvasHeight, scaleFactor);

		BufferedImage result = new BufferedImage(scaledSymbolGroupWidth, scaledSymbolGroupHeight,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = result.createGraphics();

		if (!transparent) {
			graphics.setColor(java.awt.Color.WHITE);
			graphics.fillRect(0, 0, scaledSymbolGroupWidth, scaledSymbolGroupHeight);
		}

		drawPositionedSymbols(graphics, positionedSymbols, scaleFactor);

		graphics.dispose();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public Image loadSymbolImage(Symbol symbol, double scaleFactor) throws IOException {
		return loadSymbolImage(symbol, scaleFactor, Color.BLACK, Color.WHITE);
	}

	public Image loadSymbolImage(Symbol symbol, double scaleFactor, Color newColorForFormerBlack,
			Color newColorForFormerWhite) throws IOException {
		assert symbol != null : "Precondition failed: symbol != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		Image result = null;

		double imageScaleFactor = scaleFactor / SYMBOL_PNG_SCALE_FACTOR;

		File imageFile = new File(symbolProviderUrl + symbol.getIswaId() + ".png");

		if (imageFile.exists()) {
			result = ImageIO.read(imageFile);

			if (imageScaleFactor != 1) {
				result = result.getScaledInstance((int) Math.ceil(result.getWidth(null) * imageScaleFactor),
						(int) Math.ceil(result.getHeight(null) * imageScaleFactor), Image.SCALE_SMOOTH);
			}

			ColorMapper mapper = new ColorMapper();
			mapper.init(newColorForFormerBlack, newColorForFormerWhite);

			BufferedImage result1 = new BufferedImage(result.getWidth(null), result.getHeight(null),
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics2 = result1.createGraphics();
			graphics2.drawImage(result, 0, 0, null);
			graphics2.dispose();

			BufferedImageOp colorChangeOperation = new LookupOp(mapper, null);
			BufferedImage coloredImage = colorChangeOperation.filter(result1, null);
			result = coloredImage;
		}

		return result;
	}

	protected List<Image> loadSymbolImages(List<PositionedSymbol> symbols, double scaleFactor) throws IOException {
		assert symbols != null : "symbols != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		List<Image> result = new ArrayList<Image>();

		if (!scaleFactorToSymbolImageCache.containsKey(scaleFactor)) {
			Map<Symbol, Image> symbolImageCacheForScaleFactor = new HashMap<Symbol, Image>();
			scaleFactorToSymbolImageCache.put(scaleFactor, symbolImageCacheForScaleFactor);
		}

		Map<Symbol, Image> symbolImageCache = scaleFactorToSymbolImageCache.get(scaleFactor);

		for (PositionedSymbol positionedSymbol : symbols) {
			Symbol symbol = positionedSymbol.getSymbol();

			Image image = null;
			if (symbolImageCache.containsKey(symbol)) {
				image = symbolImageCache.get(symbol);
			} else {
				image = loadSymbolImage(symbol, scaleFactor, positionedSymbol.getLineColor(),
						positionedSymbol.getFillColor());
			}
			// Coloring

			result.add(image);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void drawPositionedSymbols(Graphics2D graphics, List<PositionedSymbol> positionedSymbols,
			double scaleFactor) throws IOException {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		assert scaleFactor <= getMaxScaleFactor() : "Precondition failed: scaleFactor <= getMaxScaleFactor()";

		if (!positionedSymbols.isEmpty()) {
			List<PositionedSymbol> symbols = new ArrayList<PositionedSymbol>();
			for (PositionedSymbol positionedSymbol : positionedSymbols) {
				if (positionedSymbol instanceof PositionedFingerAlphabetSymbol) {
					symbols.addAll(((PositionedFingerAlphabetSymbol) positionedSymbol).getIswaSymbols());
				} else {
					symbols.add(positionedSymbol);
				}
			}

			Comparator<PositionedSymbol> zComparator = new Comparator<PositionedSymbol>() {
				@Override
				public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
					return symbol1.getZ() - symbol2.getZ();
				}
			};
			Collections.sort(symbols, zComparator);

			List<Image> images = loadSymbolImages(symbols, scaleFactor);
			int minX = Integer.MAX_VALUE;
			for (int i = 0, l = symbols.size(); i < l; i++) {
				if (symbols.get(i).getX() < minX) {
					minX = symbols.get(i).getX();
				}
			}

			for (int i = 0, l = symbols.size(); i < l; i++) {
				PositionedSymbol symbol = symbols.get(i);
				if (images.get(i) != null) {
					graphics.drawImage(images.get(i), (int) ((symbol.getX() - minX) * scaleFactor),
							(int) (symbol.getY() * scaleFactor), null);
				}
			}
		}
	}

	private int scaleToInt(int intValue, double scaleFactor) {
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";

		return (int) Math.ceil(scale(intValue, scaleFactor));
	}

	private double scale(int intValue, double scaleFactor) {
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";

		return intValue * scaleFactor;
	}

	private int getLeftOrTop(int center, double widthOrHeight) {
		assert widthOrHeight > 0 : "Precondition failed: widthOrHeight > 0";

		return (int) Math.round(center - (widthOrHeight / 2));
	}

	private int calculateCanvasHeight(List<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";

		int result = 1;

		for (PositionedSymbol positionedSymbol : positionedSymbols) {
			int symbolBottom = positionedSymbol.getY() + positionedSymbol.getSymbol().getHeight();

			if (symbolBottom > result) {
				result = symbolBottom;
			}
		}

		assert result > 0 : "Postcondition failed: result > 0";
		return result;
	}

	private int calculateCanvasWidth(List<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";

		int result = 1;

		for (PositionedSymbol positionedSymbol : positionedSymbols) {
			int symbolRight = positionedSymbol.getX() + positionedSymbol.getSymbol().getWidth();

			if (symbolRight > result) {
				result = symbolRight;
			}
		}

		assert result > 0 : "Postcondition failed: result > 0";
		return result;
	}

	private SignId getCorrectSignId(SignId signId) {
		if (signId.getSignSource().equals(SignSource.UNKNOWN)) {
			// Unknown signSource means that the sign is from signPuddle. First
			// we try if there is an overwritten Sign.
			signId = new SignId(signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale(),
					SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);

			if (!dictionaryService.existsItem(signId)) {
				// If there is no overwritten Sign, then there could be an
				// imported one.
				signId = new SignId(signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale(),
						SignSource.IMPORTED);
			}

			if (!dictionaryService.existsItem(signId)) {
				// If there is no overwritten Sign, then there could be a delegs
				// created one.
				signId = new SignId(signId.getUpperIdPart(), signId.getLowerIdPart(), signId.getSignLocale(),
						SignSource.DELEGS);
			}
		}
		return signId;
	}
}
