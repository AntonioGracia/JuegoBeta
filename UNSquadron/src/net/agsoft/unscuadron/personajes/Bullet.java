package net.agsoft.unscuadron.personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Bullet extends Character {

	protected Texture texture;
	
	public Bullet(float x, float y, float speed) {
		super(x, y, speed);
	}
	
	public void draw(SpriteBatch batch) {
		
		batch.draw(texture, getX(), getY());
	}
	
	public abstract void update(float dt);

}
