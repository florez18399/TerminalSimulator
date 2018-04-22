package test;

import javax.swing.JFrame;
import gui.JDialogAbout;
import gui.JFrameMain;
import gui.JTableReport;
import models.Terminal;

public class TestGUI {
	public static void main(String[] args) {
		// JFrameMain frameMain = new JFrameMain(new Terminal("hola"));
		// JDialogAbout about = new JDialogAbout(frameMain);
		//// about.setVisible(true);

		JFrame frame = new JFrame("dv sld");
		frame.setSize(1300, 700);
		frame.add(new JTableReport(new Terminal("Paipa")));
		frame.setVisible(true);
	}
}
