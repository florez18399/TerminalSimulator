package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import models.Bus;
import models.ConstantsModels;
import models.Node;
import models.Passenger;
import models.Position;
import models.Terminal;
import models.TicketOffice;

public class JPanelDrawTerminal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terminal terminal;
	private Image imageTicketOffice;
	private Image imagePassenger;
	private Image imageEntry;
	private Image imageRoad;

	public JPanelDrawTerminal(Terminal terminal) {
		this.terminal = terminal;
		init();
	}

	private void init() {
		initImages();
		repaint();
	}

	private void initImages() {
		imageTicketOffice = new ImageIcon(getClass().getResource(ConstantsGUI.ICON_TICKET_OFFICE2_PATH)).getImage();
		imagePassenger = new ImageIcon(getClass().getResource(ConstantsGUI.ICON_PERSON2_PATH)).getImage();
		imageEntry = new ImageIcon(getClass().getResource(ConstantsGUI.ICON_ENTRY_PATH)).getImage();
		imageRoad = new ImageIcon(getClass().getResource(ConstantsGUI.ROAD2_IMAGE_PATH)).getImage();
	}

	@Override
	public void paint(Graphics g) {
		setOpaque(false);
		paintTerminal(g);
		super.paint(g);
	}

	private void paintTerminal(Graphics graphics) {
		drawEntry(graphics);
		drawAllTickets(graphics);
		drawPassengers(graphics);
		drawBusesInMove(graphics);
	}

	private void drawPassengers(Graphics graphics) {
		Node<Passenger> nodePassenger = terminal.getIncoming().getHead();
		while (nodePassenger != null) {
			Position positionPassenger = nodePassenger.getInfo().getPosition();
			graphics.drawImage(imagePassenger, positionPassenger.getX(), positionPassenger.getY(),
					ConstantsGUI.SIZE_PERSON, ConstantsGUI.SIZE_PERSON, this);
			nodePassenger = nodePassenger.getNextNode();
		}
	}

	private void drawAllTickets(Graphics graphics) {
		Node<TicketOffice> nodeTOffice = terminal.getListTicketOffice().getHead();
		while (nodeTOffice != null) {
			drawTicketOffice(graphics, nodeTOffice.getInfo());
			nodeTOffice = nodeTOffice.getNextNode();
		}
	}

	private void drawEntry(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(ConstantsGUI.FONT_TITLES);
		graphics.drawImage(imageEntry, terminal.getPosition().getX(), terminal.getPosition().getY(),
				ConstantsModels.SIZE_TERMINAL_ENTRY, ConstantsModels.SIZE_TERMINAL_ENTRY, this);
		graphics.drawString(terminal.getName(), terminal.getPosition().getX() - 10, terminal.getPosition().getY() - 10);
	}

	private void drawBusesInMove(Graphics graphics) {
		Node<Bus> nodeBus = terminal.getDispatched().getHead();
		while (nodeBus != null) {
			drawBus(nodeBus.getInfo(), graphics);
			nodeBus = nodeBus.getNextNode();
		}
	}

	private void drawTicketOffice(Graphics g, TicketOffice ticketOffice) {
		g.drawImage(imageRoad, ticketOffice.getPositionOffice().getX(),
				ticketOffice.getActualBus().getPosition().getY() - 20, ConstantsGUI.WIDTH_ROAD,
				ConstantsGUI.HEIGHT_ROAD, this);
		drawQueueTicketOffice(g, ticketOffice);
		g.drawImage(imageTicketOffice, ticketOffice.getPositionOffice().getX(), ticketOffice.getPositionOffice().getY(),
				ticketOffice.getSizeTicketOffice(), ticketOffice.getSizeTicketOffice(), this);
		drawBus(ticketOffice.getActualBus(), g);
		g.setFont(ConstantsGUI.FONT_TITLES);
		g.setColor(Color.RED);
		g.drawString(ticketOffice.getDestiny().getName(), ticketOffice.getPositionOffice().getX() + 5,
				ticketOffice.getPositionOffice().getY() - ticketOffice.getSizeTicketOffice() * 1 / 10);
	}

	private void drawQueueTicketOffice(Graphics g, TicketOffice ticketOffice) {
		int quantity = ticketOffice.getBuyersQueue().size();
		int y = ticketOffice.getPositionOffice().getY() - 15;
		for (int i = 0; i < quantity; i++) {
			g.drawImage(imagePassenger,
					ticketOffice.getPositionOffice().getX() + ticketOffice.getSizeTicketOffice() / 2, y,
					ConstantsGUI.SIZE_PERSON, ConstantsGUI.SIZE_PERSON, this);
			y -= 2;
		}
	}

	private void drawBus(Bus bus, Graphics graphics) {
		graphics.drawImage(new ImageIcon(getClass().getResource(bus.getTypeBus().getPathIconBus())).getImage(),
				bus.getPosition().getX(), bus.getPosition().getY(), bus.getTypeBus().getWidth(),
				bus.getTypeBus().getLength(), this);
		graphics.setColor(Color.WHITE);
		graphics.setFont(ConstantsGUI.FONT_BUS);
		graphics.drawString(ConstantsGUI.TEXT_PASSENGERS + bus.getTotalPassengers(), bus.getPosition().getX(),
				bus.getPosition().getY() + bus.getTypeBus().getLength() / 2 + 10);
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
		repaint();
	}
}
