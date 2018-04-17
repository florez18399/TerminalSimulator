package models;

import java.util.ArrayList;

import persistence.FileManager;
import persistence.OpenForm;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;

	public Terminal(String name) {
		this.name = name;
		loadQueueBuses();
		loadTicketOffices();
	}

	public void loadQueueBuses() {
	}
	
	public void loadTicketOffices() {
	}
	
}
