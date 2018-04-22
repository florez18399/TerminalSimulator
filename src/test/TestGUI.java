package test;

import gui.JDialogAbout;
import gui.JFrameMain;
import models.Terminal;

public class TestGUI {
	public static void main(String[] args) {
		JFrameMain frameMain = new JFrameMain(new Terminal("hola"));
		JDialogAbout about = new JDialogAbout(frameMain);
		about.setVisible(true);
	}
}
