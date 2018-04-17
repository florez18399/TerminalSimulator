package persistence;

import java.util.ArrayList;

public class FilesTerminal {
	public final static String PATH_FILE_BUSES = "files/buses.txt";
	public final static String PATH_FILE_DESTINATIONS = "files/destinations.txt";

	public FilesTerminal() {
	}

	public ArrayList<String> getListDestinations() {
		return getListFromFile(PATH_FILE_DESTINATIONS);
	}

	public ArrayList<String> getListBuses() {
		return getListFromFile(PATH_FILE_BUSES);
	}

	private ArrayList<String> getListFromFile(String pathFile) {
		FileManager fileManager = new FileManager(pathFile, OpenForm.READ);
		fileManager.open();
		ArrayList<String> list = fileManager.createArray();
		fileManager.close();
		return list;
	}
}
