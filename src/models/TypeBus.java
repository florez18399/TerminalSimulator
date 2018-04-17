package models;

import java.awt.Color;

public enum TypeBus {
	MICROBUS(10, Color.WHITE, "/images/busWhite.png", 80), MINIBUS(18, Color.BLUE, "/images/busBlue.png",
			100), MIDIBUS(25, Color.CYAN, "/images/busPurple", 110), AUTOBUS(40, Color.RED, "/images/busRed.png", 140);

	private int passengerCapacity;
	private Color color;
	private String pathIconBus;
	private int speed;

	private TypeBus(int passengerCapacity, Color color, String pathIconBus, int speed) {
		this.passengerCapacity = passengerCapacity;
		this.color = color;
		this.pathIconBus = pathIconBus;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getPathIconBus() {
		return pathIconBus;
	}

	public void setPathIconBus(String pathIconBus) {
		this.pathIconBus = pathIconBus;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
