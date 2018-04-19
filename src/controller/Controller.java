package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gui.JFrameMain;
import models.Concurrence;
import models.Terminal;

public class Controller implements ActionListener {
	private static Controller controller;
	private Terminal terminal;
	private JFrameMain frameMain;
	private int speed;
	private Timer timer;

	private Controller() {

	}

	public static Controller getInstance() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public void initComponents() {
		terminal = new Terminal("Terminal de Paipa :v");
		frameMain = new JFrameMain(terminal);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Commands.valueOf(event.getActionCommand())) {
		case INIT_SIMULATION:
			initSimulation();
			break;
			
		case STOP_SIMULATION:
			stopSimulation();
			break;
			
		case GENERATE_REPORT: 
			generateReport();
			break;
		default:
			break;
		}
	}

	private void generateReport() {
		// TODO Auto-generated method stub
		
	}

	private void initSimulation() {
		terminal.setConcurrence(Concurrence.LOW);
		this.speed = 1000;
		timer = new Timer(speed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				terminal.createPassengers();
			}
		});
		timer.start();
	}
	
	private void stopSimulation() {
		timer.stop();
	}
}
