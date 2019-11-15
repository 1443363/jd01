package banking;

import banking.additionals.Currency;

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
        if (sum < balance) {
            this.balance -= sum;
        } else {
            try {
                throw new IllegalArgumentException("На счету недостаточно средств");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Account{" + "id='" + id + '\'' + ", balance=" + balance + ", currency=" + currency + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
