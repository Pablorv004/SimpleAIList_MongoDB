package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import util.DataManagement;
import views.GUIAdd;
import views.GUIMainMenu;

public class ControllerAdd {
	private GUIAdd guiAdd;
	private ImageIcon savedImg;

	public ControllerAdd(GUIAdd guiAdd) {
		this.guiAdd = guiAdd;
		initializeCBxes();
		guiAdd.addActListeners(new ActListener());
	}

	public void initializeCBxes() {
		// Initialise the year
		for (int i = LocalDate.now().getYear(); i >= 1950; i--) {
			guiAdd.getcBYear().addItem(i);
		}
		// Initialise the type
		guiAdd.getcBType().addItem("Reactive");
		guiAdd.getcBType().addItem("Limited Memory");
		guiAdd.getcBType().addItem("Theory of Mind");
		guiAdd.getcBType().addItem("Self-Awareness");
	}

	

	public void selectImg() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(guiAdd) == JFileChooser.APPROVE_OPTION) {
			String[] jfcName = jfc.getSelectedFile().getAbsolutePath().split("\\.");
			if (DataManagement.listImageSuffixes().contains(jfcName[jfcName.length - 1])) {
				guiAdd.getLblImage().setText("");
				savedImg = DataManagement.scaleImg(jfc.getSelectedFile().getAbsolutePath());
				guiAdd.getLblImage().setIcon(savedImg);
			} else
				JOptionPane.showMessageDialog(guiAdd, "Not an Image!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class ActListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn == guiAdd.getBtnCancel()) {
				new GUIMainMenu(guiAdd);
				guiAdd.dispose();
			} else if (btn == guiAdd.getBtnSelect()) {
				selectImg();
			} else if (btn == guiAdd.getBtnConfirm()) {
				confirmButton();
			}
		}

	}

	public void confirmButton() {
		if (checkFields()) {
			DataManagement.writeAIImg(savedImg, DataManagement.getLastID());
			DataManagement.insertAI(guiAdd.getTxtName().getText(),
					guiAdd.getcBType().getItemAt(guiAdd.getcBType().getSelectedIndex()),
					guiAdd.getcBYear().getItemAt(guiAdd.getcBYear().getSelectedIndex()),
					"src/main/resources/AI/ai_" + DataManagement.getLastID() + ".png");
			JOptionPane.showMessageDialog(guiAdd, "AI Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
			new GUIMainMenu(guiAdd);
			guiAdd.dispose();
		} else
			JOptionPane.showMessageDialog(guiAdd, "Make sure you fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
	}

	public boolean checkFields() {
		return !guiAdd.getTxtName().getText().isEmpty() && savedImg != null;
	}
}
