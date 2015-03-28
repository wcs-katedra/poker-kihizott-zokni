package com.wc.poker.strategy.preflop.enums;

/**
 *
 * @author Horváth Dániel
 */
public enum Multiplier {
	FIVE(0.05), TEN(0.1), FIFTEEN(0.15), TWENTY(0.2);
	
	private double value;
	private Multiplier(double value) {
		this.value = value;
	}
	
	public double getMultiplier() {
		return value;
	}
}
