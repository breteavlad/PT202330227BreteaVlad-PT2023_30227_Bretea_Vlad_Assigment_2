package Model;

import java.util.ArrayList;
import java.util.List;

public class Client implements Comparable<Client> {
	private int id;
	private int arrivalTime;
	private int serviceTime;
	private int totalTime;
	private static List<Client> clients = new ArrayList();
	

	public Client() {

	}

	public Client(int id, int arrivalTime, int serviceTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		clients.add(this);
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public void addTime(int time) {
		totalTime += time;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public boolean contains(Client c) {
		return clients.contains(c);
	}

	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		if (this.arrivalTime > o.arrivalTime) {
			return 1;
		} else if (this.arrivalTime < o.arrivalTime) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return "Arrival time: " + this.arrivalTime + " service time: " + this.serviceTime + "id: " + this.id;
	}



}
