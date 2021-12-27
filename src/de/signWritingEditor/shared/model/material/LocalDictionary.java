package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.PersistenceLocation;
import de.signWritingEditor.shared.model.domainValue.SignId;

public class LocalDictionary implements Serializable {

	private static final long serialVersionUID = -49573823074301179L;
	// Implementation type HashMap is required for correct Gson integration,
	// otherwise Gson chooses LinkedTreeMap, which is incompatible with GWT.
	private HashMap<String, List<SimpleSign>> dictionary;

	public LocalDictionary() {
		dictionary = new HashMap<String, List<SimpleSign>>();
	}

	public void save(SimpleSign sign) {
		assert sign.getSignId()
				.getLowerIdPart() != null : "Precondition failed: sign.getSignId().getLowerIdPart() != null";
		assert !sign.getSignId().getLowerIdPart()
				.isEmpty() : "Precondition failed: !sign.getSignId().getLowerIdPart().isEmpty()";
		assert sign != null : "sign != null";
		assert !contains(sign.getSignId()) : "Precondition failed: !contains(" + sign.getSignId() + ")";

		String key = sign.getSignId().getLowerIdPart();

		if (dictionary.keySet().contains(key)) {
			dictionary.get(key).add(sign.clone());
		} else {
			ArrayList<SimpleSign> signs = new ArrayList<SimpleSign>();
			signs.add(sign.clone());
			dictionary.put(key, signs);
		}

		sign.setPersistenceLocation(PersistenceLocation.LOCAL_DICTIONARY);

		assert contains(sign.getSignId()) : "Postcondition failed: contains(sign.getSignId())";
	}

	public void update(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";
		assert contains(sign.getSignId()) : "Precondition failed: contains(" + sign.getSignId() + ")";

		for (List<SimpleSign> signList : dictionary.values()) {
			int signIndex = signList.indexOf(sign);
			if (signIndex != -1) {
				signList.set(signIndex, sign.clone());
				sign.setPersistenceLocation(PersistenceLocation.LOCAL_DICTIONARY);
				break;
			}
		}
	}

	public void remove(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert contains(signId) : "Precondition failed: contains(signId)";

		for (List<SimpleSign> signList : dictionary.values()) {
			for (int i = 0, l = signList.size(); i < l; i++) {
				if (signId.equals(signList.get(i).getSignId())) {
					signList.remove(i);
					break;
				}
			}
		}

		assert !contains(signId) : "Postcondition failed: !contains(signId)";
	}

	public List<SignItem> findSignsIgnoreCase(String word) {
		assert word != null : "text != null";

		List<SignItem> result = new ArrayList<SignItem>();

		Set<String> keySet = dictionary.keySet();
		for (String key : keySet) {
			if (key.equalsIgnoreCase(word)) {
				for (SimpleSign sign : dictionary.get(key)) {
					sign.setPersistenceLocation(PersistenceLocation.LOCAL_DICTIONARY);
					result.add(new SignItem(sign));
				}
			}
		}

		return result;
	}

	public SimpleSign getSign(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert contains(signId) : "Precondition failed: contains(signId)";

		SimpleSign result = null;

		for (List<SimpleSign> signList : dictionary.values()) {
			for (SimpleSign sign : signList) {
				if (sign.getSignId().equals(signId)) {
					result = sign.clone();
					result.setPersistenceLocation(PersistenceLocation.LOCAL_DICTIONARY);
					break;
				}
			}
		}
		assert result != null : "Postcondition failed: result != null";

		return result;
	}

	public boolean contains(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		boolean result = false;

		for (List<SimpleSign> signs : dictionary.values()) {
			for (SimpleSign sign : signs) {
				result |= sign.getSignId().equals(signId);
				if (result) {
					break;
				}
			}
		}

		return result;
	}

	public boolean isEmpty() {
		return this.dictionary.isEmpty();
	}

	public Set<Entry<String, List<SimpleSign>>> getEntries() {
		return Collections.unmodifiableSet(dictionary.entrySet());
	}

	public Set<String> getKeyWords() {
		return Collections.unmodifiableSet(dictionary.keySet());
	}

	@Override
	public int hashCode() {
		return dictionary.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other == this;
		if (!result && other != null && other.getClass().equals(getClass())) {
			LocalDictionary otherLocalDictionary = (LocalDictionary) other;

			result = hashMapsAreEqual(otherLocalDictionary.dictionary, dictionary);
		}
		return result;
	}

	private boolean hashMapsAreEqual(HashMap<String, List<SimpleSign>> dictionary1,
			HashMap<String, List<SimpleSign>> dictionary2) {
		if (dictionary1.size() == dictionary2.size()) {

			Set<Entry<String, List<SimpleSign>>> dictonary1Set = dictionary1.entrySet();
			Iterator<Entry<String, List<SimpleSign>>> i = dictonary1Set.iterator();
			while (i.hasNext()) {
				Entry<String, List<SimpleSign>> signCollection1 = i.next();

				List<SimpleSign> signCollection2 = dictionary2.get(signCollection1.getKey());

				for (SimpleSign sign : signCollection1.getValue()) {
					if (!signCollection2.contains(sign)) {
						return false;
					}
				}

			}
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("LocalDictionary(\n");

		for (Map.Entry<String, List<SimpleSign>> entry : dictionary.entrySet()) {
			sb.append(entry.getKey());
			sb.append(" : ");

			List<SimpleSign> signs = entry.getValue();
			for (int i = 0; i < signs.size(); i++) {
				if (i != 0)
					sb.append(", ");
				sb.append(signs.get(i));
			}

			sb.append("\n");
		}

		sb.append(")");

		return sb.toString();
	}
}