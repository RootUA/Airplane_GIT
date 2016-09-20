package edu.cursor.prototype;

import edu.cursor.Box;
import edu.cursor.Engine;
import edu.cursor.Target.Target;
import edu.cursor.planeparts.Wheel;
import edu.cursor.weapons.Gun;
import edu.cursor.weapons.Rocket;

import java.util.Random;
import java.util.Scanner;

import static edu.cursor.constants.Constantable.*;
import static java.lang.Math.round;


public class Airplane implements edu.cursor.Interfaces.Invisiable, edu.cursor.Interfaces.Flyable {
    private int east = EAST;
    private int west = WEST;
    private int north = NORTH;
    private int south = SOUTH;
    final Random random = new Random();
    Target target = new Target();
    private Scanner sc = new Scanner(System.in);
    private String name = AIRPLANE_NAME + (random.nextInt(27) + 1);
    private Wheel[] wheels = new Wheel[]{
            new Wheel(random.nextInt(3) + 1, random.nextInt(2) + 1, random.nextInt(3) + 1),
            new Wheel(random.nextInt(2) + 1, random.nextInt(2) + 1, random.nextInt(2) + 1),
            new Wheel(random.nextInt(3) + 1, random.nextInt(2) + 1, random.nextInt(3) + 1),
    };
    private Box box = new Box(random.nextInt(3) + 1, random.nextInt(2) + 1, random.nextInt(3) + 1);
    private Engine engine = new Engine(random.nextInt(3) + 1, random.nextInt(2) + 1, random.nextInt(30) + 1, random.nextInt(100) + 120);
    private int rocket = new Rocket().generateRockets();
    private int guns = new Gun().generateBullets();
    private int totallLength = engine.getLength() + box.getLength();
    private int speed = engine.getPower();
    private double maxDistance = calculationDistance();

    private double calculationDistance() {
        if (guns <= MEDIUM_BULL && rocket <= MEDIUM_ROCK) {System.out.println(1); return MAX_LENGTH + (random.nextInt(50) - 49);}
        else if (guns <= MEDIUM_BULL && rocket >= MEDIUM_ROCK) {System.out.println(2); return MEDIUM_LENGTH;}
        else return MIN_LENGTH + random.nextInt(20);

    }


    private double tottalDistance = 0;
    private double flyingHeight = calculationHeight();

    private double calculationHeight() {
        if (guns <= MEDIUM_BULL && rocket <= MEDIUM_ROCK) return MAX_WIDTH + (random.nextInt(50) - 49);
        else if (guns <= MEDIUM_BULL && rocket >= MEDIUM_ROCK) return MEDIUM_WIDTH;
        else return MIN_WIDTH + random.nextInt(20);

    }

    private int totallWeight = weightWheels() + engine.getWeight() + box.getWeight();

    private int weightWheels() {
        int totallWeights = 0;
        for (int i = 0; i < wheels.length; i++) {
            totallWeights += wheels[i].getWeight();
        }
        return totallWeights;
    }

    public Airplane() {
    }

    public Airplane(int east, int west, int north, int south) {
        this.east = east;
        this.west = west;
        this.north = north;
        this.south = south;
    }

    public Integer getEast() {
        return east;
    }

    public void setEast(Integer east) {
        this.east = east;
    }

    public Integer getWest() {
        return west;
    }

    public void setWest(Integer west) {
        this.west = west;
    }

    public Integer getNorth() {
        return north;
    }

    public void setNorth(Integer north) {
        this.north = north;
    }

    public Integer getSouth() {
        return south;
    }

    public void setSouth(Integer south) {
        this.south = south;
    }

    public String getName() {
        return name;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public double getTottalDistance() {
        return tottalDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airplane airplane = (Airplane) o;

        if (getEast() != airplane.getEast()) return false;
        if (getWest() != airplane.getWest()) return false;
        if (getNorth() != airplane.getNorth()) return false;
        if (getSouth() != airplane.getSouth()) return false;
        if (Double.compare(airplane.maxDistance, maxDistance) != 0) return false;
        if (Double.compare(airplane.flyingHeight, flyingHeight) != 0) return false;
        if (totallWeight != airplane.totallWeight) return false;
        return getName().equals(airplane.getName());

    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getEast();
        result = 31 * result + getWest();
        result = 31 * result + getNorth();
        result = 31 * result + getSouth();
        result = 31 * result + getName().hashCode();
        temp = Double.doubleToLongBits(maxDistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(flyingHeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + totallWeight;
        return result;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "east=" + east +
                ", west=" + west +
                ", north=" + north +
                ", south=" + south +
                ", name='" + name + '\'' +
                ", rocket=" + rocket +
                ", guns=" + guns +
                ", maxDistance=" + maxDistance +
                ", flyingHeight=" + flyingHeight +
                '}';
    }

    public void invis() {
        double invis = round((random.nextDouble() + 1.5) * 100.0) / 100.0;
        if (random.nextDouble() < 0.55) {
            System.out.println("Turned on invisible mode for " + invis + " sec.");
        }
    }

    public void falling() {
        System.out.println("\033[31;43m SOS!!!");
        System.out.println("\033[94m Falling... coordinats: west: " + west + " east: " + east + " north: " + north + " south: " + south);
    }

    public void movingEast() {
        if (mode()) {
            System.out.println("Target " + target.getName() + " captured! Distance to target: " + target.getDistance() + " km on east " + " armor target: " + target.getArmor());
            for (int i = 0; i < target.getDistance(); i++) {
                east++;
                west--;
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " flying " + i + " km to target on east!");
                    falling();
                    break;
                } else if (i == target.getDistance() - 1) {
                    fight(target.getArmor());
                    break;
                }
            }
        } else {
            System.out.println("How many km do you want fly?");
            double distance = sc.nextDouble();
            for (int k = 0; k < distance; k++) {
                setEast(getEast()+1);
                setWest(getWest()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " Flying " + (k + 1) + " km on east " + "!");
                    falling();
                    break;
                } else if (k == distance - 1) {
                    System.out.println(name + " Flying " + distance + " km on east " + "!");
                }
            }
        }
        lending();
    }

