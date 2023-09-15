package org.generation.exercises.bankaccount;

/*
Creare una classe GoldAccount che estende Account, che avra'
un construttore che riceve un amount a lo setta come saldo iniziale del conto
overrida deposit(amount) in modo che il saldo venga incrementato di amount ricevendo
pero' anche un bonus che va dal 1 al 7 per cento dell amount a seconda del giorno della
settimana in cui avviene l' operazione (1% domenica .... 7% sabato).
 */

import java.time.DayOfWeek;
import java.time.LocalDate;

public class GoldAccount extends Account {


    public GoldAccount(double amount) {
        super(amount);
    }

    private double setBonus(double amount) {
        LocalDate currentDay = LocalDate.now();
        DayOfWeek day = currentDay.getDayOfWeek();
        int bonus;

        switch (day) {
            case SUNDAY:
                bonus = 1;
                break;
            case MONDAY:
                bonus = 2;
                break;
            case TUESDAY:
                bonus = 3;
                break;
            case WEDNESDAY:
                bonus = 4;
                break;
            case THURSDAY:
                bonus = 5;
                break;
            case FRIDAY:
                bonus = 6;
                break;
            case SATURDAY:
                bonus = 7;
                break;
            default:
                bonus = 0;
                break;
        }

        return (bonus / 100.0) * amount;
    }

    @Override
    public void deposit(double amount) {
        double bonus = setBonus(amount);
        double totalAmount = amount + bonus;

        setBalance(getBalance() + totalAmount);
        System.out.println("Deposito di " + amount);
        System.out.println("Bonus: " + bonus);
        System.out.println("Saldo: " + this.getBalance());
    }

    public static void main(String[] args) {
        GoldAccount goldAccount = new GoldAccount(1000);

        System.out.println("Saldo iniziale del conto Gold: " + goldAccount.getBalance() + " euro");

        goldAccount.deposit(200);

        System.out.println("Saldo dopo il deposito:");
        System.out.println("Conto Gold: " + goldAccount.getBalance() + " euro");
    }
}
