package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

	public void close() {
		try {
			switch (this.openForm) {
			case WRITE:
				bufferedWriter.close();
				fileWriter.close();
				break;
			case APPEND:
				bufferedWriter.close();
				fileWriter.close();
				break;
			case READ:
				bufferedReader.close();
				fileReader.close();
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String cad) {
		if (this.openForm == OpenForm.WRITE || this.openForm == OpenForm.APPEND) {
			try {
				bufferedWriter.write(cad);
				bufferedWriter.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String read() {
		String cad = "";
		try {
			if (this.openForm == OpenForm.READ)
				cad = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cad;
	}

	public void setOpenForm(OpenForm openFor) {
		this.openForm = openFor;
	}

	public ArrayList<String> createArray() {
		ArrayList<String> arrayList = new ArrayList<String>();
		String line = read();
		while (line != null) {
			arrayList.add(line);
			line = read();
		}
		return arrayList;
	}

}
