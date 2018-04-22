package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Commands;
import controller.Controller;
import models.Terminal;

public class JFrameMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelMain panelMain;
	private JDialogAbout dialogAbout;

	public JFrameMain(Terminal terminal) {
		init(terminal);
	}

	private void init(Terminal terminal) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(getToolkit().getScreenSize());
		setTitle(ConstantsGUI.TITLE_APP);
		initJMenuBar();
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_APP_PATH)).getImage());
		panelMain = new JPanelMain(terminal);
		dialogAbout = new JDialogAbout(this);
		add(panelMain);
		setVisible(true);
	}

	private void initJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuSimulation = new JMenu(ConstantsGUI.TEXT_SIMULATION);
		menuSimulation.add(createItem(Commands.INIT_SIMULATION));
		menuSimulation.add(createItem(Commands.STOP_SIMULATION));
		menuSimulation.add(createItem(Commands.GENERATE_REPORT));
		menuBar.add(menuSimulation);
		JMenu menuConfiguration = new JMenu(ConstantsGUI.TEXT_CONFIGURATION);
		menuConfiguration.add(createItem(Commands.SHOW_ABOUT));
		menuBar.add(menuConfiguration);
		setJMenuBar(menuBar);
	}

	private JMenuItem createItem(Commands commands) {
		JMenuItem menuItem = new JMenuItem(commands.getTitle());
		menuItem.setToolTipText(commands.getDescription());
		menuItem.setActionCommand(commands.getCommand());
		menuItem.addActionListener(Controller.getInstance());
		return menuItem;
	}

	public void showDialogAbout() {
		dialogAbout.setVisible(true);
	}
}
