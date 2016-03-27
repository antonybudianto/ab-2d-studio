package com.scenes;

import java.awt.Graphics2D;
import java.io.File;
import java.security.KeyStore.LoadStoreParameter;

import com.ab2ds.util.ScriptGenerator;
import com.falcron.core.SimpleGame;
import com.falcron.graphics.core.SimpleText;
import com.falcron.graphics.scene.SimpleScene;
import com.falcron.sprite.AnimatedSprite;

public class MainScene extends SimpleScene{
	
	public MainScene(SimpleGame game) {
		super(game);
		//Get scene XML from com.scenes for JAR access
		loadXML("MainScene");
	}
	
	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(Graphics2D g2d) {
		
	}

	@Override
	public void initResource() {
		
	}

}
