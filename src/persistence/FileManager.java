package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	private File file;
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	private OpenForm openForm;

	public FileManager(String nameFile, OpenForm openForm) {
		file = new File(nameFile);
		this.openForm = openForm;
	}

	public void setOpenForm(OpenForm openFor) {
		this.openForm = openFor;
	}

}
