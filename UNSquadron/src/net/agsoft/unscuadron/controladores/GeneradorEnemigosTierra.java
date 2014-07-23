package net.agsoft.unscuadron.controladores;


import java.util.Random;

import net.agsoft.unscuadron.personajes.BadShip;
import net.agsoft.unscuadron.personajes.Enemy;
import net.agsoft.unscuadron.personajes.Enemy.EnemyType;
import net.agsoft.unscuadron.personajes.SmallEnemy;
import net.agsoft.unscuadron.util.Constants;


public class GeneradorEnemigosTierra {

public static Enemy createEnemy(EnemyType type, SpriteManager spriteManager, int i) {
		
		Enemy enemy = null;
		
		switch (type) {
		
			case BadShip:
				enemy = new BadShip(Constants.SCREEN_WIDTH, new Random().nextInt(Constants.SCREEN_HEIGHT - Constants.ENEMY_HEIGHT), -80f);
				break;
			
			case SmallEnemy:
				enemy = new SmallEnemy(Constants.SCREEN_WIDTH, new Random().nextInt(Constants.SCREEN_HEIGHT - Constants.ENEMY_HEIGHT), -80f);
			
				break;
				
			default:
				break;
		}
		
		return enemy;
	}

}
