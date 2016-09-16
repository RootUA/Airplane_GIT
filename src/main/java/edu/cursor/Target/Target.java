package edu.cursor.Target;

import java.util.Random;

public class Target {
	NameGenerator nameGenerator = new NameGenerator();
	private Random random = new Random();
	private int distance = random.nextInt(200);
	private int armor = random.nextInt(200);
	private String name = nameGenerator.generateName();

	/**
	 * @param distance
	 * @param armor
	 * @param name
	 */
	public Target(int distance, int armor, String name) {
		super();
		this.distance = distance;
		this.armor = armor;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + armor;
		result = prime * result + distance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Target other = (Target) obj;
		if (armor != other.armor)
			return false;
		if (distance != other.distance)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Target [distance=" + distance + ", armor=" + armor + ", name=" + name + "]";
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getArmor() {
		return armor;
	}

	/**
	 * 
	 */
	public Target() {
		super();
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
