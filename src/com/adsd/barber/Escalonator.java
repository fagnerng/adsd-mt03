package com.adsd.barber;

import com.adsd.generator.Generator;

public class Escalonator implements Runnable{
	private BarberShop mBarber;
	private Client newClient;
	private int officeHours, queue;
	private Generator mGenerator;
	
	private long startTime;
	
	
	public Escalonator(BarberShop Barber, Generator generator, int officeHours) {
		this.mBarber = Barber;
		this.officeHours = officeHours;
		this.mGenerator = generator;
		this.queue = 0;
	}


	@Override
	public void run() {
		startTime = System.currentTimeMillis();
     	while(!isDone())
		{
			int durationToComplete = mGenerator.nextInt();
			newClient = new Client(++queue, durationToComplete);
			mBarber.addNewClient(newClient);
			int timeToNextClient = mGenerator.nextInt() * 50;
			long currentTime = System.currentTimeMillis();
			while(System.currentTimeMillis() < currentTime + timeToNextClient * 100);
		}
		System.out.println("Close for business");
		
	}
	
	Boolean isDone(){
		return System.currentTimeMillis() > hourToClose(); 
		
	}
	
	long hourToClose(){
		return startTime + officeHours * 1000 * 60;
	}

}
