package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Commands;
import controller.Controller;
import models.Concurrence;

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
		createJComboBoxConcurrency();
		add(createButton(Commands.INIT_SIMULATION));
		add(createButton(Commands.STOP_SIMULATION));
		add(createButton(Commands.GENERATE_REPORT));
	}

	private void createJComboBoxConcurrency() {
		JLabel label = new JLabel(ConstantsGUI.TEXT_CONCURRENCY);
		JComboBox<String> boxConcurrency = new JComboBox<String>();
		for (int i = 0; i < Concurrence.values().length; i++) {
			boxConcurrency.addItem(Concurrence.values()[i].getDescription());
		}
		boxConcurrency.setFont(ConstantsGUI.FONT_TITLES);
		boxConcurrency.setForeground(Color.BLACK);
		boxConcurrency.setPreferredSize(ConstantsGUI.DIMENSION_COMBO_CONC);
		add(boxConcurrency);
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
