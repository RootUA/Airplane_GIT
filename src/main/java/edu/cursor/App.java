package edu.cursor;

import edu.cursor.prototype.Airplane;


public class App {

    public static void main(String[] args) {

        Airplane first = new Airplane();
        System.out.println(first);
        while (first.getTottalDistance() < first.getMaxDistance()) {
            first.direction();
        }
    }
}