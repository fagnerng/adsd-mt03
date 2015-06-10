package com.adsd.generator;

public abstract class Generator {
	private int maxValue = 127;
	private int seed;
	/**
	 * default constructor 
	 * @param seed
	 */
	public Generator(int seed){
		this.seed = seed;
	}
	/**
	 * return a unique id/seed of generator
	 * @return
	 */
	protected int getSeed() {
		return seed;
	}
	/**
	 * 
	 * @return current value of multiplicator
	 */
	protected int getMaxvalue() {
		return maxValue;
	}
	/**
	 * return a random integer 
	 * @return random integer
	 */

	public int nextInt() {
		return nextInt(getMaxvalue());
	}
	
	/**
	 * return a random integer with a max value
	 * @return random integer
	 */
	public abstract int nextInt(int maxValue);
	
	public abstract String getMethod();
}
