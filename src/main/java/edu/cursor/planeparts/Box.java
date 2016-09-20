package edu.cursor;


public class Box {
    private int width;
    private int length;
    private int weight;

    public Box() {
    }

    public Box(int width, int length, int weight) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (getWidth() != box.getWidth()) return false;
        if (getLength() != box.getLength()) return false;
        return getWeight() == box.getWeight();

    }

    @Override
    public int hashCode() {
        int result = getWidth();
        result = 31 * result + getLength();
        result = 31 * result + getWeight();
        return result;
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }
}
