package org.generation.exercises;


import java.util.*;

/*
Creare un metodo
public static void printStrings(ArrayList<String> words)
che riceve in input un ArrayList di stringhe e le stampe a console in
ordine inverso.

 */
public class StringPrint {

    public static void printStrings(List<String> words) {
        //reverse sort
        //Collections.reverse(words);

        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.print(words.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        LinkedList<String> words = new LinkedList<>();
        words.add("Pippo");
        words.add("Pluto");
        words.add("Paperino");

        System.out.println("Ordine originale");
        for (String word : words) {
            System.out.print(word + " ");
        }

        System.out.println();

        printStrings(words);
        /*for (String word : words) {
            System.out.print(word + " ");
        }*/

    }

}
