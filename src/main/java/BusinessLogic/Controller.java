package BusinessLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import GUI.ResultFrame;
import GUI.SimulationFrame;
import Model.Client;
import Model.QueuesManager;


public class Controller {
	private SimulationFrame frame;
	private QueuesManager queuesManager;
	private int simulationTime;
	

	public Controller(final SimulationFrame frame) {
		this.frame = frame;
		frame.addStartListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nrClients, nrQueues;
				final int minService;
				final int maxService;
				int minArrival, maxArrival;
				int simulation;
				double avgServiceTime = 0;
				double avgArrivalTime = 0;
				int prevArrivalTime = -1;
				int prevServiceTime = 0;
				int waitingTime = 0;
				double avgTForQ=0;
				String res="";
				nrClients = Integer.parseInt(frame.getNrClients());
				nrQueues = Integer.parseInt(frame.getNrQueues());
				minService = Integer.parseInt(frame.getMinService());
				maxService = Integer.parseInt(frame.getMaxService());
				minArrival = Integer.parseInt(frame.getMinArrival());
				maxArrival = Integer.parseInt(frame.getMaxArrival());
				simulation = Integer.parseInt(frame.getSimulation());
				double avgWaitingTime = 0;
				int tSimulation = 0;
				ArrayList<Client> clientList = new ArrayList();
					PrintWriter results = null;
					try {
						results = new PrintWriter(new FileWriter("results.txt"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				//PrintWriter results = null;
				/*try {
					Controller.declarePrint(results);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 */

				queuesManager = new QueuesManager(nrQueues);

				for (int j = 0; j < nrQueues; j++) {
					queuesManager.retArrayQ().get(j).start();
				}

				for (int i = 1; i <= nrClients; i++) {
					
					int serviceTime = Utils.getRandomInt(minService, maxService);
					int arrivalTime = Utils.getRandomInt(minArrival, maxArrival);

					Client C = new Client(i, arrivalTime, serviceTime);
					// queuesManager.addClientToQueue(C);
					clientList.add(C);
					System.out.println(C);
					res+=C.toString()+ '\n';
					results.println(C);
				
					// System.out.println(arrivalTime);
					
					avgServiceTime=avgServiceTime+C.getServiceTime();
					

				}
				Collections.sort(clientList);
				int maxQueue = -10;
				int sumAllQueues = 0;
				int peakHour = 0;
				int value=0;
				/*
				for (int i = 0; i < nrClients; i++) {

					if(prevArrivalTime!=-1) {
						waitingTime=clientList.get(i).getArrivalTime()-prevArrivalTime;
					}
					prevArrivalTime=clientList.get(i).getArrivalTime();
					avgWaitingTime=avgWaitingTime+waitingTime;
					// sumAllQueues
					// if(maxQueue<)

				}*/
			
				
				while (tSimulation <= simulation) {
					for (int j = 0; j < nrClients; j++) {
						if (tSimulation == clientList.get(j).getArrivalTime()) {
							//clientList.get(j).setServiceTime(clientList.get(j).getServiceTime()+1);
							queuesManager.addClientToQueue(clientList.get(j));
						}
						// System.out.println("At time " +tSimulation + " clients: " +
						// clientList.get(j));

					}
					
				
					for (int i = 0; i < nrQueues; i++) {
						
						System.out.println("At time " + tSimulation + " there are: "
								+ queuesManager.getQueue(i).toString() + "in queue number " + (i + 1));
						results.println("At time " + tSimulation + " there are: "
								+ queuesManager.getQueue(i).toString() + "in queue number " + (i + 1));
						queuesManager.getQueue(i).serveClient();
						avgWaitingTime=avgWaitingTime+queuesManager.getQueue(i).getAverageWaitingTime();
						res+="At time " + tSimulation + " there are: "
								+ queuesManager.getQueue(i).toString() + "in queue number " + (i + 1) + '\n';
						
						
					}
					/*
					for(int i=0;i<nrQueues;i++) {
						avgWaitingTime=avgWaitingTime+queuesManager.getQueue(i).getAverageWaitingTime();
					}
*/
					if (queuesManager.getTotalClientsInQueues() > maxQueue) {
						maxQueue = queuesManager.getTotalClientsInQueues();
						peakHour = tSimulation;
					}

					tSimulation++;
				}
			

				// System.out.println(avgWaitingTime);
				// for(Queue q:queuesManager.)
			
			
				avgWaitingTime = avgWaitingTime / nrClients;
				avgServiceTime = avgServiceTime / nrClients;
				System.out.println("Average waiting time: " + avgWaitingTime);
				System.out.println("Average service time: " + avgServiceTime);
				System.out.println("Peak hour: " + peakHour);
				results.println("Average waiting time: " + avgWaitingTime);
				results.println("Average service time: " + avgServiceTime);
				results.println("Peak hour: " + peakHour);
				results.close();
				res+="Average waiting time: " + avgWaitingTime + '\n';
				res+="Average service time: " + avgServiceTime+'\n';
				res+="Peak hour: " + peakHour+'\n';
				//System.out.println(" This is res: " + res);
				
				ResultFrame resView = new ResultFrame();
				resView.setVisible(true);

				frame.setVisible(false);
				frame.dispose();
				resView.updateResultText(res);
			}

		});
	}
	
	public static void declarePrint(PrintWriter results) throws IOException {
		 results=new PrintWriter(new FileWriter("results.txt"));
	}
}
