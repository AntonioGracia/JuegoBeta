package net.agsoft.unscuadron.controladores;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourceManager {

	private static Map<String, Texture> textures = new HashMap<String, Texture>();
	private static Map<String, Animation> animations = new HashMap<String, Animation>();
	private static Map<String, Sound> sounds = new HashMap<String, Sound>();
	
	public static void loadAllResources() {
		
		Texture.setEnforcePotImages(false);
	
		ResourceManager.loadResource("fondo", new Texture("fondos/mapa.bmp"));
		ResourceManager.loadResource("fondo2", new Texture("fondos/mapa1366.bmp"));
		ResourceManager.loadResource("vidacompleta", new Texture("vidas/vidacompleta.bmp"));
		ResourceManager.loadResource("vidacompleta2", new Texture("vidas/vidacompleta2.bmp"));
		ResourceManager.loadResource("vidacompleta3", new Texture("vidas/vidacompleta3.bmp"));
		ResourceManager.loadResource("vidacompleta4", new Texture("vidas/vidacompleta4.bmp"));
		ResourceManager.loadResource("vidacompleta5", new Texture("vidas/vidacompleta5.bmp"));
		ResourceManager.loadResource("vidacompleta6", new Texture("vidas/vidacompleta6.bmp"));
		ResourceManager.loadResource("vidacompleta7", new Texture("vidas/vidacompleta7.bmp"));
		ResourceManager.loadResource("vidacompleta8", new Texture("vidas/vidacompleta8.bmp"));
		ResourceManager.loadResource("armaPrincipal", new Texture("armas/misil.png"));
		ResourceManager.loadResource("fogonazo", new Texture("armas/fogonazo.png"));
		ResourceManager.loadResource("tiro2", new Texture("armas/tiro2.png"));

		
		ResourceManager.loadResource("ship", new Animation(1f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("aviones/ship1.png"))), new Sprite(new Texture(Gdx.files.internal("aviones/ship2.png")))}));
		
		ResourceManager.loadResource("avionmalo", new Animation(1f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("aviones/avionmalo1.png"))),
				new Sprite(new Texture(Gdx.files.internal("aviones/avionmalo2.png"))),
				new Sprite(new Texture(Gdx.files.internal("aviones/avionmalo3.png"))),
				}));

		ResourceManager.loadResource("rojo", new Animation(1f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("aviones/rojo1.png"))), 
				new Sprite(new Texture(Gdx.files.internal("aviones/rojo3.png"))),
				new Sprite(new Texture(Gdx.files.internal("aviones/rojo4.png")))}));
		
		ResourceManager.loadResource("avionGrande", new Animation(1f, new TextureRegion[]{
				new Sprite(new Texture(Gdx.files.internal("avionesenemigos/enemigogrande.png"))), new Sprite(new Texture(Gdx.files.internal("avionesenemigos/enemigogrande.png")))}));
		
	//	ResourceManager.loadResource("tiro1", new Animation(1f, new TextureRegion[]{
				//new Sprite(new Texture(Gdx.files.internal("armas/tiro1.png"))), new Sprite(new Texture(Gdx.files.internal("armas/tiro2.png")))}));
	
		ResourceManager.loadResource("intro", Gdx.audio.newSound(Gdx.files.internal("sonidos/unsquadron.wav")));
		ResourceManager.loadResource("destruccion" , Gdx.audio.newSound(Gdx.files.internal("sonidos/perdiste.mp3")));
	
	}
	

	public static Animation createAnimationFromSpriteSheet(String spriteSheetName, int frameCount) {
		
		Texture spriteSheet = new Texture(Gdx.files.internal(spriteSheetName));
		TextureRegion[][] sheetFrames = TextureRegion.split(spriteSheet, spriteSheet.getWidth(), spriteSheet.getHeight() / frameCount);
		TextureRegion[] frames = new TextureRegion[frameCount];
		for (int i = 0; i < frameCount; i++) {
			frames[i] = sheetFrames[i][0];
		}
		
		return new Animation(0.15f, frames);
	}
	
	public static void loadResource(String name, Texture resource) {
		
		textures.put(name, resource);
	}
	

	public static void loadResource(String name, Animation resource) {
		
		animations.put(name, resource);
	}
	

	public static void loadResource(String name, Sound sound) {
		
		sounds.put(name, sound);
	}
	

	public static Texture getTexture(String name) {
		
		return textures.get(name);
	}
	
	public static Animation getAnimation(String name) {
		
		return animations.get(name);
	}
 

	public static Sound getSound(String name) {
		
		return sounds.get(name);
	}
}
