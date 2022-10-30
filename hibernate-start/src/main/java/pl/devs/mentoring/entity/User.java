package pl.devs.mentoring.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private List<BankAccount> accounts = new ArrayList<>();

    //..inne pola
}
