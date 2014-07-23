package net.agsoft.unscuadron.personajes;

import java.util.ArrayList;
import java.util.List;

import net.agsoft.unscuadron.controladores.ConfigurationManager;
import net.agsoft.unscuadron.controladores.ResourceManager;
import net.agsoft.unscuadron.controladores.SpriteManager;
import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Ship extends Character {

	private List<Bullet> bullets;
	private int bombs;

	private int missiles;

	private int score;
	private float shieldTime;
	private float bulletTime;
	private float armaSecundaria;
	public Ship(float x, float y, float speed, ConfigurationManager configurationManager) {
		super(x, y, speed);
		
		bullets = new ArrayList<Bullet>();
		bombs = 3;
		missiles = 10;
		score = 0;
		shieldTime = 0;
		
		animation = ResourceManager.getAnimation("ship");
		setRect(new Rectangle(x, y, Constants.SHIP_WIDTH, Constants.SHIP_HEIGHT));
	}
	

	
	
	
	public List<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}

	public int getBombs() {
		return bombs;
	}
	
	public void setBombs(int bombs) {
		this.bombs = bombs;
	}
	
	public int getMissiles() {
		return missiles;
	}
	
	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public float getShieldTime() {
		return shieldTime;
	}
	
	public void setShieldTime(float time) {
		this.shieldTime = time;
	}

	@Override
	public void draw(SpriteBatch batch) {
		
		batch.draw(currentFrame, getX(), getY());
	}
	

	public void update(float dt, SpriteManager spriteManager) {
		
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		
		bulletTime += dt;
		armaSecundaria += dt;
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			
			if (getX() > 0)
				setX(getX() - getSpeed() * dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			
				setX(getX() + getSpeed() * dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			
			if (getY() > 5f)
				setY(getY() - getSpeed() * dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			
				setY(getY() + getSpeed() * dt);
		}
		
		setRectX(getX());
		setRectY(getY());
		
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {

			if (bulletTime >= getBulletRate()) {
				bulletTime = 0;
			
				
				shoot();
			}
		}
		
		
		if (Gdx.input.isKeyPressed(Keys.NUM_1)){
			if (armaSecundaria >= getArmaSecundaria()) {
				armaSecundaria = 0;
				
			
				
				disparoDos();
			}
		}


	}
	

	public void shoot() {
		
		Bullet bullet = new ShipBullet(getX() + 50, getY(), getBulletSpeed());
		getBullets().add(bullet);
		
	}
	
	public void disparoDos(){
		Bullet bullet = new WeaponOne(getX() + 50, getY() +90, getBulletSpeed());
		getBullets().add(bullet);
		bullet = new WeaponOne(getX() + 50, getY() -60, getBulletSpeed());
		getBullets().add(bullet);
		bullet = new WeaponOne(getX() + 50, getY() +60, getBulletSpeed());
		getBullets().add(bullet);
		bullet = new WeaponOne(getX() + 50, getY() +30, getBulletSpeed());
		getBullets().add(bullet);
		bullet = new WeaponOne(getX() + 50, getY()-30, getBulletSpeed());
		getBullets().add(bullet);
		bullet = new WeaponOne(getX() + 50, getY(), getBulletSpeed());
		getBullets().add(bullet);
	}
	

	
}
