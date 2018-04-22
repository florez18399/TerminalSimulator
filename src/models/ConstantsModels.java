package models;

import java.awt.Toolkit;

public class ConstantsModels {
	public final static int PASSENGERS_IN_TERMINAL = 20;
	public final static int SPEED_TICKER_OFFICE = 300;
	public final static int SIZE_TICKET_OFFICE = 60;
	public final static int SIZE_TERMINAL_ENTRY = 100;
	public final static int SIZE_TERMINAL = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 200;
	public final static int POSITION_Y_TICKET = 200;
	public final static Position POSITION_ENTRY = new Position((SIZE_TERMINAL + 100) / 2, 30);
	public final static int X_ENTRY_PERSONS = POSITION_ENTRY.getX() + SIZE_TERMINAL_ENTRY/2;
	public final static int Y_ENTRY_PERSONS = SIZE_TERMINAL_ENTRY - 25;
}
