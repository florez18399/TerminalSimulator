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
	private Timer timerTerminal;
	private Timer timerTicketOffice;
	private Timer timerBuses;
	private Timer timerPersons;
	private Concurrence concurrence;
	private int speedSimulation;

	private Controller() {

	}

	public static Controller getInstance() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public void initComponents() {
		terminal = new Terminal(ConstantsModels.NAME_TERMINAL);
		frameMain = new JFrameMain(terminal);
		try {
			frameMain.showSplash();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		createTimers();
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
		case SHOW_ABOUT:
			frameMain.showDialogAbout();
			break;

		case RESET_SIMULATION:
			resetSimulation();
			break;
		default:
			break;
		}
	}

	private void resetSimulation() {
		stopSimulation();
		terminal = new Terminal("Terminal de Paipa");
		frameMain.setTerminal(terminal);
		frameMain.repaint();
		initSimulation();
	}

	private void generateReport() {
		stopSimulation();
		frameMain.showReport();
	}

	private void initSimulation() {
		timerTerminal.start();
		timerPersons.start();
		timerTicketOffice.start();
		timerBuses.start();
		frameMain.showSimulator();
	}

	private void createTimers() {
		concurrence = frameMain.getConcurrence();
		speedSimulation = frameMain.getSpeedSimulation() + 1;
		System.out.println(speedSimulation);
		frameMain.showSimulator();
		timerTerminal = new Timer(concurrence.getTimeCreation(), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startOfTerminal();
				verifyTimers();
			}

		});
		startMovePersons();
		startOperationLockers();
	}

	private void verifyTimers() {
		if (frameMain.getSpeedSimulation() != speedSimulation) {
			speedSimulation = frameMain.getSpeedSimulation() + 1;
			timerBuses.setDelay(ConstantsModels.DIVISOR_TIMER_BUSES * 50 / speedSimulation);
			timerPersons.setDelay(ConstantsModels.DIVISOR_TIMER_PERSONS * 50 / speedSimulation);
			timerTicketOffice.setDelay(ConstantsModels.DIVISOR_TIMER_TICKETS * 50 / speedSimulation);
		}
	}

	private void startMovePersons() {
		timerPersons = new Timer(ConstantsModels.DIVISOR_TIMER_PERSONS * 50 / speedSimulation, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				terminal.movePersons();
				frameMain.repaint();
			}
		});
	}

	private void startOfTerminal() {
		terminal.createPassenger();
		frameMain.repaint();
	}

	private void startOperationLockers() {
		timerTicketOffice = new Timer(ConstantsModels.DIVISOR_TIMER_TICKETS * 50 / speedSimulation,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						terminal.atendAllTickets();
						terminal.verifyBusesTickets();
						frameMain.repaint();
						verifyConcurrence();
					}
				});
		startOperationBuses();
	}

	private void verifyConcurrence() {
		if (!concurrence.equals(frameMain.getConcurrence())) {
			concurrence = frameMain.getConcurrence();
			timerTerminal.setDelay(concurrence.getTimeCreation());
		}
	}

	private void startOperationBuses() {
		timerBuses = new Timer(ConstantsModels.DIVISOR_TIMER_BUSES * 50 / speedSimulation, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				terminal.moveBuses();
				frameMain.repaint();
			}
		});
	}

	private void stopSimulation() {
		timerTerminal.stop();
		timerTicketOffice.stop();
		timerBuses.stop();
		timerPersons.stop();
	}

}
