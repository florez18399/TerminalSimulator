package models;

public enum TypeBus {
	MICROBUS(10, "/images/busSilver.png", 80, 30, 45), MINIBUS(18, "/images/busBlue.png", 100, 40, 55), MIDIBUS(25,
			"/images/busRed.png", 110, 45, 68), AUTOBUS(40, "/images/busYellow.png", 140, 50, 80);

	private int passengerCapacity;
	private String pathIconBus;
	private int speed;
	private int width;
	private int length;

	private TypeBus(int passengerCapacity, String pathIconBus, int speed, int width, int length) {
		this.passengerCapacity = passengerCapacity;
		this.pathIconBus = pathIconBus;
		this.speed = speed;
		this.width = width;
		this.length = length;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public String getPathIconBus() {
		return pathIconBus;
	}

	public int getSpeed() {
		return speed;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

}
