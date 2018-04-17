package models;

import java.util.ArrayList;

import persistence.FileManager;
import persistence.FilesTerminal;
import persistence.OpenForm;

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
	}

	public void loadQueueBuses() {
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

	public void loadTicketOffices() {
	}

}
