package gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import models.Node;
import models.Terminal;
import models.TicketOffice;

public class JPanelDrawTerminal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terminal terminal;

	public JPanelDrawTerminal(Terminal terminal) {
		this.terminal = terminal;
		init();
	}

	private void init() {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		setOpaque(false);
		paintTerminal(g);
		super.paint(g);
	}

	private void paintTerminal(Graphics graphics) {
		graphics.drawString("Personas esperando en la entrada: " + terminal.getIncoming().size(), 100, 50);
		drawTicketOffice(graphics);
	}

	private void drawTicketOffice(Graphics g) {
		Node<TicketOffice> node = terminal.getListTicketOffice().getHead();
		int y = 100;
		while (node != null) {
			g.drawString(node.getInfo().getDestiny().getName() + ": " + node.getInfo().getBuyersQueue().size(), 100, y);
			g.drawString("Pasajeros en el bus: " + node.getInfo().getActualBus().getTotalPassengers(), 300, y);
			y += 50;
			node = node.getNextNode();
		}
	}

}
