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

	private Controller() {

	}

	public static Controller getInstance() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public void initComponents() {
		terminal = new Terminal("Terminal de Paipa");
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
		concurrence = frameMain.getConcurrence();
		frameMain.showSimulator();
		timerTerminal = new Timer(concurrence.getTimeCreation(), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startOfTerminal();
			}
		});
		timerTerminal.start();
		startMovePersons();
		startOperationLockers();
	}

	private void startMovePersons() {
		timerPersons = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				terminal.movePersons();
				frameMain.repaint();
			}
		});
		timerPersons.start();
	}

	private void startOfTerminal() {
		terminal.createPassenger();
		frameMain.repaint();
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
		timerPersons.stop();
	}

}
