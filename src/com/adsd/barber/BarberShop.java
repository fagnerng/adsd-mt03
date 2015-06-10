package com.adsd.barber;

import java.util.LinkedList;

import org.joda.time.Instant;

import com.adsd.util.Logger;

public class BarberShop implements Runnable {

	private final LinkedList<Client> mClients;
	private int mCurrentId;
	private Instant timeToEnd;
	public BarberShop(final int timeDuration) {
		mClients = new LinkedList<Client>();
		mCurrentId = 1;
		timeToEnd = Instant.now().plus(timeDuration * 1000);
	}

	public void addNewClient(final Client client) {
		if (!isDone()) {
			client.setId(mCurrentId++);
			mClients.add(client);
			Logger.log("NEW CLIENT ARRIVE", client.getId()+"");
		}
	}

	@Override
	public void run() {
		Logger.log("OPEN FOR BUSINESS");

		while (!isDone() || mClients.size()>0 ) {

			while (mClients.size() <= 0) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			cutHairOfClient();
			Logger.log("CURRENT QUEUE", getListOfClients());
		}
		Logger.log("END");
	}

	public void cutHairOfClient() {
		final Client c = mClients.pop();
		c.setTimeToFinish(Instant.now().plus(c.getDuration()));

		Logger.log("CLIENT ON CUT ", "" + c.getId());
		while (Instant.now().getMillis() < c.getTimeToFinish().getMillis());
		Logger.log("CLIENT DONE", ""+c.getId());
		

	}

	public boolean isDone() {

		return Instant.now().getMillis() > timeToEnd.getMillis();
	}

	public String getListOfClients() {

		String clientList = "[";

		for (int i = 0; i < mClients.size(); i++) {
			clientList += mClients.get(i).getId();
			if (i != mClients.size() - 1)
				clientList += ",";

		}
		clientList += "]";
		return clientList;
	}
}
