package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controller.Commands;
import controller.Controller;
import models.Concurrence;

public class JPanelControl extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> boxConcurrency;
	private int max;
	private JSlider slider;

	public JPanelControl() {
		init();
	}

	private void init() {
		setLayout(new FlowLayout());
		setOpaque(false);
		createJSliderSpeed();
		createJComboBoxConcurrency();
		add(createButton(Commands.INIT_SIMULATION));
		add(createButton(Commands.STOP_SIMULATION));
		add(createButton(Commands.GENERATE_REPORT));
		add(createButton(Commands.RESET_SIMULATION));
	}

	private void createJSliderSpeed() {
		JLabel label = new JLabel(ConstantsGUI.TEXT_SPEED);
		label.setFont(ConstantsGUI.FONT_TITLES);
		label.setForeground(Color.WHITE);
		add(label);
		slider = new JSlider(0, 100, 50);
		slider.setPreferredSize(ConstantsGUI.DIMENSION_SLIDER);
		slider.setPaintTicks(true);
		slider.setBackground(ConstantsGUI.COLOR_BACK_TERMINAL);
		add(slider);
	}

	private void createJComboBoxConcurrency() {
		JLabel label = new JLabel(ConstantsGUI.TEXT_CONCURRENCY);
		label.setFont(ConstantsGUI.FONT_TITLES);
		label.setForeground(Color.WHITE);
		add(label);
		boxConcurrency = new JComboBox<String>();
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

	public Concurrence getConcurrenceChoosen() {
		return Concurrence.valueOf((String) boxConcurrency.getSelectedItem());
	}
}
