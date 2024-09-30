package main;

import com.formdev.flatlaf.FlatLightLaf;

import views.GUIConnect;

public class App {
	public static void main(String[] args) {
		FlatLightLaf.setup();
		new GUIConnect();
	}
}
