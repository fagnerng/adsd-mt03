package com.adsd.generator;

public class GeneratorMixed extends Generator{
	private static final String type= "misto";
	private int value1, value2, count, multiply;
	public GeneratorMixed(int seed, int multiply ) {
		super(seed);
		this.value1 = seed;
		this.value2 = seed;
		this.count = 1;
		this.multiply = multiply;
		
	}

	

	@Override
	public int nextInt(int maxValue) {
		int tempValue =( count++ +(this.value1 + this.value2) * multiply )% maxValue;
		this.value1 = this.value2;
		this.value2 = tempValue;
		return tempValue;
	}
	@Override
	public String getMethod() {
		
		return type;
	}

}
