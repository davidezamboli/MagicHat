package org.generation.exercises.bankaccount;

/*
Creare una classe astratta Account che abbia:
una variabile privata balance di tipo double
un metodo getBalance
un construttore che riceve un amount a lo setta come saldo iniziale del conto
un metodo withdraw(double amount) che permette di ritirare un dato ammontare dal saldo
un metodo astratto deposit(double amount);
Aggiungete anche un metodo concreto transfer che trasferisca un amount da un conto ad un altro
Fate attenzione a come create sia la firma sia la implementazione del metodo.
 */

public abstract class Account {
    private double balance;

    public Account(double amount) {
        this.balance = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Hai prelevato %s. Saldo rimanente %s%n", amount, balance);
        } else {
            System.out.println("Prelievo fallito");
        }
    }

    public abstract void deposit(double amount);

    public void transfer(double amount, Account depositAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            depositAccount.deposit(amount);
            System.out.printf("Trasferiti %s al conto%n", amount);
        } else {
            System.out.println("Trasferimento fallito");
        }
    }

    public static void main(String[] args) {

        MyAccount myAccount = new MyAccount(1000);
        PippoAccount pippoAccount = new PippoAccount(400);

        System.out.println("Saldo iniziale del conto corrente: " + myAccount.getBalance() + " $");
        System.out.println("Saldo iniziale del conto di Pippo: " + pippoAccount.getBalance() + " $");

        myAccount.deposit(300);
        pippoAccount.deposit(200);

        System.out.println("Saldo dopo depositi:");
        System.out.println("Conto di Pippo: " + pippoAccount.getBalance() + " $");
        System.out.println("Conto corrente: " + myAccount.getBalance() + " $");

        myAccount.withdraw(50);
        pippoAccount.withdraw(100);

        System.out.println("Saldo dopo i prelievi:");
        System.out.println("Conto di pippo: " + pippoAccount.getBalance() + " $");
        System.out.println("Conto corrente: " + myAccount.getBalance() + " $");

        myAccount.transfer(230, pippoAccount);

        System.out.println("Saldo dopo il trasferimento:");
        System.out.println("Conto di pippo: " + pippoAccount.getBalance() + " euro");
        System.out.println("Conto corrente: " + myAccount.getBalance() + " euro");
    }
}
