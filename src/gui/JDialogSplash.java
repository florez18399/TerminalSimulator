package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JDialogSplash extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogSplash(JFrame father) {
		super(father);
		init();
	}

	private void init() {
		setSize(ConstantsGUI.DIMENSION_DIALOG_SPLASH);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setBackground(ConstantsGUI.COLOR_BACK_TERMINAL);
		JLabel jLabel = new JLabel(ConstantsGUI.TITLE_APP, SwingConstants.CENTER);
		jLabel.setFont(ConstantsGUI.FONT_TITLES2);
		jLabel.setForeground(ConstantsGUI.COLOR_BACK_APP);
		jLabel.setOpaque(false);
		add(jLabel);
		repaint();
	}

	public void showMe() throws InterruptedException {
		setVisible(true);
		Thread.sleep(4000);
		setVisible(false);
	}
}
