package org.generation.exercises.bank_account_prof;

public class SavingsAccount extends Account{
    public SavingsAccount(double amount) {
        super(amount);
    }

    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            setBalance(getBalance() + amount);
        } else {
            throw new IllegalArgumentException("L'importo del deposito non può essere negativo");
        }
    }
}
