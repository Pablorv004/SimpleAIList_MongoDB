package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import controllers.ControllerEdit;

public class GUIEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTitle;
	private JSeparator separatorTitle;
	private JPanel panelList;
	private JPanel panelButtons;
	private JPanel panelAI;
	private JPanel panelName;
	private JPanel panelTitleCard;
	private JLabel lblTitle;
	private JPanel panelImage;
	private JPanel panelData;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnReturn;
	private JSeparator separatorButton;
	private JScrollPane sPAI;
	private JList<String> listAI;
	private JLabel lblImage;
	private JTextField txtName;
	private JComboBox<String> cBType;
	private JComboBox<Integer> cBYear;
	private JButton btnDelete;
	private JButton btnEdit;
	private JPanel panelIndex;
	private JLabel lblIndex;
	private JButton btnSelectImg;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public GUIEdit(JFrame frame) {
		setTitle("AI Registry - Edit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));

		separatorTitle = new JSeparator();
		panelTitle.add(separatorTitle, BorderLayout.SOUTH);

		panelTitleCard = new JPanel();
		panelTitle.add(panelTitleCard, BorderLayout.NORTH);

		lblTitle = new JLabel("AI Registry Editor");
		lblTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		panelTitleCard.add(lblTitle);

		panelList = new JPanel();
		contentPane.add(panelList, BorderLayout.EAST);
		panelList.setLayout(new BorderLayout(0, 0));

		listAI = new JList<>();
		
		sPAI = new JScrollPane(listAI);
		panelList.add(sPAI);

		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("You may select multiple AIs to delete at once from the list.");
		panelList.add(btnDelete, BorderLayout.SOUTH);

		panelIndex = new JPanel();
		panelList.add(panelIndex, BorderLayout.NORTH);

		lblIndex = new JLabel("0/?");
		panelIndex.add(lblIndex);

		panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);

		btnFirst = new JButton("First");
		panelButtons.add(btnFirst);

		btnPrevious = new JButton("Previous");
		panelButtons.add(btnPrevious);

		btnNext = new JButton("Next");
		panelButtons.add(btnNext);

		btnLast = new JButton("Last");
		panelButtons.add(btnLast);

		separatorButton = new JSeparator();
		separatorButton.setOrientation(SwingConstants.VERTICAL);
		panelButtons.add(separatorButton);

		btnReturn = new JButton("Return");
		panelButtons.add(btnReturn);

		panelAI = new JPanel();
		contentPane.add(panelAI, BorderLayout.CENTER);
		panelAI.setLayout(new BorderLayout(0, 0));

		panelName = new JPanel();
		panelAI.add(panelName, BorderLayout.NORTH);

		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 28));
		txtName.setText("Sample Name");
		panelName.add(txtName);
		txtName.setColumns(10);

		panelImage = new JPanel();
		panelAI.add(panelImage, BorderLayout.CENTER);

		lblImage = new JLabel("Image");
		panelImage.add(lblImage);

		btnSelectImg = new JButton("Select new Image...");
		btnSelectImg.setEnabled(false);
		panelImage.add(btnSelectImg);

		panelData = new JPanel();
		panelAI.add(panelData, BorderLayout.SOUTH);

		cBType = new JComboBox<>();
		cBType.setEnabled(false);
		cBType.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		panelData.add(cBType);
		
		cBYear = new JComboBox<>();
		cBYear.setEnabled(false);
		cBYear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		panelData.add(cBYear);

		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		panelData.add(btnEdit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setVisible(false);
		btnCancel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		panelData.add(btnCancel);

		new ControllerEdit(this);
		setVisible(true);
		setLocationRelativeTo(frame);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public void addActListeners(ActionListener listener) {
		btnDelete.addActionListener(listener);
		btnEdit.addActionListener(listener);
		btnFirst.addActionListener(listener);
		btnLast.addActionListener(listener);
		btnNext.addActionListener(listener);
		btnPrevious.addActionListener(listener);
		btnSelectImg.addActionListener(listener);
		btnReturn.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}

	public void addListSelectionListeners(ListSelectionListener listener) {
		listAI.addListSelectionListener(listener);
	}

	public JPanel getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(JPanel panelTitle) {
		this.panelTitle = panelTitle;
	}

	public JSeparator getSeparatorTitle() {
		return separatorTitle;
	}

	public void setSeparatorTitle(JSeparator separatorTitle) {
		this.separatorTitle = separatorTitle;
	}

	public JPanel getPanelList() {
		return panelList;
	}

	public void setPanelList(JPanel panelList) {
		this.panelList = panelList;
	}

	public JPanel getPanelButtons() {
		return panelButtons;
	}

	public void setPanelButtons(JPanel panelButtons) {
		this.panelButtons = panelButtons;
	}

	public JPanel getPanelAI() {
		return panelAI;
	}

	public void setPanelAI(JPanel panelAI) {
		this.panelAI = panelAI;
	}

	public JPanel getPanelName() {
		return panelName;
	}

	public void setPanelName(JPanel panelName) {
		this.panelName = panelName;
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

	public JPanel getPanelImage() {
		return panelImage;
	}

	public void setPanelImage(JPanel panelImage) {
		this.panelImage = panelImage;
	}

	public JPanel getPanelData() {
		return panelData;
	}

	public void setPanelData(JPanel panelData) {
		this.panelData = panelData;
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public void setBtnFirst(JButton btnFirst) {
		this.btnFirst = btnFirst;
	}

	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	public void setBtnPrevious(JButton btnPrevious) {
		this.btnPrevious = btnPrevious;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public void setBtnLast(JButton btnLast) {
		this.btnLast = btnLast;
	}

	public JButton getBtnReturn() {
		return btnReturn;
	}

	public void setBtnReturn(JButton btnReturn) {
		this.btnReturn = btnReturn;
	}

	public JSeparator getSeparatorButton() {
		return separatorButton;
	}

	public void setSeparatorButton(JSeparator separatorButton) {
		this.separatorButton = separatorButton;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JScrollPane getsPAI() {
		return sPAI;
	}

	public void setsPAI(JScrollPane sPAI) {
		this.sPAI = sPAI;
	}

	public JList<String> getListAI() {
		return listAI;
	}

	public void setListAI(JList<String> listAI) {
		this.listAI = listAI;
	}

	public JLabel getLblImage() {
		return lblImage;
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JComboBox<String> getcBType() {
		return cBType;
	}

	public void setcBType(JComboBox<String> cBType) {
		this.cBType = cBType;
	}

	public JComboBox<Integer> getcBYear() {
		return cBYear;
	}

	public void setcBYear(JComboBox<Integer> cBYear) {
		this.cBYear = cBYear;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnNewButton() {
		return btnEdit;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnEdit = btnNewButton;
	}

	public JPanel getPanelIndex() {
		return panelIndex;
	}

	public void setPanelIndex(JPanel panelIndex) {
		this.panelIndex = panelIndex;
	}

	public JLabel getLblIndex() {
		return lblIndex;
	}

	public void setLblIndex(JLabel lblIndex) {
		this.lblIndex = lblIndex;
	}

	public JButton getBtnSelectImg() {
		return btnSelectImg;
	}

	public void setBtnSelectImg(JButton btnSelectImg) {
		this.btnSelectImg = btnSelectImg;
	}

}
