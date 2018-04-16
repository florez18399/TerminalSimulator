package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private static Controller controller;

	private Controller() {

	}

	public static Controller getInstance() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public void initComponents() {

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Commands.valueOf(event.getActionCommand())) {

		default:
			break;
		}
	}
}
