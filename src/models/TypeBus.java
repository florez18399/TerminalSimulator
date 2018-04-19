package models;

public enum TypeBus {
	MICROBUS(10, "/images/busSilver.png", 80), MINIBUS(18, "/images/busBlue.png", 100), MIDIBUS(25,
			"/images/busYellow.png", 110), AUTOBUS(40, "/images/busRed.png", 140);

	private int passengerCapacity;
	private String pathIconBus;
	private int speed;

	private TypeBus(int passengerCapacity, String pathIconBus, int speed) {
		this.passengerCapacity = passengerCapacity;
		this.pathIconBus = pathIconBus;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
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
