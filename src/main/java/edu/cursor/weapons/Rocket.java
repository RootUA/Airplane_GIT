package edu.cursor.weapons;

import java.util.Random;
import edu.cursor.constants.Constantable;

public class Rocket implements Constantable{
	private int countRocket;
	Random rand = new Random();

	public int getRocketCount() {
		return countRocket;
	}

	public int generateRockets() {
		countRocket = rand.nextInt(MAX_ROCK - MIN_ROCK) + MIN_ROCK;
		return countRocket;
	}
}


