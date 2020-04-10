package com.rayco.dragonball.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import com.rayco.dragonball.MyDragonballGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(MyDragonballGame.GAME_IDENTIFIER);
		config.vSyncEnabled = true;
		config.title = "Dragon Ball Test";
		config.width = 800;
		config.height = 600;
		new DesktopMini2DxGame(new MyDragonballGame(), config);
	}
}
