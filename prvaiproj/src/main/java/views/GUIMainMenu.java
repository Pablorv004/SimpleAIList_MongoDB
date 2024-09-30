package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import controllers.ControllerMainMenu;

public class GUIMainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTitle;
	private JSeparator separator;
	private JPanel panelButtons;
	private JPanel panelBottom;
	private JButton btnAdd;
	private JButton btnView;
	private JButton btnEdit;
	private JButton btnExit;
	private JPanel panelTitleCard;
	private JLabel lblTitle;

	public GUIMainMenu(JFrame frame) {
		setTitle("AI Registry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));

		separator = new JSeparator();
		panelTitle.add(separator, BorderLayout.SOUTH);

		panelTitleCard = new JPanel();
		panelTitle.add(panelTitleCard, BorderLayout.NORTH);

		lblTitle = new JLabel("AI Registry");
		lblTitle.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		panelTitleCard.add(lblTitle);

		panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.CENTER);
		panelButtons.setLayout(new GridLayout(0, 3, 0, 0));

		btnAdd = new JButton();
		btnAdd.setIcon(new ImageIcon("src/main/resources/addIcon64.png"));
		panelButtons.add(btnAdd);

		btnView = new JButton();
		btnView.setIcon(new ImageIcon("src/main/resources/searchIcon64.png"));
		panelButtons.add(btnView);

		btnEdit = new JButton();
		btnEdit.setIcon(new ImageIcon("src/main/resources/editIcon64.png"));
		panelButtons.add(btnEdit);

		panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);

		btnExit = new JButton("Exit");
		panelBottom.add(btnExit);

		new ControllerMainMenu(this);
		setVisible(true);
		setLocationRelativeTo(frame);
	}

	public void addActListeners(ActionListener listener) {
		btnAdd.addActionListener(listener);
		btnEdit.addActionListener(listener);
		btnView.addActionListener(listener);
		btnExit.addActionListener(listener);
	}

	public JPanel getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(JPanel panelTitle) {
		this.panelTitle = panelTitle;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JPanel getPanelButtons() {
		return panelButtons;
	}

	public void setPanelButtons(JPanel panelButtons) {
		this.panelButtons = panelButtons;
	}

	public JPanel getPanelBottom() {
		return panelBottom;
	}

	public void setPanelBottom(JPanel panelBottom) {
		this.panelBottom = panelBottom;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnView() {
		return btnView;
	}

	public void setBtnView(JButton btnView) {
		this.btnView = btnView;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public JPanel getPanelTitleCard() {
		return panelTitleCard;
	}

	public void setPanelTitleCard(JPanel panelTitleCard) {
		this.panelTitleCard = panelTitleCard;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

}
