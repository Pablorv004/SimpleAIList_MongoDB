package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerAdd;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GUIAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTitle;
	private JPanel panelTitleCard;
	private JSeparator separator;
	private JLabel lblTitle;
	private JPanel panelInputs;
	private JPanel panelImage;
	private JPanel panelBottom;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblType;
	private JComboBox<String> cBType;
	private JLabel lblAge;
	private JButton btnSelect;
	private JLabel lblImage;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Font fontLabels = new Font("Tw Cen MT", Font.PLAIN, 14);
	private JComboBox<Integer> cBYear;

	/**
	 * Create the frame.
	 */
	public GUIAdd(JFrame frame) {
		
		setTitle("Add an AI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));

		panelTitleCard = new JPanel();
		panelTitle.add(panelTitleCard, BorderLayout.NORTH);

		lblTitle = new JLabel("Add a new AI...");
		lblTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		panelTitleCard.add(lblTitle);

		separator = new JSeparator();
		panelTitle.add(separator, BorderLayout.SOUTH);

		panelInputs = new JPanel();
		contentPane.add(panelInputs, BorderLayout.CENTER);
		panelInputs.setLayout(new GridLayout(3, 2, 0, 10));

		lblName = new JLabel("Name");
		lblName.setFont(fontLabels);
		panelInputs.add(lblName);

		txtName = new JTextField();
		panelInputs.add(txtName);
		txtName.setColumns(10);

		lblType = new JLabel("Type");
		lblType.setFont(fontLabels);
		panelInputs.add(lblType);

		cBType = new JComboBox<>();
		panelInputs.add(cBType);

		lblAge = new JLabel("Year of apparition");
		lblAge.setFont(fontLabels);
		panelInputs.add(lblAge);

		cBYear = new JComboBox<>();
		panelInputs.add(cBYear);

		panelImage = new JPanel();
		contentPane.add(panelImage, BorderLayout.EAST);
		panelImage.setLayout(new BorderLayout(0, 0));

		btnSelect = new JButton("Select an Image...");
		panelImage.add(btnSelect, BorderLayout.SOUTH);

		lblImage = new JLabel("");
		panelImage.add(lblImage, BorderLayout.CENTER);

		panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);

		btnConfirm = new JButton("Confirm");
		panelBottom.add(btnConfirm);

		btnCancel = new JButton("Cancel");
		panelBottom.add(btnCancel);
		
		new ControllerAdd(this);
		cBYear.setSelectedIndex(0);
		setVisible(true);
		setLocationRelativeTo(frame);
	}
	
	public void addActListeners(ActionListener listener) {
		btnCancel.addActionListener(listener);
		btnConfirm.addActionListener(listener);
		btnSelect.addActionListener(listener);
		
	}

	public JPanel getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(JPanel panelTitle) {
		this.panelTitle = panelTitle;
	}

	public JPanel getPanelTitleCard() {
		return panelTitleCard;
	}

	public void setPanelTitleCard(JPanel panelTitleCard) {
		this.panelTitleCard = panelTitleCard;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JPanel getPanelInputs() {
		return panelInputs;
	}

	public void setPanelInputs(JPanel panelInputs) {
		this.panelInputs = panelInputs;
	}

	public JPanel getPanelImage() {
		return panelImage;
	}

	public void setPanelImage(JPanel panelImage) {
		this.panelImage = panelImage;
	}

	public JPanel getPanelBottom() {
		return panelBottom;
	}

	public void setPanelBottom(JPanel panelBottom) {
		this.panelBottom = panelBottom;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	public JComboBox<String> getcBType() {
		return cBType;
	}

	public void setcBType(JComboBox<String> cBType) {
		this.cBType = cBType;
	}

	public JLabel getLblAge() {
		return lblAge;
	}

	public void setLblAge(JLabel lblAge) {
		this.lblAge = lblAge;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}

	public JLabel getLblImage() {
		return lblImage;
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(JButton btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public Font getFontLabels() {
		return fontLabels;
	}

	public void setFontLabels(Font fontLabels) {
		this.fontLabels = fontLabels;
	}

	public JComboBox<Integer> getcBYear() {
		return cBYear;
	}

	public void setcBYear(JComboBox<Integer> cBYear) {
		this.cBYear = cBYear;
	}

}
