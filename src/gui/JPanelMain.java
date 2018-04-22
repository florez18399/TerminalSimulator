package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.Terminal;

public class JPanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelControl panelControl;
	private JPanelDrawTerminal drawTerminal;
	private JTableReport report;

	public JPanelMain(Terminal terminal) {
		init(terminal);
	}

	private void init(Terminal terminal) {
		setLayout(new BorderLayout());
		addPanelControl();
		addPanelDraw(terminal);
		report = new JTableReport(terminal);
		setBackground(ConstantsGUI.COLOR_BACK_TERMINAL);
	}

	private void addPanelDraw(Terminal terminal) {
		drawTerminal = new JPanelDrawTerminal(terminal);
		add(drawTerminal, BorderLayout.CENTER);
	}

	private void addPanelControl() {
		panelControl = new JPanelControl();
		add(panelControl, BorderLayout.NORTH);
	}

	public void showReport() {
		report.fillJTable();
		JScrollPane pane = new JScrollPane(report);
		add(pane, BorderLayout.CENTER);
	}

}
