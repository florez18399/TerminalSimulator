package gui;

import java.awt.Color;

import javax.swing.JPanel;

import models.Terminal;

public class JPanelDrawTerminal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terminal terminal; 
	
	public JPanelDrawTerminal(Terminal terminal) {
		init();
	}

	private void init() {
		setBackground(Color.BLACK);
	}

}
