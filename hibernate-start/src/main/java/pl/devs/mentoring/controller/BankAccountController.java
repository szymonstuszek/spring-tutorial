package pl.devs.mentoring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.devs.mentoring.entity.BankAccount;
import pl.devs.mentoring.service.BankAccountService;

import java.util.List;

@RestController
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/v1/accounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @GetMapping("/v1/accounts/currency")
    public List<BankAccount> getBankAccountsWithCurrency() {
        return bankAccountService.getBankAccountsWithGivenCurrency("PLN");
    }
}
