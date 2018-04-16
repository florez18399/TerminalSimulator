package models;

public class Destiny {
	private String name;
	private int distance;
	private int valueTicket;

	public Destiny(String name, int distance, int valueTicket) {
		this.name = name;
		this.distance = distance;
		this.valueTicket = valueTicket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getValueTicket() {
		return valueTicket;
	}

	public void setValueTicket(int valueTicket) {
		this.valueTicket = valueTicket;
	}

}
