package controllers;

import util.MongoConnect;
import views.GUIConnect;
import views.GUIMainMenu;

public class ControllerConnect {

	public ControllerConnect(GUIConnect guiConnect) {
		//Get necessary collection.
		MongoConnect.getCollection();
		guiConnect.dispose();
		new GUIMainMenu(guiConnect);
	}
	
}
