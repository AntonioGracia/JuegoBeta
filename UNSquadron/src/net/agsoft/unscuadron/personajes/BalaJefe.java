package net.agsoft.unscuadron.personajes;

import net.agsoft.unscuadron.controladores.ResourceManager;

import com.badlogic.gdx.math.Rectangle;

public class BalaJefe extends Enemy {

	public BalaJefe(float x, float y, float speed) {
		super(x, y, speed);
		
		texture = ResourceManager.getTexture("armaPrincipal");
		setRect(new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
	}

	@Override
	public void update(float dt) {
		setX(getX() + getSpeed() * dt);
		setRectX(getX());
	}
}
