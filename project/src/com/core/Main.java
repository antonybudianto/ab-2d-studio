package com.core;

import com.falcron.core.SimpleGame;
import com.scenes.MainScene;

public class Main extends SimpleGame{

	@Override
	public void initScene() {
		setVisible(true);
		addScene("mainscene", MainScene.class);
		loadScene("mainscene");
	}

	@Override
	public void initResource() {
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
