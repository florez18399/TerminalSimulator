package models;

public class Passenger {
	private String name;
	private int id;
	private Destiny destiny;
	private Position position;
	private Position positionTickets;
	private boolean isArrived;

	public Passenger(String name, int id, Destiny destiny, Position position) {
		this.name = name;
		this.destiny = destiny;
		this.position = position;
	}

	public Passenger(Destiny destiny, Position position) {
		this.destiny = destiny;
		this.position = position;
	}

	public void move() {
		if (position.getX() < positionTickets.getX()) {
			position.setX(position.getX() + 1);
		} else if (position.getX() > positionTickets.getX()) {
			position.setX(position.getX() - 1);
		} else {
			position.setY(position.getY() + 1);
			if ((positionTickets.getY() - position.getY()) < 60) {
				isArrived = true;
			}
		}
	}

	public boolean isArrived() {
		return isArrived;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPositionTickets() {
		return positionTickets;
	}

	public void setPositionTickets(Position positionTickets) {
		this.positionTickets = new Position(positionTickets.getX() + ConstantsModels.SIZE_TICKET_OFFICE / 2,
				positionTickets.getY());
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

	public int getId() {
		return id;
	}

}
