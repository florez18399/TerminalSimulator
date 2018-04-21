package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.Controller;
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
		addMouseListener(Controller.getInstance());
		setOpaque(false);
		paintTerminal(g);
		super.paint(g);
	}

	private void paintTerminal(Graphics graphics) {
		Node<TicketOffice> node = terminal.getListTicketOffice().getHead();
		while (node != null) {
			drawTicketOffice(graphics, node.getInfo());
			node = node.getNextNode();
		}
	}

	private void drawTicketOffice(Graphics g, TicketOffice ticketOffice) {
		g.drawImage(imageTicketOffice, ticketOffice.getPositionOffice().getX() - ticketOffice.getSizeTicketOffice() / 2,
				ticketOffice.getPositionOffice().getY(), ticketOffice.getSizeTicketOffice(),
				ticketOffice.getSizeTicketOffice(), this);
		drawBus(ticketOffice.getActualBus(), g);
	}

	private void drawBus(Bus bus, Graphics graphics) {
		graphics.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(bus.getTypeBus().getPathIconBus())),
				bus.getPosition().getX(), bus.getPosition().getY(), bus.getTypeBus().getWidth(), bus.getTypeBus().getLength(), this);
	}

	private Image getScaledImage(String pathImage, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(pathImage));
		return imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_REPLICATE);
	}
}
