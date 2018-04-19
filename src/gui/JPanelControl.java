package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Commands;
import controller.Controller;

public class JPanelControl extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelControl() {
		init();
	}

	private void init() {
		setLayout(new FlowLayout());
		add(createButton(Commands.INIT_SIMULATION));
		add(createButton(Commands.STOP_SIMULATION));
		add(createButton(Commands.GENERATE_REPORT));
	}
	
	private JButton createButton(Commands commands) {
		JButton button = new JButton(commands.getTitle());
		button.setToolTipText(commands.getDescription());
		button.setIcon(new ImageIcon(getClass().getResource(commands.getPathIcon())));
		button.setBackground(Color.decode("#FFF8E7"));
		button.setBorderPainted(false);
		button.setActionCommand(commands.getCommand());
		button.addActionListener(Controller.getInstance());
		return button;
	}
}
