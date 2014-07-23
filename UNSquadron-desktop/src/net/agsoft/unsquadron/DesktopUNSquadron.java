package net.agsoft.unsquadron;

import net.agsoft.unscuadron.UNSquadron;
import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class DesktopUNSquadron {

	public static void main(String[] args) {
	 LwjglApplicationConfiguration configuracion = new LwjglApplicationConfiguration();
	 configuracion.title = "U.N. Squadron clon";
	 configuracion.width = Constants.SCREEN_WIDTH;
	 configuracion.height = Constants.SCREEN_HEIGHT;
	 
	 configuracion.fullscreen = true;
	 
	 new LwjglApplication(new UNSquadron(), configuracion);
		
		
	}
}
