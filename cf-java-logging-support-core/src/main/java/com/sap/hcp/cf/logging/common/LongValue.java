package com.sap.hcp.cf.logging.common;

/**
 * A {@link Value} implementation representing a <i>long</i> value.
 *  
 * @author d029740
 *
 */
public class LongValue implements Value {

	private long value;
	
	public LongValue(final long value) {
		this.value = value;
	}

	public LongValue(Object value) {
		if (value != null && Long.class.isAssignableFrom(value.getClass())) {
			this.value = ((Long) value).longValue();
		}
		else {
			this.value = -1L;
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public Object getValue() {
		return Long.valueOf(value);
	}

	public long asLong() {
		return value;
	}

	public double asDouble() {
		return value;
	}

	public String asString() {
		return toString();
	}
}
