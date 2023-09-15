package org.generation.exercises.bankaccount;

/*
Creare una classe CaymanAccount che estende Account, che avra'
una variabile di tipo stringa chiamato codice segreto.
un construttore che riceve un amount e una stringa a li setta come saldo iniziale e codice del conto
overrida deposit(amount) in modo che il saldo venga incrementato di amount ricevendo
pero' anche un bonus del 10% ma solo se il saldo totale dopo il deposito supera 10000.
 */

public class CaymanAccount extends Account {

    private String secretCode;

    public CaymanAccount(double amount, String code) {
        super(amount);
        this.secretCode = code;
    }

    @Override
    public void deposit(double amount) {
        if (this.getBalance() + amount > 10000) {
            amount += amount * 0.1;
        }
        this.setBalance(this.getBalance() + amount);
    }

    public static void main(String[] args) {
        CaymanAccount caymanAccount = new CaymanAccount(9000, "pippo");
        caymanAccount.deposit(2000);
        System.out.println(caymanAccount.getBalance());
    }
}
