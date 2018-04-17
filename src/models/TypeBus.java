package models;

import java.awt.Color;

public enum TypeBus {
	MICROBUS(10, Color.WHITE, "/images/busWhite.png"), MINIBUS(18, Color.BLUE, "/images/busBlue.png"), MIDIBUS(25,
			Color.CYAN, "/images/busPurple"), AUTOBUS(40, Color.RED, "/images/busRed.png");

	private int passengerCapacity;
	private Color color;
	private String pathIconBus;

	private TypeBus(int passengerCapacity, Color color, String pathIconBus) {
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

}
