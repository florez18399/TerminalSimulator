package models;

import java.util.ArrayList;

import controller.Commands;
import persistence.FilesTerminal;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;
	private FilesTerminal filesTerminal;
	private Concurrence concurrence;
	private MyQueue<Passenger> incoming;
	private MyLinkedList<Bus> dispatched;
	private Position position;

	public Terminal(String name) {
		this.name = name;
		filesTerminal = new FilesTerminal();
		incoming = new MyQueue<Passenger>();
		dispatched = new MyLinkedList<Bus>();
		loadTicketOffices();
	}

	public void loadTicketOffices() {
		listTicketOffice = new MyLinkedList<TicketOffice>(new LockersComparator());
		ArrayList<String> listDestinations = filesTerminal.getListDestinations();
		for (int i = 0; i < listDestinations.size(); i++) {
			createTicketOffice(listDestinations.get(i), i + 1, listDestinations.size());
		}
	}

	private void createTicketOffice(String destination, int numberOffice, int quantity) {
		String vecDestiny[] = destination.split("/");
		Destiny destiny = new Destiny(vecDestiny[0], Integer.parseInt(vecDestiny[1]), Integer.parseInt(vecDestiny[2]));
		TicketOffice ticketOffice = new TicketOffice(destiny,
				new Position(ConstantsModels.SIZE_TERMINAL * (numberOffice) / quantity, 120),
				ConstantsModels.SIZE_TICKET_OFFICE);
		ticketOffice.setActualBus(createBusRandom());
		listTicketOffice.addNode(new Node<TicketOffice>(ticketOffice));
	}

	private Bus createBusRandom() {
		return new Bus("License", TypeBus.values()[(int) (Math.random() * TypeBus.values().length)]);
	}

	public void verifyBusesTickets() {
		Node<TicketOffice> ticketOfficeActual = listTicketOffice.getHead();
		while (ticketOfficeActual != null) {
			if (ticketOfficeActual.getInfo().getActualBus().isFull()) {
				dispatched.addNode(new Node<Bus>(ticketOfficeActual.getInfo().getActualBus()));
				ticketOfficeActual.getInfo().setActualBus(createBusRandom());
			}
			ticketOfficeActual = ticketOfficeActual.getNextNode();
		}
	}

	public void moveBuses() {
		Node<Bus> actual = dispatched.getHead();
		while (actual != null) {
			actual.getInfo().moveBus();
			actual = actual.getNextNode();
		}
	}

	public Passenger createPassenger() {
		int idDestiny = ((int) (Math.random() * listTicketOffice.size()) + 1);
		Passenger passenger = new Passenger(listTicketOffice.get(idDestiny).getInfo().getDestiny(), position);
		incoming.enqueue(new Node<Passenger>(passenger));
		return passenger;
	}

	public void sendToTicketOffice() {
		if (!incoming.isEmpty()) {
			Passenger passenger = incoming.dequeue().getInfo();
			Node<TicketOffice> node = listTicketOffice.getHead();
			while (node != null) {
				if (node.getInfo().getDestiny().equals(passenger.getDestiny())) {
					node.getInfo().getBuyersQueue().enqueue(new Node<Passenger>(passenger));
					return;
				}
				node = node.getNextNode();
			}
		}
	}

	public void atendAllTickets() {
		Node<TicketOffice> actual = listTicketOffice.getHead();
		while (actual != null) {
			actual.getInfo().servePassenger();
			actual = actual.getNextNode();
		}
	}

	public MyQueue<Passenger> getIncoming() {
		return incoming;
	}

	public void setIncoming(MyQueue<Passenger> incoming) {
		this.incoming = incoming;
	}

	public void setListTicketOffice(MyLinkedList<TicketOffice> listTicketOffice) {
		this.listTicketOffice = listTicketOffice;
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

	public MyLinkedList<Bus> getDispatched() {
		return dispatched;
	}

}
