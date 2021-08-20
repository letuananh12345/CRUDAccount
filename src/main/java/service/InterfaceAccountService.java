package service;

import model.Account;

import java.util.ArrayList;

public interface InterfaceAccountService {
    Account save(Account account);

    Account findById(long id);

    ArrayList<Account> findAll();

    ArrayList<Account> findAllByName(String name);

    void Delete(Account account);

    void edit(Account account);
}
