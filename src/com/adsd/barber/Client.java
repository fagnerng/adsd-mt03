package com.adsd.barber;

public class Client {
	private int id,durationToComplete;
	public Client(int id, int durationToComplete){
		this.id = id;
		this.durationToComplete = durationToComplete;
	}
	public int getId() {
		return id;
	}
	public int getDurationToComplete() {
		return durationToComplete;
	}

}
