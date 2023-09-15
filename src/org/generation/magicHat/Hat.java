package org.generation.magicHat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Hat {
    private List<String> students = List.of(
            "Davide Varrengia Caporossi",
            "Antonio Centomani",
            "Francesco Grasso",
            "Davide Schiena",
            "Viviana Rotondo",
            "Jonathan Ortu",
            "Cedric Mokoto",
            "Gaetano Cusimano",
            "Karim Ayed",
            "Henriques Alvaregna",
            "Alessio Picatti",
            "Flavio Picca",
            "Asoolo",
            "Pippo",
            "Pluto",
            "Paperino",
            "Paperina",
            "Ugo",
            "Foscolo",
            "Troia"
    );
    private List<String> hufflepuff = new ArrayList<>();
    private List<String> slytherin = new ArrayList<>();
    private List<String> ravenclaw = new ArrayList<>();
    private List<String> gryffindor = new ArrayList<>();

    private List<List<String>> houses = new ArrayList<>();
    private Random fate = new Random();

    public Hat() {
        houses.add(gryffindor);
        houses.add(slytherin);
        houses.add(ravenclaw);
        houses.add(hufflepuff);
    }

    public void assignStudentsToHouses() {
        int limit = students.size() / 4;
        for (String student : students) {
            assignStudentToHouse(student);
        }
        displayHouseAssignments(limit);
    }

    private void assignStudentToHouse(String student) {
        int houseIndex = fate.nextInt(4);
        List<String> house = houses.get(houseIndex);
        house.add(student);
        System.out.println(student + " viene assegnato a: " + getHouseName(houseIndex));
    }

    private void displayHouseAssignments(int limit) {
        System.out.printf("%n%30s%30s%30s%30s%n", "Gryffindor", "Slytherin", "Ravenclaw", "Hufflepuff");
        for (int i = 0; i < limit + 1; i++) {
            System.out.printf("%30s%30s%30s%30s%n", getNextStudent(i, gryffindor).orElse(""),
                    getNextStudent(i, slytherin).orElse(""),
                    getNextStudent(i, ravenclaw).orElse(""),
                    getNextStudent(i, hufflepuff).orElse(""));
        }
    }

    private Optional<String> getNextStudent(int pos, List<String> house) {
        if (pos < house.size()) {
            return Optional.of(house.get(pos));
        } else {
            return Optional.empty();
        }
    }

    private String getHouseName(int index) {
        switch (index) {
            case 0:
                return "Gryffindor";
            case 1:
                return "Slytherin";
            case 2:
                return "Ravenclaw";
            case 3:
                return "Hufflepuff";
            default:
                return "";
        }
    }
}