    public void movingWest() {
        if (mode()) {
            System.out.println("Give me target...");
            Object tempBase = sc.next();
            int tempDistance = random.nextInt((300) + 1);
            int tempArmor = random.nextInt((400) + 1);
            System.out.println("Target " + tempBase + " captured! Distance to target: " + tempDistance + " km on west " + " armor target: " + tempArmor);
            for (int i = 0; i < tempDistance; i++) {
                setWest(getWest()+1);
                setEast(getEast()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " flying " + i + " km to target on west!");
                    falling();
                    break;
                } else if (i == tempDistance - 1) {
                    fight(tempArmor);
                    break;
                }
            }
        } else {
            System.out.println("How many km do you want fly?");
            double distance = sc.nextDouble();
            for (int k = 0; k < distance; k++) {
                setWest(getWest()+1);
                setEast(getEast()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " Flying " + (k + 1) + " km on west " + "!");
                    falling();
                    break;
                } else if (k == distance - 1) {
                    System.out.println(name + " Flying " + distance + " km on west " + "!");
                }
            }
        }
        lending();
    }

    public void movingSouth() {
        if (mode()) {
            System.out.println("Give me target...");
            Object tempBase = sc.next();
            int tempDistance = random.nextInt((300) + 1);
            int tempArmor = random.nextInt((400) + 1);
            System.out.println("Target " + tempBase + " captured! Distance to target: " + tempDistance + " km on south " + " armor target: " + tempArmor);
            for (int i = 0; i < tempDistance; i++) {
                setSouth(getSouth()+1);
                setNorth(getNorth()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " flying " + i + " km to target on south!");
                    falling();
                    break;
                } else if (i == tempDistance - 1) {
                    fight(tempArmor);
                    break;
                }
            }
        } else {
            System.out.println("How many km do you want fly?");
            double distance = sc.nextDouble();
            for (int k = 0; k < distance; k++) {
                setSouth(getSouth()+1);
                setNorth(getNorth()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " Flying " + (k + 1) + " km on south " + "!");
                    falling();
                    break;
                } else if (k == distance - 1) {
                    System.out.println(name + " Flying " + distance + " km on south " + "!");
                }
            }
        }
        lending();
    }

    public void movingNorth() {
        if (mode()) {
            System.out.println("Give me target...");
            Object tempBase = sc.next();
            int tempDistance = random.nextInt((300) + 1);
            int tempArmor = random.nextInt((400) + 1);
            System.out.println("Target " + tempBase + " captured! Distance to target: " + tempDistance + " km on north " + " armor target: " + tempArmor);
            for (int i = 0; i < tempDistance; i++) {
                setNorth(getNorth()+1);
                setSouth(getSouth()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " flying " + i + " km to target on north!");
                    falling();
                    break;
                } else if (i == tempDistance - 1) {
                    fight(tempArmor);
                    break;
                }
            }
        } else {
            System.out.println("How many km do you want fly?");
            double distance = sc.nextDouble();
            for (int k = 0; k < distance; k++) {
                setNorth(getNorth()+1);
                setSouth(getSouth()-1);
                tottalDistance++;
                if (tottalDistance == maxDistance) {
                    System.out.println(name + " Flying " + (k + 1) + " km on north " + "!");
                    falling();
                    break;
                } else if (k == distance - 1) {
                    System.out.println(name + " Flying " + distance + " km on north " + "!");
                }
            }
        }
        lending();
    }

    public boolean mode() {
        System.out.println("Do you want search target? Press 'y'");
        char question = sc.next().charAt(0);
        if (question == YES_ANSWER) return true;
        return false;
    }

    public void lending() {
        System.out.println("Do you want lend? Press 'y'");
        char dir = sc.next().charAt(0);
        if (dir == YES_ANSWER) {
            System.out.println(name + " Successfully lended - coordinats: west: " + west + " east: " + east + " north: " + north + " south: " + south);
            System.exit(0);
        }


    }

    public void direction() {
        System.out.println("Tell me direction boss...");
        char dir = sc.next().charAt(0);
        switch (dir) {
            case 'e':
                movingEast();
                break;
            case 's':
                movingSouth();
                break;
            case 'w':
                movingWest();
                break;
            case 'n':
                movingNorth();
                break;
            default:
                System.out.println("Unknown direction!");
                direction();
        }
    }

    public void fight(int armor) {
        invis();
        for (int j = 0; armor != 0; j++) {
            if (rocket > 0) {
               rocket--;
                guns--;
                armor -= MAX_PUNCHING_ARMOR;
            } else {
                guns--;
                armor -=  random.nextInt((int)MEDIUM_PUNCHING_ARMOR - (int)MIN_PUNCHING_ARMOR) + (int)MIN_PUNCHING_ARMOR;
            }
            if (armor <= 0) {
                System.out.println("Win!!! Rockets left: " + rocket + " Guns left: " + guns + " Fuel on: " + (maxDistance - tottalDistance) + " km.");
                break;
            } else if (guns == 0) {
                System.out.println("Not enought weapon! Fuel on:: " + (maxDistance - tottalDistance) + " km.");
                break;
            }
        }

    }
}
