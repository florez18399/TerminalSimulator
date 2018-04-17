package models;

import java.util.LinkedList;

public class Bus {
	private String license;
	private TypeBus typeBus;
	private MyLinkedList<Passenger> listPassengers;
	private StatusBus statusBus;

	public Bus(String license, TypeBus typeBus) {
		this.license = license;
		this.typeBus = typeBus;
		listPassengers= new MyLinkedList<>();
		statusBus = StatusBus.WAITING;
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

	public StatusBus getStatusBus() {
		return statusBus;
	}

	public void setStatusBus(StatusBus statusBus) {
		this.statusBus = statusBus;
	}

}
