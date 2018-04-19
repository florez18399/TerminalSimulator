package models;

import java.util.ArrayList;
import persistence.FilesTerminal;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;
	private FilesTerminal filesTerminal;
	private Concurrence concurrence;
	private MyQueue<Passenger> incoming;

	public Terminal(String name) {
		this.name = name;
		filesTerminal = new FilesTerminal();
		incoming = new MyQueue<Passenger>();
		loadQueueBuses();
		loadTicketOffices();
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
		createPassengers(concurrence.getMax());
	}

	private void createPassengers(int max) {
		int created = (int) (Math.random() * max);
		int i = 0;
		while (i < created) {
			incoming.enqueue(new Node<Passenger>(createPassenger()));
			i++;
		}
	}

	private Passenger createPassenger() {
		int idDestiny = ((int) (Math.random() * listTicketOffice.size()));
		Passenger passenger = new Passenger(listTicketOffice.get(idDestiny).getInfo().getDestiny());
		return passenger;
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

	public Concurrence getConcurrence() {
		return concurrence;
	}

	public void setConcurrence(Concurrence concurrence) {
		this.concurrence = concurrence;
	}

}
