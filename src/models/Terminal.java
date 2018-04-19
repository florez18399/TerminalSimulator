package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import persistence.FilesTerminal;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;
	private FilesTerminal filesTerminal;
	private int speed;
	private Concurrence concurrence;

	public Terminal(String name) {
		this.name = name;
		filesTerminal = new FilesTerminal();
		loadQueueBuses();
		loadTicketOffices();
		showTicketOffices();
	}

	public void loadTicketOffices() {
		listTicketOffice = new MyLinkedList<TicketOffice>(new LockersComparator());
		ArrayList<String> listDestinations = filesTerminal.getListDestinations();
		for (String destination : listDestinations) {
			createTicketOffice(destination);
		}
	}

	private void createTicketOffice(String destination) {
		String vecDestiny[] = destination.split("/");
		Destiny destiny = new Destiny(vecDestiny[0], Integer.parseInt(vecDestiny[1]), Integer.parseInt(vecDestiny[2]));
		TicketOffice ticketOffice = new TicketOffice(destiny);
		listTicketOffice.addNode(new Node<TicketOffice>(ticketOffice));
	}

	public void createPassengers() {
		switch (concurrence) {
		case HIGH:
			System.out.println("Crea 15 personas");
			break;
		case MEDIUM:
			System.out.println("Crea 10 personas");
			break;
		case LOW:
			System.out.println("Crea 5 personas");
			break;

		default:
			break;
		}
	}

	public void showTicketOffices() {
		listTicketOffice.showList();
	}

	public void loadQueueBuses() {
		System.out.println("Leer archivo de buses");
		queueTotalBuses = new MyQueue<Bus>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<TicketOffice> getListTicketOffice() {
		return listTicketOffice;
	}

	public MyQueue<Bus> getQueueTotalBuses() {
		return queueTotalBuses;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Concurrence getConcurrence() {
		return concurrence;
	}

	public void setConcurrence(Concurrence concurrence) {
		this.concurrence = concurrence;
	}

}
