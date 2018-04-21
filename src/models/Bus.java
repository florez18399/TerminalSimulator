package models;

public class Bus {
	private String license;
	private TypeBus typeBus;
	private MyLinkedList<Passenger> listPassengers;
	private Position position;
	private int totalPassengers;

	public Bus(String license, TypeBus typeBus) {
		this.license = license;
		this.typeBus = typeBus;
		listPassengers = new MyLinkedList<Passenger>();
	}

	public void addToBus(Passenger passenger) {
		if (totalPassengers < typeBus.getPassengerCapacity()) {
			listPassengers.addNode(new Node<Passenger>(passenger));
			totalPassengers++;
		}
	}

	public boolean isFull() {
		return totalPassengers == typeBus.getPassengerCapacity() ? true : false;
	}

	public void moveBus() {
		position.setY(position.getY() + typeBus.getSpeed() / 10);
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public TypeBus getTypeBus() {
		return typeBus;
	}

	public void setTypeBus(TypeBus typeBus) {
		this.typeBus = typeBus;
	}

	public MyLinkedList<Passenger> getListPassengers() {
		return listPassengers;
	}

	public void setListPassengers(MyLinkedList<Passenger> listPassengers) {
		this.listPassengers = listPassengers;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getTotalPassengers() {
		return totalPassengers;
	}

	public void setTotalPassengers(int totalPassengers) {
		this.totalPassengers = totalPassengers;
	}

}
