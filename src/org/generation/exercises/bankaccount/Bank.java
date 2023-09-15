package org.generation.exercises.bankaccount;

/*
create una classe Bank che abbia un ArrayList che contiene la Lista di tutti i conti
presenti nella banca. Possiamo fare una lista per tutti i tipi di conto o no?
E se si sarebbe una List di che cosa?
Scrivete in questa classe un metodo handleAccounts che riceva due conti correnti,
depositi 10 euro sul primo conto se il primo conto ha meno di 100 euro di saldo, ritiri 200
euro dal secondo e sposti 100 euro dal conto con saldo minore a quello con saldo maggiore
 */

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void handleAccounts(Account firstAccount, Account secondAccount) {
        if (firstAccount.getBalance() < 100) {
            firstAccount.deposit(10);
            System.out.println("Depositati 10 $ dal primo conto");
            System.out.printf("Saldo rimanente: %s%n", firstAccount.getBalance());
        }

        secondAccount.withdraw(200);
        System.out.println("Prelevati 200 $ dal secondo conto");

        double transferAmount = 100;
        Account soldiCaPalaAccount = firstAccount.getBalance() < secondAccount.getBalance() ? firstAccount : secondAccount;
        Account puzzoDeFameAccount = firstAccount.getBalance() >= secondAccount.getBalance() ? firstAccount : secondAccount;

        if (soldiCaPalaAccount.getBalance() >= transferAmount) {
            soldiCaPalaAccount.withdraw(transferAmount);
            puzzoDeFameAccount.withdraw((transferAmount));
        }
    }

    public static void main(String[] args) {
        Bank bancaMediolanum = new Bank();
        CaymanAccount caymanAccount = new CaymanAccount(99, "pippo");
        GoldAccount goldAccount = new GoldAccount(600);

        bancaMediolanum.addAccount(caymanAccount);
        bancaMediolanum.addAccount(goldAccount);

        for (Account account : bancaMediolanum.accounts) {
            System.out.println(account.getBalance());
        }

        bancaMediolanum.handleAccounts(caymanAccount, goldAccount);

        for (Account account : bancaMediolanum.accounts) {
            System.out.println(account.getBalance());
        }
    }
}
