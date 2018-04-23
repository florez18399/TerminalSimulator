package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.Concurrence;
import models.Terminal;

public class JPanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelControl panelControl;
	private JPanelDrawTerminal drawTerminal;
	private JTableReport report;
	private JScrollPane pane;

	public JPanelMain(Terminal terminal) {
		init(terminal);
	}

	private void init(Terminal terminal) {
		setLayout(new BorderLayout());
		addPanelControl();
		addPanelDraw(terminal);
		report = new JTableReport(terminal);
		pane = new JScrollPane(report);
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

	public void showSimulator() {
		remove(pane);
		add(drawTerminal, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void showReport() {
		remove(drawTerminal);
		report.fillJTable();
		add(pane, BorderLayout.CENTER);
		revalidate();
	}

	public Concurrence getConcurrence() {
		return panelControl.getConcurrenceChoosen();
	}

	public void setTerminal(Terminal terminal) {
		drawTerminal.setTerminal(terminal);
		report.setTerminal(terminal);
	}

}
