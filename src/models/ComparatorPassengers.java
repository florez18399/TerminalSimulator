package models;

import java.util.Comparator;

public class ComparatorPassengers implements Comparator<Passenger> {

	@Override
	public int compare(Passenger passOne, Passenger passTwo) {
		if(passOne.equals(passTwo)) {
			return 0;
		}
		return -1;
	}

}
