package Model;

import java.util.ArrayList;

public class QueuesManager {
	private ArrayList<Queue> queues;
	private int numberOfQueues;

	public QueuesManager(int numberOfQueues) {
		this.numberOfQueues = numberOfQueues;
		queues = new ArrayList();
		for (int i = 0; i < numberOfQueues; i++) {
			queues.add(new Queue());
		}
	}

	public void addClientToQueue(Client client) {
		// find the shortest queue in which to add the client.
		int shortestQueueIndex = 0;
		int shortestQueueSize = 100;
		for (int i = 0; i < numberOfQueues; i++) {
			if (queues.get(i).size() < shortestQueueSize) {
				shortestQueueIndex = i;
				shortestQueueSize = queues.get(i).size();
			}
		}
		try {
			queues.get(shortestQueueIndex).enqueue(client);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// queues.get(shortestQueueIndex).start();
	}

	public boolean allQueuesEmpty() {
		for (Queue q : queues) {
			if (!q.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public int getNumberOfQueues() {
		return numberOfQueues;
	}

	public int getTotalClientsInQueues() {
		int totalClients = 0;
		for (Queue q : queues) {
			totalClients += q.size();
		}
		return totalClients;
	}

	public Queue getQueue(int index) {
		return queues.get(index);
	}

	public ArrayList<Queue> retArrayQ() {
		return queues;
	}

}
