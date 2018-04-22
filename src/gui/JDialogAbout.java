package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class JDialogAbout extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogAbout(JFrameMain main) {
		super(main);
		init();
	}

	private void init() {
		setSize(ConstantsGUI.DIMENSION_DIALOG_ABOUT);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		getContentPane().setBackground(ConstantsGUI.COLOR_BACK_APP);
		JLabel labelTitle = new JLabel(ConstantsGUI.TITLE_APP, SwingConstants.CENTER);
		labelTitle.setFont(ConstantsGUI.FONT_TITLES2);
		labelTitle.setPreferredSize(ConstantsGUI.DIMENSION_DIALOG_TITLE);
		labelTitle.setForeground(Color.decode("#ff3333"));
		add(labelTitle);

		JButton buttonImage = new JButton(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_APP_PATH2)));
		buttonImage.setContentAreaFilled(false);
		buttonImage.setBorderPainted(false);
		buttonImage.setPreferredSize(ConstantsGUI.DIMENSION_IMAGE_ABOUT);
		add(buttonImage);

		JTextArea area = new JTextArea(ConstantsGUI.TEXT_ABOUT_);
		area.setOpaque(false);
		area.setFont(ConstantsGUI.FONT_TITLES);
		area.setPreferredSize(ConstantsGUI.DIMENSION_TEXT_ABOUT);
		area.setEditable(false);
		area.setBorder(null);
		add(area);

	}

}
