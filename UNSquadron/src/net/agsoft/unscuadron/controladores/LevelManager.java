package net.agsoft.unscuadron.controladores;

import java.util.Random;

import net.agsoft.unscuadron.personajes.Enemy;
import net.agsoft.unscuadron.personajes.Enemy.EnemyType;
import net.agsoft.unscuadron.personajes.Ship;
import net.agsoft.unscuadron.personajes.ShooterBullet.BulletDirection;
import net.agsoft.unscuadron.personajes.JefeCabron;
import static net.agsoft.unscuadron.util.Constants.ENEMY_RATE;


public class LevelManager {

	private int currentLevel;
	private SpriteManager spriteManager;

	private float enemyTime;
	private Random generator;
	
	public LevelManager(SpriteManager spriteManager) {
		
		this.spriteManager = spriteManager;
		enemyTime = 0;
		generator = new Random();
		currentLevel = 1;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public void generateRandomLevel(float dt) {
		
		Enemy enemy = null;
		
		enemyTime += dt;
		if (enemyTime > ENEMY_RATE) {
			
			if (getCurrentLevel()==1){
				int i = generator.nextInt(EnemyType.values().length);
				enemy = GeneradorEnemigosAire.createEnemy(EnemyType.values()[i], spriteManager, getCurrentLevel());
				spriteManager.getEnemies().add(enemy);
				enemyTime = 0;
				Ship ship = spriteManager.getShip();
					if (ship.getScore()>=1000){
						System.out.println("comprobado");
						setCurrentLevel(2);
					}
			}
			if (getCurrentLevel()==2){
				enemy = new JefeCabron(600, 300, -80f, BulletDirection.DOWN);
				((JefeCabron) enemy).setEnemies(spriteManager.getEnemies());
				spriteManager.getEnemies().add(enemy);
				setCurrentLevel(3);
			
			}
		
		}
		 
	
	}
}

