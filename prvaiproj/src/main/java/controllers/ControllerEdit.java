package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.AI;
import util.DataManagement;
import views.GUIEdit;
import views.GUIMainMenu;

public class ControllerEdit {
	private GUIEdit guiEdit;
	private int index;
	private boolean editMode;
	private ImageIcon editedImg;

	public ControllerEdit(GUIEdit guiEdit) {
		this.guiEdit = guiEdit;
		index = 0;
		editMode = false;
		editedImg = new ImageIcon(DataManagement.decodeBase64ToBufferedImage(DataManagement.recoverAIList().get(index).getImgPath()));
		guiEdit.addActListeners(new ActListener());
		guiEdit.addListSelectionListeners(new LSListener());
		initializeCBxes();
		initializeList();
		refreshComponents();

	}

	public void refreshComponents() {
		List<AI> listAI = DataManagement.recoverAIList();
		guiEdit.getLblIndex().setText((index + 1) + "/" + listAI.size());
		guiEdit.getLblImage().setText("");
		guiEdit.getLblImage()
				.setIcon(new ImageIcon(DataManagement.decodeBase64ToBufferedImage(listAI.get(index).getImgPath())));
		guiEdit.getTxtName().setText(listAI.get(index).getName());
		guiEdit.getcBYear().setSelectedItem(listAI.get(index).getYear());
		guiEdit.getcBType().setSelectedItem(listAI.get(index).getType());
		guiEdit.getListAI().setSelectedIndex(index);
		toggleButtons();
	}

	public void toggleButtons() {
		guiEdit.getBtnNext().setEnabled(index < DataManagement.recoverAIList().size() - 1);
		guiEdit.getBtnLast().setEnabled(index < DataManagement.recoverAIList().size() - 1);
		guiEdit.getBtnFirst().setEnabled(index > 0);
		guiEdit.getBtnPrevious().setEnabled(index > 0);

	}

	private class ActListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn == guiEdit.getBtnReturn()) {
				new GUIMainMenu(guiEdit);
				guiEdit.dispose();
			} else if (btn == guiEdit.getBtnDelete())
				deletionProcess();
			else if (btn == guiEdit.getBtnEdit()) {
				changeEditButtons();
				if (!editMode)
					applyChanges();
			} else if (btn == guiEdit.getBtnCancel())
				refreshComponents();
			else if (btn == guiEdit.getBtnFirst()) {
				index = 0;
				refreshComponents();
			} else if (btn == guiEdit.getBtnNext()) {
				index++;
				refreshComponents();
			} else if (btn == guiEdit.getBtnPrevious()) {
				index--;
				refreshComponents();
			} else if (btn == guiEdit.getBtnLast()) {
				index = DataManagement.recoverAIList().size() - 1;
				refreshComponents();
			} else if (btn == guiEdit.getBtnSelectImg()) {
				selectImg();
			}
			if (editMode && btn != guiEdit.getBtnEdit() && btn != guiEdit.getBtnSelectImg())
				changeEditButtons();
		}

	}

	public void selectImg() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(guiEdit) == JFileChooser.APPROVE_OPTION) {
			String[] jfcName = jfc.getSelectedFile().getAbsolutePath().split("\\.");
			if (DataManagement.listImageSuffixes().contains(jfcName[jfcName.length - 1])) {
				guiEdit.getLblImage().setText("");
				editedImg = DataManagement.scaleImg(jfc.getSelectedFile().getAbsolutePath());
				guiEdit.getLblImage().setIcon(editedImg);

			} else
				JOptionPane.showMessageDialog(guiEdit, "Not an Image!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initializeList() {
		DefaultListModel<String> dlm = new DefaultListModel<>();
		for (AI a : DataManagement.recoverAIList()) {
			dlm.addElement(a.getName());
		}
		guiEdit.getListAI().setModel(dlm);
		guiEdit.getListAI().setSelectedIndex(0);
	}

	public void initializeCBxes() {
		// Initialise the year
		for (int i = LocalDate.now().getYear(); i >= 1950; i--) {
			guiEdit.getcBYear().addItem(i);
		}
		// Initialise the type
		guiEdit.getcBType().addItem("Reactive");
		guiEdit.getcBType().addItem("Limited Memory");
		guiEdit.getcBType().addItem("Theory of Mind");
		guiEdit.getcBType().addItem("Self-Awareness");
	}

	public void applyChanges() {
		int confirmation = JOptionPane.showConfirmDialog(guiEdit, "Are you sure you want to apply the changes?",
				"Confirm", JOptionPane.WARNING_MESSAGE);
		if (confirmation == JOptionPane.YES_OPTION) {
			// Update AI details
			AI currentAI = new AI(DataManagement.recoverAIList().get(index).getId(), guiEdit.getTxtName().getText(),
					guiEdit.getcBType().getItemAt(guiEdit.getcBType().getSelectedIndex()),
					guiEdit.getcBYear().getItemAt(guiEdit.getcBYear().getSelectedIndex()),
					DataManagement.encodeBufferedImageToBase64(
							DataManagement.scaleImg(DataManagement.convertImageToBufferedImage(editedImg.getImage()))));
			;
			DataManagement.deleteAI(DataManagement.recoverAIList().get(index));
			DataManagement.insertAI(currentAI);

			// Refresh AI list
			DataManagement.refreshAIList();
			// Reset the edited image
			editedImg = null;
			refreshComponents();
		}
	}

	public void changeEditButtons() {
		editMode = !editMode;
		if (editMode)
			guiEdit.getBtnEdit().setText("Apply");
		else
			guiEdit.getBtnEdit().setText("Edit");
		guiEdit.getTxtName().setEnabled(editMode);
		guiEdit.getcBType().setEnabled(editMode);
		guiEdit.getcBYear().setEnabled(editMode);
		guiEdit.getBtnSelectImg().setEnabled(editMode);
		guiEdit.getBtnCancel().setVisible(editMode);
	}

	public void deletionProcess() {
		int confirmation = JOptionPane.showConfirmDialog(guiEdit, "Are you sure you want to delete this(ese) AIs?",
				"Confirm", JOptionPane.WARNING_MESSAGE);
		if (confirmation == JOptionPane.YES_OPTION) {
			for (int i = 0; i < DataManagement.recoverAIList().size(); i++)
				if (guiEdit.getListAI().isSelectedIndex(i))
					DataManagement.deleteAI(DataManagement.recoverAIList().get(i));
			System.out.println("Success");
			JOptionPane.showMessageDialog(guiEdit, "Successfully deleted Ai(s).", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		}
		index = 0;
		if (DataManagement.recoverAIList().size() <= 0) {
			JOptionPane.showMessageDialog(guiEdit, "No more AIs!", "Error", JOptionPane.ERROR_MESSAGE);
			new GUIMainMenu(guiEdit);
			guiEdit.dispose();
		} else {
			refreshComponents();
			initializeList();
		}
	}

	private class LSListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			@SuppressWarnings("unchecked")
			JList<String> list = (JList<String>) e.getSource();
			index = list.getSelectedIndex();
			if (list.getSelectedIndex() == -1)
				index = 0;
			refreshComponents();
		}

	}

}
