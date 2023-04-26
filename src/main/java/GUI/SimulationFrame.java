package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimulationFrame extends JFrame {

	private JPanel thePanel;
	private JTextField textField_Clients;
	private JTextField textField_Queues;
	private JTextField textField_Simulation;
	private JTextField textField_MinService;
	private JTextField textField_MaxService;
	private JTextField textField_MinArrival;
	private JTextField textField_MaxArrival;
	private JButton Start;
	private JLabel tSimulation;
	private JLabel tMinService;
	private JLabel tMaxService;
	private JLabel tMaxArrival;

	private JLabel tMinArrival;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SimulationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 524);
		thePanel = new JPanel();
		thePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(thePanel);
		thePanel.setLayout(null);

		textField_Clients = new JTextField();
		textField_Clients.setBounds(133, 23, 96, 20);
		thePanel.add(textField_Clients);
		textField_Clients.setColumns(10);

		JLabel NrClients = new JLabel("ClientNumber");
		NrClients.setBounds(18, 26, 89, 14);
		thePanel.add(NrClients);

		textField_Queues = new JTextField();
		textField_Queues.setBounds(133, 76, 96, 20);
		thePanel.add(textField_Queues);
		textField_Queues.setColumns(10);

		JLabel NrQueues = new JLabel("QueueNumber");
		NrQueues.setBounds(10, 79, 97, 14);
		thePanel.add(NrQueues);

		textField_Simulation = new JTextField();
		textField_Simulation.setBounds(133, 150, 96, 20);
		thePanel.add(textField_Simulation);
		textField_Simulation.setColumns(10);

		textField_MinService = new JTextField();
		textField_MinService.setBounds(133, 226, 96, 20);
		thePanel.add(textField_MinService);
		textField_MinService.setColumns(10);

		textField_MaxService = new JTextField();
		textField_MaxService.setBounds(133, 303, 96, 20);
		thePanel.add(textField_MaxService);
		textField_MaxService.setColumns(10);

		textField_MinArrival = new JTextField();
		textField_MinArrival.setBounds(133, 377, 96, 20);
		thePanel.add(textField_MinArrival);
		textField_MinArrival.setColumns(10);

		textField_MaxArrival = new JTextField();
		textField_MaxArrival.setBounds(133, 440, 96, 20);
		thePanel.add(textField_MaxArrival);
		textField_MaxArrival.setColumns(10);

		tSimulation = new JLabel("SimulationTime");
		tSimulation.setBounds(10, 153, 121, 14);
		thePanel.add(tSimulation);

		tMinService = new JLabel("tMinService");
		tMinService.setBounds(32, 229, 75, 14);
		thePanel.add(tMinService);

		tMaxService = new JLabel("tMaxService");
		tMaxService.setBounds(32, 306, 75, 14);
		thePanel.add(tMaxService);

		tMinArrival = new JLabel("tMinArrival");
		tMinArrival.setBounds(32, 380, 66, 14);
		thePanel.add(tMinArrival);

		tMaxArrival = new JLabel("tMaxArrival");
		tMaxArrival.setBounds(32, 440, 75, 14);
		thePanel.add(tMaxArrival);

		Start = new JButton("Start");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Start.setBounds(465, 225, 89, 23);
		thePanel.add(Start);

		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(413, 306, 170, 43);
		thePanel.add(resultLabel);
	}

	public void addStartListener(ActionListener actionListener) {
		this.Start.addActionListener(actionListener);

	}

	public String getNrClients() {
		return this.textField_Clients.getText();
	}

	public String getNrQueues() {
		return this.textField_Queues.getText();
	}

	public String getMinService() {
		return this.textField_MinService.getText();
	}

	public String getMaxService() {
		return this.textField_MaxService.getText();
	}

	public String getMinArrival() {
		return this.textField_MinArrival.getText();
	}

	public String getMaxArrival() {
		return this.textField_MaxArrival.getText();
	}

	public String getSimulation() {
		return this.textField_Simulation.getText();
	}

}