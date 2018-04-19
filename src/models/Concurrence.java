package models;

public enum Concurrence {
	LOW(5), MEDIUM(10), HIGH(15);

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
