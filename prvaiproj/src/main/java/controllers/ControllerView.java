package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.AI;
import util.DataManagement;
import views.GUIMainMenu;
import views.GUIView;

public class ControllerView {
	private GUIView guiView;
	private int index;

	public ControllerView(GUIView guiView) {
		this.guiView = guiView;
		index = 0;
		guiView.addActListeners(new ActListener());
		guiView.addListSelectionListeners(new LSListener());
		refreshComponents();
		initializeList();
	}

	public void initializeList() {
		DefaultListModel<String> dlm = new DefaultListModel<>();
		for (AI a : DataManagement.recoverAIList()) {
			dlm.addElement(a.getName());
		}
		guiView.getListAI().setModel(dlm);
		guiView.getListAI().setSelectedIndex(0);
	}

	public void refreshComponents() {
		List<AI> listAI = DataManagement.recoverAIList();
		guiView.getLblIndex().setText((index + 1) + "/" + listAI.size());
		guiView.getLblImage().setText("");
		guiView.getLblImage().setIcon(new ImageIcon(DataManagement.decodeBase64ToBufferedImage(listAI.get(index).getImgPath())));
		guiView.getLblName().setText(listAI.get(index).getName());
		guiView.getLblYear().setText(String.valueOf(listAI.get(index).getYear()));
		guiView.getLblType().setText(listAI.get(index).getType() + " -");
		guiView.getListAI().setSelectedIndex(index);
		toggleButtons();
	}

	public void toggleButtons() {
			guiView.getBtnNext().setEnabled(index < DataManagement.recoverAIList().size() - 1);
			guiView.getBtnLast().setEnabled(index < DataManagement.recoverAIList().size() - 1);
			guiView.getBtnFirst().setEnabled(index > 0);
			guiView.getBtnPrevious().setEnabled(index > 0);
		
	}

	private class ActListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn == guiView.getBtnReturn()) {
				new GUIMainMenu(guiView);
				guiView.dispose();
			} else if (btn == guiView.getBtnFirst())
				index = 0;
			else if (btn == guiView.getBtnNext())
				index++;
			else if (btn == guiView.getBtnPrevious())
				index--;
			else if (btn == guiView.getBtnLast())
				index = DataManagement.recoverAIList().size() - 1;
			refreshComponents();
		}

	}

	private class LSListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			@SuppressWarnings("unchecked")
			JList<String> list = (JList<String>) e.getSource();
			index = list.getSelectedIndex();
			if(list.getSelectedIndex() == -1)
				index = 0;
			refreshComponents();
		}

	}

}
