package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.Terminal;

public class JFrameMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelMain panelMain;

	public JFrameMain(Terminal terminal) {
		init(terminal);
	}

	private void init(Terminal terminal) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(getToolkit().getScreenSize());
		setTitle(ConstantsGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_APP_PATH)).getImage());
		panelMain = new JPanelMain(terminal);
		add(panelMain);
		setVisible(true);
	}
}
