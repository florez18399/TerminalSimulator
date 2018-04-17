package models;

import java.util.Comparator;

public class LockersComparator implements Comparator<TicketOffice>{

	@Override
	public int compare(TicketOffice o1, TicketOffice o2) {
		if(o1.equals(o2)) 
			return 0;
		return 1;
	}

}
