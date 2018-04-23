package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Node;
import models.Terminal;
import models.TicketOffice;

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
		setForeground(Color.WHITE);
		setFont(ConstantsGUI.FONT_REPORT);
	}

	public void fillJTable() {
		removeAll();
		tableModel = new DefaultTableModel();
		String[] titleCols = { ConstantsGUI.NAME_TICKET_O, ConstantsGUI.TICKETS_SOLD, ConstantsGUI.TOTAL_INCOMES,
				ConstantsGUI.BUSES_DISPATCHED };
		tableModel.setColumnIdentifiers(titleCols);
		Node<TicketOffice> actual = terminal.listSortedBySales().getHead();
		while (actual != null) {
			TicketOffice office = actual.getInfo();
			Object object[] = { office.getDestiny().getName(), office.ticketsSold(), office.calculateTotalIncomes(),
					office.getBusesDispatched() };
			tableModel.addRow(object);
			actual = actual.getNextNode();
		}
		setModel(tableModel);
		revalidate();
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

}
