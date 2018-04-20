package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gui.JFrameMain;
import models.Concurrence;
import models.ConstantsModels;
import models.Terminal;

public class Controller implements ActionListener {
	private static Controller controller;
	private Terminal terminal;
	private JFrameMain frameMain;
	private int speed;
	private Timer timerTerminal;
	private Timer timerTicketOffice;

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

	}

	private void initSimulation() {
		terminal.setConcurrence(Concurrence.HIGH);
		this.speed = 1000;
		timerTerminal = new Timer(speed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startOfTerminal();
			}
		});
		timerTerminal.start();
		startOperationLockers();
	}

	private void startOperationLockers() {
		timerTicketOffice = new Timer(ConstantsModels.SPEED_TICKER_OFFICE, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				terminal.atendAllTickets();
				terminal.verifyBusesTickets();
				frameMain.repaint();
			}
		});
		timerTicketOffice.start();
	}

	private void startOfTerminal() {
		terminal.createPassengers();
		frameMain.repaint();
		int passengersIn = (int) (Math.random() * ConstantsModels.PASSENGERS_IN_TERMINAL);
		for (int i = 0; i < passengersIn; i++) {
			terminal.sendToTicketOffice();
		}
	}

	private void stopSimulation() {
		timerTerminal.stop();
		timerTicketOffice.stop();
	}
}
