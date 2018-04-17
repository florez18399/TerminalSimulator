package models;

import java.util.Comparator;

public class ComparatorPassengers implements Comparator<Passenger> {

	@Override
	public int compare(Passenger passOne, Passenger passTwo) {
		return passOne.getId() - passTwo.getId();
	}

}
