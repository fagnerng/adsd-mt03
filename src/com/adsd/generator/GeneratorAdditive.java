package com.adsd.generator;

public class GeneratorAdditive extends Generator {
	private int value1, value2;
	private static final String type= "aditivo";
	public GeneratorAdditive(int seed) {
		super(seed);
		value1 = seed;
		value2 = seed;
		
	}

	@Override
	public int nextInt(int maxValue) {
		int tempValue = (value1 + value2) % maxValue;
		value1 = value2;
		value2 = tempValue;
		return tempValue;
	}

	@Override
	public String getMethod() {
		
		return type;
	}
}
