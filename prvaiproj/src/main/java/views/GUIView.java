package views;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import controllers.ControllerView;

public class GUIView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTitle;
	private JSeparator separator;
	private JPanel panelList;
	private JPanel panelButtons;
	private JPanel panelAI;
	private JPanel panelName;
	private JLabel lblName;
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
	private JLabel lblType;
	private JLabel lblYear;
	private JPanel panelIndex;
	private JLabel lblIndex;

	/**
	 * Create the frame.
	 */
	public GUIView(JFrame frame) {
		setTitle("AI Registry - View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 454);
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
		lblTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		panelTitleCard.add(lblTitle);
		
		panelList = new JPanel();
		contentPane.add(panelList, BorderLayout.EAST);
		panelList.setLayout(new BorderLayout(0, 0));
		
		
		listAI = new JList<>();
		listAI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPAI = new JScrollPane(listAI);
		panelList.add(sPAI);
		
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
		
		lblName = new JLabel("Sample Name");
		lblName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 28));
		panelName.add(lblName);
		
		panelImage = new JPanel();
		panelAI.add(panelImage, BorderLayout.CENTER);
		
		lblImage = new JLabel("Image");
		panelImage.add(lblImage);
		
		panelData = new JPanel();
		panelAI.add(panelData, BorderLayout.SOUTH);
		
		lblType = new JLabel("Sample Type");
		lblType.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		panelData.add(lblType);
		
		lblYear = new JLabel("2024");
		lblYear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		panelData.add(lblYear);
		
		new ControllerView(this);
		setVisible(true);
		setLocationRelativeTo(frame);
	}
	
	public void addActListeners(ActionListener listener) {
		btnFirst.addActionListener(listener);
		btnLast.addActionListener(listener);
		btnNext.addActionListener(listener);
		btnPrevious.addActionListener(listener);
		btnReturn.addActionListener(listener);
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

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
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

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
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

	public JLabel getLblType() {
		return lblType;
	}

	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	public JLabel getLblYear() {
		return lblYear;
	}

	public void setLblYear(JLabel lblYear) {
		this.lblYear = lblYear;
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
	
	

}
