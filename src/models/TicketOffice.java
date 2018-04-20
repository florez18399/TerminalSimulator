package models;

public class TicketOffice {
	private Destiny destiny;
	private volatile MyQueue<Passenger> buyersQueue;
	private MyLinkedList<Passenger> usersServed;
	private Bus actualBus;
	private Position positionOffice;

	public TicketOffice(Destiny destiny) {
		this.destiny = destiny;
		buyersQueue = new MyQueue<Passenger>();
		usersServed = new MyLinkedList<Passenger>(new ComparatorPassengers());
		System.out.println("Pedir busssss al terminal");
	}

	public void servePassenger() {
		if (buyersQueue.peek() != null) {
			Node<Passenger> nodePassenger = buyersQueue.dequeue();
			nodePassenger.setNextNode(null);
//			System.out.println(nodePassenger.getInfo() + " Siguiente: " + nodePassenger.getNextNode());
			usersServed.addNode(nodePassenger);
			actualBus.addToBus(nodePassenger.getInfo());
		}
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

	@Override
	public String toString() {
		return "Taquilla: " + destiny.getName();
	}

	public Bus getActualBus() {
		return actualBus;
	}

	public void setActualBus(Bus actualBus) {
		this.actualBus = actualBus;
	}

}
