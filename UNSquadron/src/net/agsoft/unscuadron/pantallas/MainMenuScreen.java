package net.agsoft.unscuadron.pantallas;

import net.agsoft.unscuadron.UNSquadron;
import net.agsoft.unscuadron.pantallas.GameScreen.GameType;
import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuScreen implements Screen {

	UNSquadron unSquadron;
	Stage stage;
	
	public MainMenuScreen(UNSquadron unSquadron) {
		this.unSquadron = unSquadron;
	}
	
	private void loadScreen() {
				
		stage = new Stage();
					
		Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);
	    table.setFillParent(true);
	    table.setHeight(500);
	    stage.addActor(table);
		
		Label label = new Label("Welcome to U.N. Squadron", unSquadron.getSkin());
		table.addActor(label);
		
		TextButton buttonPlay = new TextButton("Partida Rapida", unSquadron.getSkin());
		buttonPlay.setPosition(label.getOriginX(), label.getOriginY() - 120);
		buttonPlay.setWidth(200);
		buttonPlay.setHeight(40);
		buttonPlay.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
			unSquadron.setScreen(new GameScreen(unSquadron, GameType.QUICK));
			}
		});
		table.addActor(buttonPlay);
		
		TextButton botonInstruccion = new TextButton("INSTRUCCIONES", unSquadron.getSkin());
		botonInstruccion.setPosition(label.getOriginX(), label.getOriginY() - 170);
		botonInstruccion.setWidth(200);
		botonInstruccion.setHeight(40);
		botonInstruccion.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
				unSquadron.setScreen(new GameRules(unSquadron));
			}
		});
		table.addActor(botonInstruccion);
		

		
		TextButton buttonQuit = new TextButton("Salir", unSquadron.getSkin());
		buttonQuit.setPosition(label.getOriginX(), label.getOriginY() - 220);
		buttonQuit.setWidth(200);
		buttonQuit.setHeight(40);
		buttonQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				unSquadron.dispose();
				System.exit(0);
			}
		});
		table.addActor(buttonQuit);
		
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void show() {

		loadScreen();
	}
	
	@Override
	public void render(float dt) {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
		// Pinta el menú
		stage.act(dt);
		stage.draw();
	}
	
	@Override
	public void dispose() {

		stage.dispose();
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void pause() {

		
	}

	

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
