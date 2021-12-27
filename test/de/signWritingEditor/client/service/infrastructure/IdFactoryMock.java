package de.signWritingEditor.client.service.infrastructure;

import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import static org.junit.Assert.fail;

public class IdFactoryMock extends IdFactory {

	private static final long UPPER_ID = 0;
	private static final long LOWER_ID = 1234567;

	public IdFactoryMock() {
		super(0);
	}

	@Override
	public Id createId() {
		return new Id(UPPER_ID, LOWER_ID);
	}

	@Override
	public Id reconstructId(long upperIdPart, long lowerIdPart) {
		fail("Not implemented");
		return null;
	}
}
