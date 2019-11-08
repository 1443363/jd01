package banking;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private double balance;

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
}
