package org.generation.exercises.bank_account_prof;

public interface AccountRepository{

    void addAccount(Account account);
    Account findById(long id);
    Iterable<Account> getAccounts();
}
