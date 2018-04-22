package models;

public enum Concurrence {
	LOW(1000, "LOW"), MEDIUM(400, "MEDIUM"), HIGH(150, "HIGH");

	private int timeCreation;
	private String description;

	private Concurrence(int timeCreation, String description) {
		this.timeCreation = timeCreation;
		this.description = description;
	}

	public int getTimeCreation() {
		return timeCreation;
	}

	public String getDescription() {
		return description;
	}

}
