package edu.cursor.weapons;

import edu.cursor.constants.Constantable;

import java.util.Random;

public class Rocket implements Constantable{
	private int countRocket;
	Random rand = new Random();

	public int getRocketCount() {
		return countRocket;
	}

	public void setCountRocket(int countRocket) {
		this.countRocket = countRocket;
	}

	public int generateRockets() {
		countRocket = rand.nextInt(MAX_ROCK - MIN_ROCK) + MIN_ROCK;
		return countRocket;
	}
}


