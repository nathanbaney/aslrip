package com.neb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;

public class ASLRip extends Game {
	private PlayScreen playScreen;
	public ModelBatch modelBatch;

	@Override
	public void create() {
		playScreen = new PlayScreen(this);
		modelBatch = new ModelBatch();
		this.setScreen(playScreen);
	}
	@Override
	public void render(){
		super.render();
	}
	@Override
	public void dispose(){
		playScreen.dispose();

	}
}
