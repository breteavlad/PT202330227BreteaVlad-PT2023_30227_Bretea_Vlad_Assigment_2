package MainClass;

import BusinessLogic.Controller;
import GUI.SimulationFrame;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimulationFrame frame = new SimulationFrame();
		frame.setVisible(true);
		Controller controller = new Controller(frame);

	}

}
