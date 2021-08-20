package service;

import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import repository.InterfaceAccountRepo;

import java.util.ArrayList;

public class AccountService implements InterfaceAccountService{
    @Autowired
    InterfaceAccountRepo interfaceAccountRepo;
    @Override
    public Account save(Account account) {
        return interfaceAccountRepo.save(account);
    }

    @Override
    public Account findById(long id) {
        return interfaceAccountRepo.findById(id).get();
    }

    @Override
    public ArrayList<Account> findAll() {
        return (ArrayList<Account>) interfaceAccountRepo.findAll();
    }

    @Override
    public ArrayList<Account> findAllByName(String name) {
        return interfaceAccountRepo.findAllByName(name);
    }

    @Override
    public void Delete(Account account) {
        interfaceAccountRepo.delete(account);
    }

    @Override
    public void edit(Account account) {
        interfaceAccountRepo.save(account);
    }
}
