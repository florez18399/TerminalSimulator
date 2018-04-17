package models;

public class TicketOffice {
	private Destiny destiny;
	private MyQueue<Passenger> buyersQueue;
	private MyLinkedList<Passenger> usersServed;

	public TicketOffice(Destiny destiny) {
		this.destiny = destiny;
		buyersQueue = new MyQueue<>();
		usersServed = new MyLinkedList<>(new ComparatorPassengers());
	}

	public Destiny getDestiny() {
		return destiny;
	}

	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}

	public MyQueue<Passenger> getBuyersQueue() {
		return buyersQueue;
	}

	public void setBuyersQueue(MyQueue<Passenger> buyersQueue) {
		this.buyersQueue = buyersQueue;
	}

	public MyLinkedList<Passenger> getUsersServed() {
		return usersServed;
	}

	public void setUsersServed(MyLinkedList<Passenger> usersServed) {
		this.usersServed = usersServed;
	}

}
