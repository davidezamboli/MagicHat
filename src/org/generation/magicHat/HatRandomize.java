package org.generation.magicHat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HatRandomize {

    private ArrayList<String> students = new ArrayList<>(
            List.of(
                    "Davide Verrengia Caporossi",
                    "Antonio Centomani",
                    "Francesco Grasso",
                    "Davide Schiena",
                    "Viviana Rotondo",
                    "Jonathan Ortu",
                    "Cedric Mokoko",
                    "karim ayed",
                    "Bianca Napodano",
                    "Luca Piano",
                    "Patrick Moncada",
                    "Alessio Picatti",
                    "Davide Zamboli",
                    "Linus Karl",
                    "Gaetano Cusimano",
                    "Simone Cazzaniga",
                    "Tommaso Liberati",
                    "Flavio Picca",
                    "Angelo Luciano",
                    "Daniele Folgore",
                    "Raffaele Porcaro",
                    "Giuseppe Perrella",
                    "Henriques Alvarenga",
                    "Massimiliano Onorio",
                    "Riccardo Casale",
                    "Mariano Mariano"

            )
    );
    private ArrayList<String> ravenclaw = new ArrayList<>();
    private ArrayList<String> gryffindor = new ArrayList<>();
    private ArrayList<String> hufflepuff = new ArrayList<>();
    private ArrayList<String> slytherin = new ArrayList<>();

    private ArrayList<ArrayList<String>> houses = new ArrayList<>();
    private Random fate = new Random();

    public HatRandomize() {
        houses.add(ravenclaw);
        houses.add(gryffindor);
        houses.add(hufflepuff);
        houses.add(slytherin);
    }

    public void assignStudentsToHouses() {
        //ciclare su tutti gli studenti a disposizione
        //assegnare una delle 4 case con uguale probabilità
        //il programma scriverà il nome dello studente si
        // interromperà per 5 secondi e poi stamperà la
        // scritta"nome studente" e poi spazio nome della casa
        //oltre a stamparlo lo andra a mettere nell'arraylist
        //alla fine del programma il programma stamperà su 4
        // colonne i vari nomi dei partecipanti alle proprie case
        int limit = students.size() / 4;
        for (String s : students) {
            boolean added = false;
            System.out.printf("%s verrà assegnato a...", s);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            do {
                int i = fate.nextInt(4) + 1;
                switch (i) {
                    case 1:
                        if (gryffindor.size() < limit) {
                            gryffindor.add(s);
                            added = true;
                            System.out.println("GRYFFINDOR");
                        }
                        break;
                    case 2:
                        if (ravenclaw.size() < limit) {
                            ravenclaw.add(s);
                            added = true;
                            System.out.println("RAVENCLAW");
                        }
                        break;
                    case 3:
                        if (hufflepuff.size() < limit) {
                            hufflepuff.add(s);
                            added = true;
                            System.out.println("HUFFLEPUFF");
                        }
                        break;
                    case 4:
                        if (slytherin.size() < limit) {
                            slytherin.add(s);
                            added = true;
                            System.out.println("SLYTHERIN");
                        }
                        break;
                }
            } while (!added);
            if (gryffindor.size() == limit && ravenclaw.size() == limit && hufflepuff.size() == limit && slytherin.size() == limit) {
                break;
            }
        }
        for (int i = limit * 4; i < students.size(); i++) {
            boolean added = false;
            String s = students.get(i);
            do {
                int k = fate.nextInt(4) + 1;
                switch (k) {
                    case 1:
                        if (gryffindor.size() < limit + 1) {
                            gryffindor.add(s);
                            added = true;
                            System.out.println("GRYFFINDOR");
                        }
                        break;
                    case 2:
                        if (ravenclaw.size() < limit + 1) {
                            ravenclaw.add(s);
                            added = true;
                            System.out.println("RAVENCLAW");
                        }
                        break;
                    case 3:
                        if (hufflepuff.size() < limit + 1) {
                            hufflepuff.add(s);
                            added = true;
                            System.out.println("HUFFLEPUFF");
                        }
                        break;
                    case 4:
                        if (slytherin.size() < limit + 1) {
                            slytherin.add(s);
                            added = true;
                            System.out.println("SLYTHERIN");
                        }
                        break;
                }
            } while (!added);
        }

        System.out.printf("Gryffindor: %s%n", gryffindor.size());
        System.out.printf("Slytherin: %s%n", slytherin.size());
        System.out.printf("Hufflepuff: %s%n", hufflepuff.size());
        System.out.printf("Ravenclaw: %s%n", ravenclaw.size());

        System.out.printf("%30s%30s%30s%30s%n", "RAVENCLAW", "GRYFFINDOR", "HUFFLEPUFF", "SLYTHERIN");

        int size = students.size() % 4 == 0 ? limit : limit + 1;

        for (int i = 0; i < size; i++) {
            System.out.printf("%30s%30s%30s%30s%n", getNextStudent(i, ravenclaw), getNextStudent(i, gryffindor),
                    getNextStudent(i, hufflepuff), getNextStudent(i, slytherin));
        }
    }

    private String getNextStudent(int pos, List<String> students) {
        if (pos < students.size()) {
            return students.get(pos);
        } else {
            return "";//ritorni un optional di stringhe
        }
    }
}