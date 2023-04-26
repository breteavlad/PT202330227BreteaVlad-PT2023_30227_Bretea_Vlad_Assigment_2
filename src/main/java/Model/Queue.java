package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue extends Thread {
	private BlockingQueue<Client> queue;
	private AtomicInteger totalClientsProcessed;
	HashSet<Client> averageDoneClients ;
	

	public Queue() {
		queue = new LinkedBlockingQueue();
		averageDoneClients= new HashSet<Client>();
		totalClientsProcessed = new AtomicInteger(0);
	}

	public void enqueue(Client c) throws InterruptedException {
		queue.put(c);
	}

	public void dequeue() throws InterruptedException {
		queue.take();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();
	}

	public Client nextElement() {
		return queue.peek();
	}

	public int getTotalClientsProcessed() {
		return totalClientsProcessed.get();
	}

	public BlockingQueue<Client> queueRet() {
		return this.queue;

	}

	public String toString() {
		String res = "";
		Iterator<Client> listOfClients = queue.iterator();
		while (listOfClients.hasNext()) {
			res += listOfClients.next() + "\n";
		}
		return res;
	}
	
	
	
	public int getAverageWaitingTime() {
		int waitingTime=0;
		int totalWaitingTime=0;
		int OK=0;
		//int prevArrivalTime=-1;
		//int prevServiceTime=0;
		Client prevClient=new Client();
		prevClient.setId(-1);
		prevClient.setArrivalTime(-1);
		prevClient.setServiceTime(0);
		ArrayList<Client> clientList=new ArrayList();
		queue.drainTo(clientList);
		
		if(!clientList.isEmpty()) {
			if(!averageDoneClients.contains(clientList.get(clientList.size()-1))) {
		for(Client c: clientList) {
			if(prevClient.getArrivalTime()!=-1) {
		totalWaitingTime=totalWaitingTime+prevClient.getServiceTime();
		OK++;
		//it starts and already decrements the first service time in the queue so I try to increment it just once
		if(OK==1) {
			totalWaitingTime++;
		}
			}
			prevClient.setArrivalTime(c.getArrivalTime());
			prevClient.setServiceTime(c.getServiceTime());
			prevClient.setId(c.getId());
			}
			averageDoneClients.add(clientList.get(clientList.size()-1));
			}
			else {
				System.out.println("Already done average!");
			}
		}
		
		else {
			System.out.println("is empty");
		}
		
		queue.addAll(clientList);
		System.out.println(totalWaitingTime);
		return totalWaitingTime;
		
	}
	

	public void serveClient() {
		if (!queue.isEmpty()) {
			Client c;
			ArrayList<Client> clientList = new ArrayList();
			c = queue.peek();
			
		
			c.setServiceTime(c.getServiceTime() - 1);
			clientList.add(c);
			try {
				queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queue.drainTo(clientList);
			queue.addAll(clientList);

			if (c.getServiceTime() == 0) {
				queue.remove();
			}
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			clientList.removeAll(clientList);
		}
	}

	public void run() {

		
	}

}
