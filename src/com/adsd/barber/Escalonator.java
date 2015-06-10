package com.adsd.barber;

import org.joda.time.Instant;

import com.adsd.generator.Generator;


public class Escalonator implements Runnable{

    private final BarberShop mBarberShop;
    private final Generator mGenerator;

    public Escalonator(final Generator gerador, final int timeToWork) {
        mBarberShop = new BarberShop(timeToWork);
        mGenerator = gerador;
    }

    @Override
    public void run() {
    	new Thread(mBarberShop).start();
        while (!mBarberShop.isDone()) {
        	Client client = new Client(mGenerator.nextInt()*10);
            waitToArriveNextClient();
            mBarberShop.addNewClient(client);
        }
    }
    void waitToArriveNextClient(){
        final Instant timeToArrive = Instant.now().plus(mGenerator.nextInt()*10);
        while (Instant.now().getMillis() < timeToArrive.getMillis());
    }

}
