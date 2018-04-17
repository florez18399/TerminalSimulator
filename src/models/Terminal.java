package models;

public class Terminal {
	private String name;
	private MyLinkedList<TicketOffice> listTicketOffice;
	private MyQueue<Bus> queueTotalBuses;

	public Terminal(String name) {
		this.name = name;
		loadQueueBuses();
		loadTicketOffice();
	}

	public void loadQueueBuses() {
		
	}
	
	public void loadTicketOffice() {
		
	}
	
}
