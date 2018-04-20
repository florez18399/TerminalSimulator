package models;

public class TicketOffice {
	private Destiny destiny;
	private volatile MyQueue<Passenger> buyersQueue;
	private MyLinkedList<Passenger> usersServed;
	private Bus actualBus;
	private Position positionOffice;
	private int sizeTicketOffice;

	public TicketOffice(Destiny destiny, Position position, int size) {
		this.destiny = destiny;
		buyersQueue = new MyQueue<Passenger>();
		usersServed = new MyLinkedList<Passenger>(new ComparatorPassengers());
		positionOffice = position;
		sizeTicketOffice = size;
	}

	public void servePassenger() {
		if (buyersQueue.peek() != null) {
			Node<Passenger> nodePassenger = buyersQueue.dequeue();
			nodePassenger.setNextNode(null);
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

	public Position getPositionOffice() {
		return positionOffice;
	}

	public void setPositionOffice(Position positionOffice) {
		this.positionOffice = positionOffice;
	}

	public int getSizeTicketOffice() {
		return sizeTicketOffice;
	}

	public void setSizeTicketOffice(int sizeTicketOffice) {
		this.sizeTicketOffice = sizeTicketOffice;
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
		this.actualBus.setPosition(new Position(positionOffice.getX(), positionOffice.getY() + sizeTicketOffice * 2));
	}

}
