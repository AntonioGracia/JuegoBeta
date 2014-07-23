package net.agsoft.unscuadron.personajes;

import net.agsoft.unscuadron.controladores.ResourceManager;
import net.agsoft.unscuadron.util.Constants;
import com.badlogic.gdx.math.Rectangle;

public class SmallEnemy extends Enemy {

	public SmallEnemy(float x, float y, float speed) {
		super(x, y, speed);
		
		animation = ResourceManager.getAnimation("rojo");
		setRect(new Rectangle(x, y, Constants.ENEMY_WIDTH, Constants.ENEMY_HEIGHT));
		setValue(100);
		setLives(1);
	}
	
	@Override
	public void update(float dt) {
		
		super.update(dt);
		setX(getX() + getSpeed() * dt);
		setRectX(getX());
	}
}
