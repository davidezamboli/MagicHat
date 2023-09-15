package org.generation.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dog implements Comparable <Dog>{
    private String name;
    private double tailLength;
    //public int x;
    public Dog(String n, double t) {
        name = n;
        tailLength = t;
    }

    public Dog(String z){
        this(z,5);
    }

    public String getName() {
        return name;
    }

    public double getTailLength() {
        return tailLength;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Lunghezza coda: %.2f", name, tailLength);

    }

    @Override
    public int compareTo(Dog o) {
        return (int)Math.signum(this.tailLength - o.tailLength);
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<Dog>();

        Dog d1 = new Dog("Mimmo", 10);
        Dog d2 = new Dog("Giulio", 3);
        Dog d3 = new Dog("Fido", 7);
        //d1.x = 3;
        //double t1 = d1.getTailLength();

        dogs.add(d1);
        dogs.add(d2);
        dogs.add(d3);

        for (Dog d : dogs){
            System.out.println(d);
        }

        Collections.sort(dogs);
        System.out.println("Sort sulla coda");

        for (Dog d : dogs){
            System.out.println(d);
        }

        System.out.println(d2.compareTo(d1));

    }
}