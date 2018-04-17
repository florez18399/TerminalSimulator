package models;

public class Passenger {
	private String name;
	private int id;
	private Destiny destiny;

	public Passenger(String name, int id, Destiny destiny) {
		this.name = name;
		this.destiny = destiny;
	}

	public Passenger(Destiny destiny) {
		super();
		this.destiny = destiny;
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
