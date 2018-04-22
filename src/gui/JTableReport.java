package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import models.Terminal;

public class JTableReport extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terminal terminal;
	private DefaultTableModel tableModel;

	public JTableReport(Terminal terminal) {
		this.terminal = terminal;
		init();
	}

	private void init() {
		setBackground(ConstantsGUI.COLOR_BACK_TERMINAL);
		setLayout(new BorderLayout());
		tableModel = new DefaultTableModel();
		JLabel labelTitle = new JLabel(terminal.getName(), SwingConstants.CENTER);
		labelTitle.setForeground(Color.WHITE);
		labelTitle.setFont(ConstantsGUI.FONT_TITLES);
		add(labelTitle, BorderLayout.NORTH);
		fillJTable();
	}

	private void fillJTable() {
		removeAll();
		String[] titleCols = { ConstantsGUI.NAME_TICKET_O, ConstantsGUI.TICKETS_SOLD, ConstantsGUI.TOTAL_INCOMES };
		tableModel.setColumnIdentifiers(titleCols);
	}
}
