package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import models.Bus;
import models.Node;
import models.Terminal;
import models.TicketOffice;

public class JPanelDrawTerminal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terminal terminal;

	private Image imageTicketOffice = getScaledImage(ConstantsGUI.ICON_TICKET_OFFICE_PATH, 5000, 5000);

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
		Node<TicketOffice> nodeTOffice = terminal.getListTicketOffice().getHead();
		while (nodeTOffice != null) {
			drawTicketOffice(graphics, nodeTOffice.getInfo());
			nodeTOffice = nodeTOffice.getNextNode();
		}
		drawBusesInMove(graphics);
	}

	private void drawBusesInMove(Graphics graphics) {
		Node<Bus> nodeBus = terminal.getDispatched().getHead();
		while (nodeBus != null) {
			drawBus(nodeBus.getInfo(), graphics);
			nodeBus = nodeBus.getNextNode();
		}
	}

	private void drawTicketOffice(Graphics g, TicketOffice ticketOffice) {
		g.drawImage(imageTicketOffice, ticketOffice.getPositionOffice().getX() - ticketOffice.getSizeTicketOffice() / 2,
				ticketOffice.getPositionOffice().getY(), ticketOffice.getSizeTicketOffice(),
				ticketOffice.getSizeTicketOffice(), this);
		drawBus(ticketOffice.getActualBus(), g);
	}

	private void drawBus(Bus bus, Graphics graphics) {
		graphics.drawImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource(bus.getTypeBus().getPathIconBus())),
				bus.getPosition().getX(), bus.getPosition().getY(), bus.getTypeBus().getWidth(),
				bus.getTypeBus().getLength(), this);
	}

	private Image getScaledImage(String pathImage, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(pathImage));
		return imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_REPLICATE);
	}
}
