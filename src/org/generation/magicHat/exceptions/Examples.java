package org.generation.magicHat.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Examples {

    public static void main(String[] args) {
        //f1();
        Cane c = new Cane();
        try {
            c.scodinzola();
        } catch (NoTailException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Termina main");
    }

    public static void f1()  {
        System.out.println("f1");
        try {
            f2();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException risolto *occhiolino");
        } catch (SQLException e) {
            System.out.println("SQLException risolto *occhiolino");
        } catch (IOException e) {
            System.out.println("IOException risolto *occhiolino");
        } finally {
            System.out.println("Chiudere le risorse");
        }
        System.out.println("Termina f1");
    }

    public static void f2() throws IOException, SQLException {
        System.out.println("f2");
        f3();
        System.out.println("Termina f2");
    }
    public static void f3() throws IOException, SQLException {
        System.out.println("f3");

        //Cane c = new Cane();
        //System.out.println(c); //same di fare c.toString() -> stampa l'indirizzo in esadecimale; con l'override -> nomeCane
        //Cane c2 = new Cane();
        //c.bestfriend = c2;

        if (Math.random() > 0.5) {
            throw new NullPointerException();
        }

        if (Math.random() > 0.5) {
            FileNotFoundException f = new FileNotFoundException("File pippo.txt non trovato");
            throw f;
        }

        if (Math.random() > 0.5) {
            IOException i = new IOException();
            throw i;
        }

        if (Math.random() > 0.3) {
            SQLException s = new SQLException();
            throw s;
        }

        System.out.println("Termina f3");
    }

}
