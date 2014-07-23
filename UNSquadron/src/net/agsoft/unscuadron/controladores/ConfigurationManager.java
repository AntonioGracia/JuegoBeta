package net.agsoft.unscuadron.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.agsoft.unscuadron.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ConfigurationManager {

	private Preferences prefs;
	
	public ConfigurationManager() {
		prefs = Gdx.app.getPreferences(Constants.APP);
	}
	
	public boolean isSoundEnabled() {
		
		return prefs.getBoolean("sound");
	}
	
	
	public static void addScores(String name, int score) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:" + Gdx.files.internal("scores.db"));
		
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS scores (id integer primary key autoincrement, name text, score int)");
			statement.executeUpdate("INSERT INTO scores (name, score) VALUES ('" + name + "', " + score + ")");
			
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static List<Score> getTopScores() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlite:" + Gdx.files.internal("scores.db"));
		
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT name, score FROM scores ORDER BY score DESC LIMIT 10");
			List<Score> scores = new ArrayList<Score>();
			Score score = null;
			while (res.next()) {
				score = new Score();
				score.name = res.getString("name");
				score.score = res.getInt("score");
				scores.add(score);
			}
			
			if (statement != null)
				statement.close();
			if (res != null)
				res.close();
			if (connection != null)
				connection.close();
			
			return scores;
		
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return new ArrayList<Score>();
	}
	
	public static class Score {
		public String name;
		public int score;
	}
}
