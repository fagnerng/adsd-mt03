package com.adsd.barber;

import java.util.LinkedList;

public class BarberShop implements Runnable {
	LinkedList<Client> clientList;
	private int officeHours;
	private long startTime;

	public BarberShop(int officeHours) {
		clientList = new LinkedList<Client>();
		this.officeHours = officeHours;
	}

	@Override
	public void run() {
		System.out.println("Open for business:");
		startTime = System.currentTimeMillis();
		while (!isDone()) {
			while (isEmpty())
				waitForNewClient();
			Client currentClient = getNextClient();
			cutHairOfClient(currentClient);
		}
		System.out.println("Close for business:");
	}

	private void cutHairOfClient(Client currentClient) {
		System.out.println("Client(s) on waiting: " + getClientsOnQueue());
		System.out.println("Current Client : " + currentClient.getId());
		long currentTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < currentTime
				+ currentClient.getDurationToComplete()) {

		}

	}

	public Client getNextClient() {
		return clientList.pop();

	}

	public void addNewClient(Client newClienet) {
		System.out.println("New client arrived, queue: " + newClienet.getId());

		if (newClienet != null)
			clientList.add(newClienet);

		System.out.println("Client(s) on waiting: " + getClientsOnQueue());
	}

	public Boolean isEmpty() {
		if (clientList == null)
			clientList = new LinkedList<Client>();
		return clientList.isEmpty();

	}

	public void waitForNewClient() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getClientsOnQueue() {
		String allClients = "[";
		for (int i = 0; i < clientList.size(); i++) {
			allClients += clientList.get(i).getId();
			if (i != clientList.size() - 1)
				allClients += ",";
		}
		allClients += "]";
		return allClients;

	}

	Boolean isDone() {
		return System.currentTimeMillis() > hourToClose();

	}

	long hourToClose() {
		return startTime + officeHours * 1000 * 60;
	}
}
