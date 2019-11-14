package banking;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private final String id;
    private double balance;
    private Currency currency;

    public Account(String id) {
        this.id = id;
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double sum){
        this.balance += sum;
    }

    public void withdraw(double sum){
        this.balance -= sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Account{" + "id='" + id + '\'' + ", balance=" + balance + ", currency=" + currency + '}';
    }
}
