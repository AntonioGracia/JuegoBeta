package net.agsoft.unscuadron.controladores;

import java.util.List;

import net.agsoft.unscuadron.UNSquadron;
import net.agsoft.unscuadron.pantallas.GameOver;
import net.agsoft.unscuadron.personajes.Bullet;
import net.agsoft.unscuadron.personajes.Enemy;
import net.agsoft.unscuadron.personajes.Ship;
import net.agsoft.unscuadron.personajes.ShipBullet;
import net.agsoft.unscuadron.personajes.JefeCabron;
import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class SpriteManager {

	private Texture background;
	private Ship ship;
	private JefeCabron shooterEnemy;
	private Array<Enemy> enemies;
	private ShipBullet shipBullet;

	private UNSquadron unSquadron;
	
	public SpriteManager(UNSquadron unSquadron) {
	
		background = ResourceManager.getTexture("fondo");
		
		ResourceManager.getSound("intro").play();
		
		ship = new Ship(50, 50, 300, unSquadron.configurationManager);
		shooterEnemy = null;
		ship.setLives(Constants.SHIP_LIVES);
		enemies = new Array<Enemy>();
		this.unSquadron = unSquadron;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public Array<Enemy> getEnemies() {
		return enemies;
	}
	
		
	public JefeCabron getShooterEnemy() {
		return shooterEnemy;
	}

	public ShipBullet getShipBullet() {
		return shipBullet;
	}

	public void update(float dt) {
		
		
		updateEnemies(dt);
		updateBalas(dt);
		checkGolpes(dt);
	}
	
	public void updateBalas(float dt){
		
		List<Bullet> balas = ship.getBullets();
		
		Bullet bullet = null;
		
			for (int i = balas.size() - 1; i >= 0; i--) {
			
			bullet = balas.get(i);
			bullet.update(dt);
			
		}
	}
	
	private void updateEnemies(float dt) {
		
	
		for (int i = enemies.size - 1; i >= 0; i--) {
			
			Enemy enemy = enemies.get(i);
			enemy.update(dt);
						
			if ((enemy.getX() < 0) || (enemy.getY() < 0)) {
				enemies.removeIndex(i);
			}		
			
			if (enemy.getClass().getSimpleName().equals("JefeCabron"))
				((JefeCabron) enemy).shoot(dt);
		}
	}
	
	public void checkGolpes(float dt){
		Bullet bullet = null;
		Enemy enemy = null;
		List<Bullet> bullets = ship.getBullets();
		
		for (int i = enemies.size - 1; i >= 0; i--) {
			enemy = enemies.get(i);
			for (int j = bullets.size() - 1; j >= 0; j--) {
				bullet = bullets.get(j);
				
				if (bullet.getRect().overlaps(enemy.getRect())) {
			
						enemy.hit();
						if (enemy.getLives() == 0) {
							ship.addScore(enemy.getValue());
							enemies.removeIndex(i);

						}
						if (enemy.getClass().getSimpleName().equals("JefeCabron")){
							if (enemy.getLives() == 0 ){
								unSquadron.setScreen(new GameOver(unSquadron));
							}
		
						}
						
				
						bullets.remove(j);
				}
			}
		}
		
		
		for (int i = enemies.size -1 ; i>= 0; i--){
			enemy = enemies.get(i);
			
			if (enemy.getRect().overlaps(ship.getRect())) {
				ResourceManager.getSound("destruccion").play();
				enemy.hit();
				if (enemy.getLives() == 0) {
					ship.addScore(enemy.getValue());
					enemies.removeIndex(i);
				}
				
				if (ship.getLives() == 1){
					unSquadron.setScreen(new GameOver(unSquadron));
				}
									
				ship.hit();
				
			}
		}
	}
	
	
	public void draw(SpriteBatch batch) {
	
		batch.disableBlending();
		batch.draw(background, 0, 0);
		batch.enableBlending();
		
		ship.draw(batch);
		
		for (Bullet bullet : ship.getBullets()) {
			bullet.draw(batch);
		}
		
		for (Enemy enemy : enemies) {
			//System.out.println(enemy.getClass().getSimpleName());
			enemy.draw(batch);
		}
		
	}
	
	
	
}
