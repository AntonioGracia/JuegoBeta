package net.agsoft.unscuadron.pantallas;

import net.agsoft.unscuadron.UNSquadron;
import net.agsoft.unscuadron.controladores.LevelManager;
import net.agsoft.unscuadron.controladores.ResourceManager;
import net.agsoft.unscuadron.controladores.SpriteManager;
import net.agsoft.unscuadron.personajes.Ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen implements Screen {

	UNSquadron unSquadron;
	
	private SpriteManager spriteManager;
	private LevelManager levelManager;
	
	private ShapeRenderer shapeRenderer;
	
	public enum GameType {
		QUICK, HISTORY;
	}
	public GameType gameType;
	
	public GameScreen(UNSquadron unSquadron, GameType gameType) {
		this.unSquadron = unSquadron;
		this.gameType = gameType;
		
		loadScreen();
	}
	
	private void loadScreen() {
		
		ResourceManager.loadAllResources();		
		
		spriteManager = new SpriteManager(unSquadron);
		levelManager = new LevelManager(spriteManager);
		
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void show() {
		
		unSquadron.paused = false;
	}

	@Override
	public void render(float dt) {
		
		Gdx.gl.glClearColor(0, 1, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
		unSquadron.camera.update();
		
		update(dt);
		
		unSquadron.batch.begin();
			// Pinta en pantalla todos los elementos del juego
			spriteManager.draw(unSquadron.batch);	
			drawOnscreenText();
			unSquadron.batch.end();
	}
	
	private void drawOnscreenText() {
		
		Ship ship = spriteManager.getShip();
	
		
		unSquadron.font.draw(unSquadron.batch, "" + ship.getScore(), 500, 520);
		if (levelManager.getCurrentLevel()==1){
			unSquadron.font.draw(unSquadron.batch, "" + (levelManager.getCurrentLevel()), 550, 560);
		}
		
		if (levelManager.getCurrentLevel()==3){
			unSquadron.font.draw(unSquadron.batch, "" + (levelManager.getCurrentLevel()-1), 550, 560);
		}
		
		
	//	unSquadron.font.draw(unSquadron.batch, "NIVEL: " + levelManager.getCurrentLevel(), 130, 20);

		checkVidas(ship);
		
		
	}
	
	private void checkVidas(Ship ship){
		
		if (ship.getLives()==8){
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta"), 171, 19);
		}
		
		else if (ship.getLives()==7) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta2"), 171, 19);
		}
		
		else if (ship.getLives()==6) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta3"), 171, 19);
		}
		
		else if (ship.getLives()==5) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta4"), 171, 19);
		}
		else if (ship.getLives()==4) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta5"), 171, 19);
		}
		else if (ship.getLives()==3) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta6"), 171, 19);
		}
		else if (ship.getLives()==2) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta7"), 171, 19);
		}
		else if (ship.getLives()==1) {
			unSquadron.batch.draw(ResourceManager.getTexture("vidacompleta8"), 171, 19);
		}
	}
	
	private void update(float dt) {
		
		switch (gameType) {
		case QUICK:
			levelManager.generateRandomLevel(dt);
			break;
		case HISTORY:
			break;
		default:
		}
		
		if (!unSquadron.paused) {
			spriteManager.update(dt);
			spriteManager.getShip().update(dt, spriteManager);
		}
		
		handleKeyboard();
	}

	private void handleKeyboard() {
		
		
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			unSquadron.setScreen(new InGameMenuScreen(unSquadron, this));
		}
	}
	
	@Override
	public void dispose() {
		shapeRenderer.dispose();
	}

	/**
	 * Cuando esta pantalla se oculta, se pausa
	 */
	@Override
	public void hide() {
		
		unSquadron.paused = true;
	}

	@Override
	public void pause() {
		
		unSquadron.paused = true;
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
		unSquadron.paused = false;
	}
}
