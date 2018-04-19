package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class JPanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelControl panelControl;

	public JPanelMain() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		addPanelControl();
		
	}

	private void addPanelControl() {
		panelControl = new JPanelControl();
		add(panelControl, BorderLayout.CENTER);
	}
}
