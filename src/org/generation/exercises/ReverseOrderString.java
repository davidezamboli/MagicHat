package org.generation.exercises;

import java.util.*;

public class ReverseOrderString {

    public LinkedList<String> reverseOrderWords(String source) {
        // dividere la stringa in parole
        String[] wordsArray = source.split("\\s");

        LinkedList<String> wordsList = new LinkedList<>(Arrays.asList(wordsArray));

        // sortare la lista ordine alfabetico inverso
        Collections.sort(wordsList, Collections.reverseOrder());

        ArrayList<String> sortedWords = new ArrayList<>(wordsList);

        return wordsList;
    }

    public List<String> reverseOrderWordsList(String source) {
        String[] wordsArray = source.split("\\s");

        List<String> wordsList = new LinkedList<>(Arrays.asList(wordsArray));

        wordsList.sort(Collections.reverseOrder());

        return wordsList;
    }

    public static void main(String[] args) {

        ReverseOrderString r = new ReverseOrderString();
        String input = "pippo bippo vippo cippo appio";

        LinkedList<String> sortedWords = r.reverseOrderWords(input);

        for (String word : sortedWords) {
            System.out.print(word + " ");
        }

        ReverseOrderString s = new ReverseOrderString();
        String newInput = "frase di esempio";
        List<String> newSortedWords = s.reverseOrderWords(newInput);

        System.out.println("Parole ordinate in ordine alfabetico inverso:");
        for (String word : newSortedWords) {
            System.out.println(word);
        }
    }

}
