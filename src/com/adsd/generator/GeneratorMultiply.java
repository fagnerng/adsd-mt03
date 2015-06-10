package com.adsd.generator;

public class GeneratorMultiply extends Generator {
	private int multiply;
	private int lastValue;
	private static final String type= "multiplicativo";
	public GeneratorMultiply(int seed, int multiply) {
		super(seed);
		this.lastValue = seed;
		this.setMultiply(multiply);
	}

	@Override
	public int nextInt(int maxValue) {
		lastValue = (lastValue++ * getMultiply()) % maxValue;
		
		return lastValue;
	}

	public int getMultiply() {
		return multiply;
	}

	public void setMultiply(int multiply) {
		this.multiply = multiply;
	}
	@Override
	public String getMethod() {
		
		return type;
	}
	

}
