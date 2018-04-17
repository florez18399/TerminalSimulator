package persistence;

import java.util.ArrayList;

public class FilesTerminal {
	public final static String PATH_FILE_BUSES = "files/buses.txt";
	public final static String PATH_FILE_DESTINATIONS = "files/destinations.txt";

	public FilesTerminal() {
	}

	public ArrayList<String> getListDestinations() {
		FileManager fileManager = new FileManager(PATH_FILE_DESTINATIONS, OpenForm.READ);
		fileManager.open();
		ArrayList<String> list = fileManager.createArray();
		fileManager.close();
		return list;
	}
}
