package net.yorksolutions.kabornamarrablogcmscapstone.controller;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return this.accountService.createAccount(account);
    }

    @GetMapping
    public Account getAccount(@RequestBody Account account){
        return this.accountService.getAccount(account);
    }

    @GetMapping("/all")
    public Iterable<Account> getAllAccounts(){
        return this.accountService.getAllAccounts();
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account account){
        return this.accountService.updateAccount(account);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam Long id){
        this.accountService.deleteAccount(id);
    }
}
