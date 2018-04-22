package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private Timer timerBuses;

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
		timerTerminal = new Timer(terminal.getConcurrence().getTimeCreation(), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startOfTerminal();
			}
		});
		timerTerminal.start();
		startOperationLockers();
	}

	private void startOfTerminal() {
		terminal.createPassenger();
		frameMain.repaint();
		int passengersIn = (int) (Math.random() * ConstantsModels.PASSENGERS_IN_TERMINAL);
		for (int i = 0; i < passengersIn; i++) {
			terminal.sendToTicketOffice();
		}
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
		startOperationBuses();
	}

	private void startOperationBuses() {
		timerBuses = new Timer(150, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				terminal.moveBuses();
				frameMain.repaint();
			}
		});
		timerBuses.start();
	}

	private void stopSimulation() {
		timerTerminal.stop();
		timerTicketOffice.stop();
		timerBuses.stop();
	}

}
