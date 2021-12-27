package de.signWritingEditor.client.model.material;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.SignIdFactory;

public class SignIdFactoryTest {

	@Test
	public void defaultTest() {
		SignIdFactory localSignIdFactory = new SignIdFactory();

		SignId firstId = new SignId(1, "test", SignLocale.DGS, SignSource.DELEGS);

		List<SignId> existingIds = new ArrayList<SignId>();
		existingIds.add(firstId);

		for (int i = 0; i < 10000; i++) {
			SignId newSignId = localSignIdFactory.createNewSignIdFrom(firstId);

			for (SignId signId : existingIds) {
				assertFalse(signId.equals(newSignId));
			}
			assertFalse(firstId.getUpperIdPart() == newSignId.getUpperIdPart());
			assertEquals(firstId.getLowerIdPart(), newSignId.getLowerIdPart());
			assertEquals(firstId.getSignLocale(), newSignId.getSignLocale());
			assertEquals(firstId.getSignSource(), newSignId.getSignSource());

			existingIds.add(newSignId);
		}
	}
}
