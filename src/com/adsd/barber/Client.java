package com.adsd.barber;

import org.joda.time.Instant;

public class Client {
	private int id;
	private final int duration;
    private Instant timeToFinish;
	public Client( final int durationToComplete){
		
		this.duration = durationToComplete;
	}
	public int getId() {
		return id;
	}

	public Instant getTimeToFinish() {
		// TODO Auto-generated method stub
		return timeToFinish;
	}
	public int getDuration() {
		return duration;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public void setTimeToFinish(Instant plus) {
		// TODO Auto-generated method stub
		timeToFinish = plus;
	}

}
