package edu.cursor.weapons;

import edu.cursor.constants.Constantable;

import java.util.Random;

public class Gun implements Constantable{
	private int countBull;
	Random rand = new Random();
    
	
     
     public int generateBullets() {
		countBull = rand.nextInt(MAX_BULL - MIN_BULL) + MIN_BULL;
		return countBull;
	}

	public void setCountBull(int countBull) {
		this.countBull = countBull;
	}

	public int getBulletCount()  {
		return countBull;
	}

}
