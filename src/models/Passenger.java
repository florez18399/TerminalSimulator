package models;

public class Passenger {
	private String name;
	private int id;
	private Destiny destiny;
	private Position position;

	public Passenger(String name, int id, Destiny destiny, Position position) {
		this.name = name;
		this.destiny = destiny;
		this.position = position;
	}

	public Passenger(Destiny destiny, Position position) {
		this.destiny = destiny;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Destiny getDestiny() {
		return destiny;
	}

	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
