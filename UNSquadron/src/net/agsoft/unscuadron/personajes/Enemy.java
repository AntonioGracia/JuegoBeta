package net.agsoft.unscuadron.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Enemy extends Character {
	
	public enum EnemyType {
		BadShip, SmallEnemy
	}
	
	private int value;
	
	public Enemy(float x, float y) {
		super(x, y);
	}
	
	public Enemy(float x, float y, float speed) {
		super(x, y, speed);
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public void update(float dt) {
		
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(currentFrame, getX(), getY());
	}
}
