package models;

public enum Concurrence {
	LOW(10), MEDIUM(15), HIGH(20);

	private int max;

	private Concurrence(int max) {
		this.max = max;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}
