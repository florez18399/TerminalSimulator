package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JFrameMain() {
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle(ConstantsGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_APP_PATH)).getImage());
		setVisible(true);
	}
}
