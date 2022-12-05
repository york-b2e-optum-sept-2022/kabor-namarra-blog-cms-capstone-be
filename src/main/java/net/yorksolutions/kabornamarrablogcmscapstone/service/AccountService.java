package net.yorksolutions.kabornamarrablogcmscapstone.service;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account){
        return this.accountRepository.save(account);
    }

    public Account getAccount(Long id){
        Optional<Account> accountOptional = this.accountRepository.findById(id);

        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return accountOptional.get();
    }

    public Iterable<Account> getAllAccounts(){
        return this.accountRepository.findAll();
    }

    public Account updateAccount(Account account){
        Optional<Account> accountOptional = this.accountRepository.findById(account.getId());
        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Account updatedAccount = accountOptional.get();
        updatedAccount.setUsername(account.getUsername());
        updatedAccount.setPassword(account.getPassword());
        updatedAccount.setFirstname(account.getFirstname());
        updatedAccount.setLastname(account.getLastname());


        return this.accountRepository.save(updatedAccount);
    }

    public void deleteAccount(Long id){
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.accountRepository.delete(accountOptional.get());
    }
}
