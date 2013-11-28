package org.melonbread.Paddles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public class Paddle {

	private Rectangle rectanglePaddle;
	private float positionX;
	private float positionY;
	private int screenHeight;
	private Texture texturePaddle;

	public Paddle (float _positionX, float _positionY, int _screenHeight) {
		positionX = _positionX;
		positionY = _positionY;
		screenHeight = _screenHeight;
		
		rectanglePaddle = new Rectangle(positionX, positionY, 20, 100);
		
		texturePaddle = new Texture(Gdx.files.internal("data/paddle.png"));
		
	}
	
	public Texture getTexture() {
		return texturePaddle;
	}
	
	public Rectangle getRectangle() {
		return rectanglePaddle;
	}
	
	public float getX () {
		return rectanglePaddle.x;
	}
	
	public float getY () {
		return rectanglePaddle.y;
	}
	

	// Moves the Paddle up
	public void MoveUp (int _moveSpeed) {

		rectanglePaddle.y += _moveSpeed;

		KeepOnScreen();
	}

	// Moves the Paddle Down
	public void MoveDown (int _moveSpeed) {

		rectanglePaddle.y -= _moveSpeed;

		KeepOnScreen();
	}

	// Resets the Paddle to its original position
	// [Primarily used for a new game]
	public void Reset () {

		rectanglePaddle.x = positionX; // Just to be safe, although the X position should never change
		rectanglePaddle.y = positionY;
	}

	// Checks to see if movement would send the paddle off screen
	// and keeps it from leaving the screen
	private void KeepOnScreen() {

		if(rectanglePaddle.y < 0) rectanglePaddle.y = 0;
		if(rectanglePaddle.y > (screenHeight - 100)) rectanglePaddle.y = (screenHeight - 100);
	}


}