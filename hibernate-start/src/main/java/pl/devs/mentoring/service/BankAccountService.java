package pl.devs.mentoring.service;

import org.springframework.stereotype.Service;
import pl.devs.mentoring.entity.BankAccount;
import pl.devs.mentoring.repository.BankAccountRepository;

import java.util.List;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public List<BankAccount> getBankAccountsWithGivenCurrency(String currency) {
        return bankAccountRepository.findAllByCurrency(currency);
    }
}
