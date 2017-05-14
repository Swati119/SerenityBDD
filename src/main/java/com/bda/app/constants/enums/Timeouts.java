package com.bda.app.constants.enums;

public enum Timeouts {
	FIVE(5), TEN(10), THIRTY(30), SIXTY(60);

	public long	secs;

	/**
	 * Instantiates a new timeouts.
	 *
	 * @param seconds
	 *            the seconds
	 */
	Timeouts(long seconds) {
		this.secs = seconds;
	}
}
