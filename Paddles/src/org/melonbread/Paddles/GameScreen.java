package org.melonbread.Paddles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {
	final Paddles game;

	private OrthographicCamera camera;
	private Paddle p1Paddle, p2Paddle;
	private Ball ball;
	private int p1Score, p2Score;

	public GameScreen (final Paddles _game) {
		this.game = _game;
		
		p1Score = 0;
		p2Score = 0;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth() , Gdx.graphics.getHeight() );
		
		p1Paddle = new Paddle(50, Gdx.graphics.getHeight() / 2, Gdx.graphics.getHeight());
		p2Paddle = new Paddle(Gdx.graphics.getWidth() - 50, Gdx.graphics.getHeight()  / 2, Gdx.graphics.getHeight());
		ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		
	}

	@Override
	public void dispose() {
		game.batch.dispose();
		p1Paddle.getTexture().dispose();
		p2Paddle.getTexture().dispose();
	}


	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		game.batch.begin();
		game.font.draw(game.batch,  Integer.toString(p1Score), (Gdx.graphics.getWidth() / 2) - (game.font.getScaleX() * 10), Gdx.graphics.getHeight() -20);
		game.font.draw(game.batch, Integer.toString(p2Score), (Gdx.graphics.getWidth() / 2) +(game.font.getScaleX() * 10), Gdx.graphics.getHeight() -20);
		game.batch.draw(p1Paddle.getTexture(), p1Paddle.getX(), p1Paddle.getY());
		game.batch.draw(p2Paddle.getTexture(), p2Paddle.getX(), p2Paddle.getY());
		game.batch.draw(ball.getTexture(), ball.getX(), ball.getY());
		game.batch.end();
		
		
		
		if(Gdx.input.isKeyPressed(Keys.W))
			p1Paddle.MoveUp(10);
		if(Gdx.input.isKeyPressed(Keys.S))
			p1Paddle.MoveDown(10);
		
		if(Gdx.input.isKeyPressed(Keys.UP))
			p2Paddle.MoveUp(10);
		if(Gdx.input.isKeyPressed(Keys.DOWN))
			p2Paddle.MoveDown(10);
		
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			p1Paddle.Reset();
			p2Paddle.Reset();
			ball.Reset();
		}	
		
		ball.Move();
		if (ball.getX() < 0) {
			p2Score++;
			ball.Reset();
		}
			
		if (ball.getX() > Gdx.graphics.getWidth() ) {
			p1Score++;
			ball.Reset();
		}
		
		CheckContact();
	}
	

	
	public void CheckContact() {
		if(p1Paddle.getRectangle().overlaps(ball.getRectangle())) {
				ball.HitPaddle();
		}
		if(p2Paddle.getRectangle().overlaps(ball.getRectangle()))
			ball.HitPaddle();
	}
	
	@Override
 	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}