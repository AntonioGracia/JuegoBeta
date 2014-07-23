package net.agsoft.unscuadron;

import net.agsoft.unscuadron.controladores.ConfigurationManager;
import net.agsoft.unscuadron.pantallas.MainMenuScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class UNSquadron extends Game {

	private Skin skin;
	
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public BitmapFont font;
	
	public int score;
	public boolean paused;
	
	public ConfigurationManager configurationManager;
	
	public UNSquadron(){
		super();
	}

	@Override
	public void create() {
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		camera.update();
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.GREEN);
		font.setScale(2.0f);
		
		setScreen(new MainMenuScreen(this));
		
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	public Skin getSkin() {
        if(skin == null ) {
            skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        }
        return skin;
    }	
}
