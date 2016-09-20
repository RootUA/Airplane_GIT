package edu.cursor;


public class Engine {
    private int width;
    private int length;
    private int weight;
    private int power;

    public Engine() {
    }


    public Engine(int width, int length, int weight, int power) {
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.power = power;
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

    public int getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (getWidth() != engine.getWidth()) return false;
        if (getLength() != engine.getLength()) return false;
        if (getWeight() != engine.getWeight()) return false;
        return getPower() == engine.getPower();

    }

    @Override
    public int hashCode() {
        int result = getWidth();
        result = 31 * result + getLength();
        result = 31 * result + getWeight();
        result = 31 * result + getPower();
        return result;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                ", power=" + power +
                '}';
    }
}



