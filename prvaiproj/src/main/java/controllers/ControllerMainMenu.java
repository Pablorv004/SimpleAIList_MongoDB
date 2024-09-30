package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import util.DataManagement;
import views.GUIAdd;
import views.GUIEdit;
import views.GUIMainMenu;
import views.GUIView;

public class ControllerMainMenu {
	private GUIMainMenu menu;
	
	public ControllerMainMenu(GUIMainMenu menu){
		this.menu = menu;
		menu.addActListeners(new ActListener());
		if(DataManagement.recoverAIList().size() == 0) {
			menu.getBtnEdit().setEnabled(false);
			menu.getBtnView().setEnabled(false);
		}
	}
	
	private class ActListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == menu.getBtnAdd())
				new GUIAdd(menu);
			else if(btn == menu.getBtnEdit())
				new GUIEdit(menu);
			else if(btn == menu.getBtnView())
				new GUIView(menu);
			menu.dispose();
		}
		
	}
}
