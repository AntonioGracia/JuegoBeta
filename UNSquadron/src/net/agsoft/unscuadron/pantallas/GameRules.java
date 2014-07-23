package net.agsoft.unscuadron.pantallas;

import net.agsoft.unscuadron.UNSquadron;
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

public class GameRules implements Screen {

	UNSquadron game;
	Stage stage;
	
	public GameRules(UNSquadron game) {
		this.game = game;
	}
	
	private void loadScreen() {
				
		stage = new Stage();
					
		Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);
	    table.setFillParent(true);
	    table.setHeight(500);
	    stage.addActor(table);
		
		Label label = new Label("INSTRUCCIONES", game.getSkin());
		table.addActor(label);
		
		TextButton buttonPlay = new TextButton("VAS A MORIR Y LO SABES", game.getSkin());
		buttonPlay.setPosition(label.getOriginX(), label.getOriginY() - 40);
		buttonPlay.setWidth(300);
		buttonPlay.setHeight(40);
		table.addActor(buttonPlay);
		
		TextButton botonInstruccion = new TextButton("Los amarillos dan 10 puntos", game.getSkin());
		botonInstruccion.setPosition(label.getOriginX(), label.getOriginY() - 90);
		botonInstruccion.setWidth(300);
		botonInstruccion.setHeight(40);
		table.addActor(botonInstruccion);
		
		TextButton bt2 = new TextButton("Los rojos dan 100 puntos", game.getSkin());
		bt2.setPosition(label.getOriginX(), label.getOriginY() - 140);
		bt2.setWidth(300);
		bt2.setHeight(40);
		table.addActor(bt2);
		
		TextButton bt3 = new TextButton("Los misiles se usan con el espacio", game.getSkin());
		bt3.setPosition(label.getOriginX(), label.getOriginY() - 190);
		bt3.setWidth(300);
		bt3.setHeight(40);
		table.addActor(bt3);
		
		
		TextButton bt4 = new TextButton("Arma especial con el 1", game.getSkin());
		bt4.setPosition(label.getOriginX(), label.getOriginY() - 240);
		bt4.setWidth(300);
		bt4.setHeight(40);
		table.addActor(bt4);
		
		TextButton bt5 = new TextButton("A LOS 1000 PUNTOS HAY UN JEFE", game.getSkin());
		bt5.setPosition(label.getOriginX(), label.getOriginY() - 290);
		bt5.setWidth(300);
		bt5.setHeight(40);
		table.addActor(bt5);
		
		TextButton buttonQuit = new TextButton("VOLVER", game.getSkin());
		buttonQuit.setPosition(label.getOriginX(), label.getOriginY() - 340);
		buttonQuit.setWidth(300);
		buttonQuit.setHeight(40);
		buttonQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				game.setScreen(new MainMenuScreen(game));
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
