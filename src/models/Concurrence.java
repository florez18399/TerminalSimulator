package models;

public enum Concurrence {
	LOW(1000), MEDIUM(400), HIGH(150);

	private int timeCreation;

	private Concurrence(int timeCreation) {
		this.timeCreation = timeCreation;
	}

	public int getTimeCreation() {
		return timeCreation;
	}
}
