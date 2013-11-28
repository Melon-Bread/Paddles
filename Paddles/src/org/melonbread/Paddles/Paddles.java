package org.melonbread.Paddles;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Paddles extends Game {
	
	SpriteBatch batch;
	BitmapFont font;
	
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setScale(Gdx.graphics.getWidth() * 0.005f, Gdx.graphics.getHeight() * 0.005f);
		this.setScreen(new MainMenuScreen(this));
		
	}
	
	public void render() {
		super.render();
	}
	
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
