package com.badlogic.drop.desktop;

import com.badlogic.drop.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Game";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Game(), config);
	}
}
