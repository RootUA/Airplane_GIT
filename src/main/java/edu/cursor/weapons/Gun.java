package edu.cursor.weapons;

import java.util.Random;

import edu.cursor.constants.Constantable;

public class Gun implements Constantable{
	private int countBull;
	Random rand = new Random();
    
	
     
     public int generateBullets() {
		countBull = rand.nextInt(MAX_BULL - MIN_BULL) + MIN_BULL;
		return countBull;
	}
	
	public int getBulletCount()  {
		return countBull;
	}

}
