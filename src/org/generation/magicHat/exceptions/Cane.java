package org.generation.magicHat.exceptions;

public class Cane {

    //public : porcata (fini didattici)
    public Cane bestfriend;
    public boolean hasTail;

    public void scodinzola() throws NoTailException {
        if (hasTail = true) {
            System.out.println("Scodinzola");
        } else {
            throw new NoTailException("Magari potessi scodinzolare");
        }
    };
}
