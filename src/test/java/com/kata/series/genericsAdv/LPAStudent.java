package com.kata.series.genericsAdv;

public class LPAStudent extends Student {
	private double percentageComplete;

	public LPAStudent() {
		super();
		percentageComplete = random.nextDouble(0, 100.001);
	}

	@Override
	public String toString() {
		return "LPAStudent [percentageComplete=" + percentageComplete + ", name=" + name + ", course=" + course
				+ ", yearStarted=" + yearStarted + "]";
	}

	public double getPercentageComplete() {
		return percentageComplete;
	}
	

}
