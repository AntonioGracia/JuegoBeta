package net.agsoft.unscuadron.personajes;

import net.agsoft.unscuadron.UNSquadron;
import net.agsoft.unscuadron.controladores.ResourceManager;
import net.agsoft.unscuadron.controladores.SpriteManager;
import net.agsoft.unscuadron.personajes.ShooterBullet.BulletDirection;
import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class JefeCabron extends Enemy {

	private final float BULLET_RATE = 1f;
	UNSquadron unSquadron;
	private SpriteManager spriteManager;
	private Array<Enemy> enemies;
	private BulletDirection bulletDirection;
	private float tiempoEntreBalas;
	
	public JefeCabron(float x, float y, float speed, BulletDirection bulletDirection) {
		super(x, y, speed);
		
		animation = ResourceManager.getAnimation("avionGrande");
		setRect(new Rectangle(x, y, Constants.ENEMY_WIDTH, Constants.ENEMY_HEIGHT));
		setValue(5);
		setLives(5);
		
		this.bulletDirection = bulletDirection;
		tiempoEntreBalas = 0;
	}


	public void setEnemies(Array<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	public void setBulletDirection(BulletDirection bulletDirection) {
		this.bulletDirection = bulletDirection;
	}
	
	@Override
	public void update(float dt) {
		
		super.update(dt);
		
		setY(getY() + getSpeed() * dt);
		setRectY(getY());
		
		if (getY()<= 0){
			setY(400);
			setRectY(400);
		}
	}
	
	public void shoot(float dt) {
		
		tiempoEntreBalas += dt;
		
		if (tiempoEntreBalas >= BULLET_RATE) {
		
			tiempoEntreBalas = 0;
			Enemy bullet = new ShooterBullet(getX(), getY(), 150f, bulletDirection);
			enemies.add(bullet);
			bullet = new ShooterBullet(getX(), getY()-20, 120f, bulletDirection);
			enemies.add(bullet);
		}
	}


	
}
