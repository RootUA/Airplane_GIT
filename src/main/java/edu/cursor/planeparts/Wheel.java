package edu.cursor.planeparts;

public class Wheel {
	private String brend;
	private int width;
	private int length;
	private int weight;

	public Wheel(String brend, int width, int length, int weight) {
		super();
		this.brend = brend;
		this.width = width;
		this.length = length;
		this.weight = weight;
	}

	public String getBrend() {
		return brend;
	}

	public void setBrend(String brend) {
		this.brend = brend;
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
