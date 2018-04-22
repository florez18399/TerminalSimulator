package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
		imagePassenger = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ConstantsGUI.ICON_PERSON2_PATH));
		imageEntry = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ConstantsGUI.ICON_ENTRY_PATH));
		imageRoad = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ConstantsGUI.ROAD2_IMAGE_PATH));
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
		graphics.drawImage(imageEntry, terminal.getPosition().getX(), terminal.getPosition().getY(),
				ConstantsModels.SIZE_TERMINAL_ENTRY, ConstantsModels.SIZE_TERMINAL_ENTRY, this);
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

		g.drawImage(imageTicketOffice, ticketOffice.getPositionOffice().getX(), ticketOffice.getPositionOffice().getY(),
				ticketOffice.getSizeTicketOffice(), ticketOffice.getSizeTicketOffice(), this);
		drawBus(ticketOffice.getActualBus(), g);
		g.setFont(new Font("Impact", Font.PLAIN, 15));
		g.drawString(ticketOffice.getDestiny().getName(), ticketOffice.getPositionOffice().getX() + 5,
				ticketOffice.getPositionOffice().getY() - ticketOffice.getSizeTicketOffice() * 1 / 10);
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
