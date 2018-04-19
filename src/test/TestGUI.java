package test;

import gui.JFrameMain;
import models.Terminal;

public class TestGUI {
	public static void main(String[] args) {
		JFrameMain frameMain = new JFrameMain(new Terminal("hola"));
	}
}
