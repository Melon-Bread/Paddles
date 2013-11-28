package org.melonbread.Paddles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;



public class Ball {
	private Texture textureBall;
	private Rectangle rectangleBall;
	private Vector2 ballSpeed;
	private Sound bloop;


	public Ball(float _locationX, float _locationY) {
		ballSpeed = new Vector2(4, 4);
		textureBall = new Texture(Gdx.files.internal("data/ball.png"));
		rectangleBall = new Rectangle(_locationX, _locationY, 20, 20);
		
		bloop = Gdx.audio.newSound(Gdx.files.internal("data/boop.wav"));
	}
	
	public Vector2 getSpeed(){
		return ballSpeed;
	}
	
	public Texture getTexture() {
		return textureBall;
	}

	public float getX() {
		return rectangleBall.x;
	}
	
	public float getY() {
		return rectangleBall.y;
	}
	
	public Rectangle getRectangle() {
		return rectangleBall;
	}
	
 	public void HitPaddle() {
 		ballSpeed.x += 0.5;
 		
 		if(ballSpeed.y < 0)
 			ballSpeed.y -= 0.5;
 		else
 			ballSpeed.y += 0.5;
 		
 		ballSpeed.x *= -1;
 		ballSpeed.y *= -1;
		
		bloop.play();
	}
	
	
	public void Move() {
		rectangleBall.x += ballSpeed.x;
		rectangleBall.y += ballSpeed.y;
		CheckBounds();
	}

	private void CheckBounds() {
		if(rectangleBall.y > Gdx.graphics.getHeight()  || rectangleBall.y < 0) {
			ballSpeed.y *= -1;
		}	
	}

	//public void 

	public void Reset() {
		rectangleBall.x = Gdx.graphics.getWidth() / 2;
		rectangleBall.y = Gdx.graphics.getHeight() / 2;
		if(ballSpeed.x < 0){
			ballSpeed.x = -4;
			ballSpeed.y = -4;
		}
		else {
			ballSpeed.x = 4;
			ballSpeed.y = 4;
		}
	}
}