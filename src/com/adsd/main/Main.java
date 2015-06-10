
package com.adsd.main;

import java.util.Random;

import com.adsd.barber.Escalonator;
import com.adsd.generator.GeneratorMixed;

/**
 * The Class Main2 is used to simply run without passing args on terminal.
 */
public class Main {

	static Escalonator  mProgram;
     public static void main(final String[] args) {
    	 
    	
    	 Random mRandom = new Random();
    	 final int timeDuration = 1000;
    	 mProgram = new Escalonator(new GeneratorMixed(mRandom.nextInt(100), mRandom.nextInt(100)), timeDuration);
         new Thread(mProgram).start();
         
     }
}
