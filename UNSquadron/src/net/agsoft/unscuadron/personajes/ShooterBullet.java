package net.agsoft.unscuadron.personajes;

import net.agsoft.unscuadron.controladores.ResourceManager;
import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class ShooterBullet extends Enemy {

	public enum BulletDirection {
		UP, LEFT, RIGHT, DOWN
	}
	
	private Texture texture;
	
	public ShooterBullet(float x, float y, float speed, BulletDirection bulletDirection) {
		super(x, y, speed);
		
		float posicionX =  x;
		float posicionY =  y;
		texture = ResourceManager.getTexture("tiro2");
		setRect(new Rectangle(x, y, Constants.BOSS_SHOT_WIDTH, Constants.BOSS_SHOT_HEIGHT));
	}

	@Override
	public void update(float dt) {
		
		if (getX()> 400){
			setX(getX() - getSpeed() * dt);
			setRectX(getX());
		}
		
		else {
			if (getX() < 400){
				setX(getX() - getSpeed() * dt * MathUtils.random(1, 3));
				setRectX(getX());
			}
		}
		
		
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(texture, getX(), getY());
	}
}
