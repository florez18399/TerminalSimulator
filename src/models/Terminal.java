package models;

import java.util.ArrayList;
import java.util.Comparator;

import persistence.FilesTerminal;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;
	private FilesTerminal filesTerminal;
	private Concurrence concurrence;
	private MyLinkedList<Passenger> incoming;
	private MyLinkedList<Bus> dispatched;
	private Position position;

	public Terminal(String name) {
		this.name = name;
		filesTerminal = new FilesTerminal();
		incoming = new MyLinkedList<Passenger>(new ComparatorPassengers());
		dispatched = new MyLinkedList<Bus>();
		position = ConstantsModels.POSITION_ENTRY;
		loadTicketOffices();
	}

	/**
	 * Lee los destinos del archivo plano y para cada uno crea una taquilla
	 */
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
				new Position(ConstantsModels.SIZE_TERMINAL * (numberOffice) / quantity,
						ConstantsModels.POSITION_Y_TICKET),
				ConstantsModels.SIZE_TICKET_OFFICE);
		ticketOffice.setActualBus(createBusRandom());
		listTicketOffice.addNode(new Node<TicketOffice>(ticketOffice));
	}

	private Bus createBusRandom() {
		return new Bus("License", TypeBus.values()[(int) (Math.random() * TypeBus.values().length)]);
	}

	/**
	 * Verifica los buses de cada taquilla y si ya está lleno lo cambia
	 */
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

	/**
	 * Cambia de posición a todos los buses que han sido despachados
	 */
	public void moveBuses() {
		Node<Bus> actual = dispatched.getHead();
		while (actual != null) {
			actual.getInfo().moveBus();
			actual = actual.getNextNode();
		}
	}

	/**
	 * Crea un pasajero con destino aleatorio y lo agrega a una lista enlazada
	 * 
	 * @return
	 */
	public Passenger createPassenger() {
		int idDestiny = ((int) (Math.random() * listTicketOffice.size()) + 1);
		Passenger passenger = new Passenger(listTicketOffice.get(idDestiny).getInfo().getDestiny(),
				new Position(ConstantsModels.X_ENTRY_PERSONS, ConstantsModels.Y_ENTRY_PERSONS));
		passenger.setPositionTickets(listTicketOffice.get(idDestiny).getInfo().getPositionOffice());
		incoming.addNode(new Node<Passenger>(passenger));
		return passenger;
	}

	public void movePersons() {
		Node<Passenger> actual = incoming.getHead();
		while (actual != null) {
			actual.getInfo().move();
			actual = actual.getNextNode();
		}
		sendToTheTicketOffice();
	}

	private void sendToTheTicketOffice() {
		Node<Passenger> actual = incoming.getHead();
		ArrayList<Node<Passenger>> list = new ArrayList<>();
		while (actual != null) {
			if (actual.getInfo().isArrived()) {
				TicketOffice office = searchTicketOffice(actual.getInfo().getDestiny());
				office.getBuyersQueue().enqueue(new Node<Passenger>(actual.getInfo()));
				list.add(actual);
			}
			actual = actual.getNextNode();
		}
		for (Node<Passenger> node : list) {
			incoming.removeNode(node.getInfo());
		}
	}

	/**
	 * Busca una taquilla mediante un destino
	 * 
	 * @param destiny
	 * @return
	 */
	private TicketOffice searchTicketOffice(Destiny destiny) {
		Node<TicketOffice> node = listTicketOffice.getHead();
		while (node != null) {
			if (node.getInfo().getDestiny().equals(destiny)) {
				return node.getInfo();
			}
			node = node.getNextNode();
		}
		return null;
	}

	/**
	 * Funcionamiento de todas las taquillas
	 */
	public void atendAllTickets() {
		Node<TicketOffice> actual = listTicketOffice.getHead();
		while (actual != null) {
			actual.getInfo().servePassenger();
			actual = actual.getNextNode();
		}
	}

	/**
	 * 
	 * @return Una lista de prioridad ordenada por el total de ingresos de las
	 *         taquillas
	 */
	public MyProrityList<TicketOffice> listSortedByIncomes() {
		return getListSorted(new Comparator<TicketOffice>() {

			@Override
			public int compare(TicketOffice tOffOne, TicketOffice tOffTwo) {
				return tOffOne.calculateTotalIncomes() - tOffTwo.calculateTotalIncomes();
			}

		});
	}

	/**
	 * 
	 * @return Una lista de prioridad ordenada por el total de ventas de las
	 *         taquillas
	 */
	public MyProrityList<TicketOffice> listSortedBySales() {
		return getListSorted(new Comparator<TicketOffice>() {

			@Override
			public int compare(TicketOffice tOffOne, TicketOffice tOffTwo) {
				return tOffOne.ticketsSold() - tOffTwo.ticketsSold();
			}

		});
	}

	public MyProrityList<TicketOffice> getListSorted(Comparator<TicketOffice> comparator) {
		MyProrityList<TicketOffice> list = new MyProrityList<>(comparator);
		Node<TicketOffice> actual = listTicketOffice.getHead();
		while (actual != null) {
			list.addNode(new Node<TicketOffice>(actual.getInfo()));
			actual = actual.getNextNode();
		}
		return list;
	}

	public MyLinkedList<Passenger> getIncoming() {
		return incoming;
	}

	public void setIncoming(MyLinkedList<Passenger> incoming) {
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
