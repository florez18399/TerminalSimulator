package gui;

import javax.swing.JFrame;

public class JFrameMain extends JFrame {

	public JFrameMain() {
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
}
