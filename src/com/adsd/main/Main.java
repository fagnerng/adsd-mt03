
package com.adsd.main;

import com.adsd.barber.BarberShop;
import com.adsd.barber.Escalonator;
import com.adsd.generator.GeneratorMixed;

/**
 * The Class Main2 is used to simply run without passing args on terminal.
 */
public class Main {

	static BarberShop mBarbearia;
	static Escalonator  mEscalonador;
     public static void main(final String[] args) {
    	 
    	 final int timeDuration = 1;
    	 
    	 mBarbearia = new BarberShop(timeDuration);
         mEscalonador = new Escalonator(mBarbearia, new GeneratorMixed(23, 43), timeDuration);
         new Thread(mEscalonador).start();
         new Thread(mBarbearia).start();
     }
}
