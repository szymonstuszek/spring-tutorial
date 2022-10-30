package pl.devs.mentoring.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_balance")
    private BigDecimal balance;

    @Column(name = "currency_code")
    private String currency;

    @Column(name = "account_type")
    private String type;

    @Column(name = "owner_id")
    private Long ownerId;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BankAccount() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public Long getOwnerId() {
        return ownerId;
    }
}
