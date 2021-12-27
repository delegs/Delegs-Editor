package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomPolicy implements Serializable {
	public final static RoomPolicy INDIVIDUAL_CONTENT = new RoomPolicy("individualContent");
	public final static RoomPolicy COLLECTIVE_CONTENT = new RoomPolicy("collectiveContent");
	public final static RoomPolicy SHARED_CONTENT = new RoomPolicy("sharedContent");
	public final static RoomPolicy SHOWROOM = new RoomPolicy("showroom");

	private static List<RoomPolicy> values;

	static {
		List<RoomPolicy> list = new ArrayList<RoomPolicy>();
		list.add(COLLECTIVE_CONTENT);
		list.add(SHARED_CONTENT);
		list.add(INDIVIDUAL_CONTENT);
		list.add(SHOWROOM);
		values = Collections.unmodifiableList(list);
	}

	private String value;

	private RoomPolicy(String policy) {
		value = policy;
	}

	@Deprecated
	private RoomPolicy() {

	}

	public static RoomPolicy getRoomPolicy(String roomPolicyString) {
		assert roomPolicyString != null : "Precondition failed: roomPolicyString != null";
		assert !roomPolicyString.equals("") : "Precondition failed: !roomPolicyString.equals(\"\")";

		RoomPolicy result = null;

		if (roomPolicyString.equalsIgnoreCase(COLLECTIVE_CONTENT.value)) {
			result = RoomPolicy.COLLECTIVE_CONTENT;
		} else if (roomPolicyString.equalsIgnoreCase(SHARED_CONTENT.value)) {
			result = RoomPolicy.SHARED_CONTENT;
		} else if (roomPolicyString.equalsIgnoreCase(INDIVIDUAL_CONTENT.value)) {
			result = RoomPolicy.INDIVIDUAL_CONTENT;
		} else if (roomPolicyString.equalsIgnoreCase(SHOWROOM.value)) {
			result = RoomPolicy.SHOWROOM;
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public String toString() {
		return value;
	}

	public static final List<RoomPolicy> values() {
		return values;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		RoomPolicy other = (RoomPolicy) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}