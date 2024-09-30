package views;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerConnect;

public class GUIConnect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConnecting;
	private JLabel lblImage;

	/**
	 * Create the frame.
	 */
	public GUIConnect() {
		setTitle("AI Registry");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		lblConnecting = new JLabel("Connecting...");
		lblConnecting.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblConnecting.setFont(new Font("Tw Cen MT", Font.PLAIN, 36));
		contentPane.add(lblConnecting);
		
		lblImage = new JLabel("");
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImage.setIcon(new ImageIcon("src/main/resources/aiChip128.png"));
		contentPane.add(lblImage);
		setVisible(true);
		setLocationRelativeTo(null);
		new ControllerConnect(this);
		
	}

}
