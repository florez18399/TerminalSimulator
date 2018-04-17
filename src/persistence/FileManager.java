package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

	public void open() {
		try {
			switch (this.openForm) {
			case WRITE:
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
				break;
			case READ:
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				break;
			case APPEND:
				fileWriter = new FileWriter(file, true);
				bufferedWriter = new BufferedWriter(fileWriter);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setOpenForm(OpenForm openFor) {
		this.openForm = openFor;
	}

}
