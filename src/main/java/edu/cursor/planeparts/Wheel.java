package edu.cursor.planeparts;

public class Wheel {
	private int width;
	private int length;
	private int weight;

	public Wheel(int width, int length, int weight) {
		super();
		this.width = width;
		this.length = length;
		this.weight = weight;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
