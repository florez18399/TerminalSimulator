package models;

import java.util.ArrayList;
import persistence.FilesTerminal;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;
	private FilesTerminal filesTerminal;

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

	public void showTicketOffices() {
		listTicketOffice.showList();
	}

	public void loadQueueBuses() {
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

}
