package banking;

import banking.additionals.Helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable{
    private final String id;
    private String name;
    private List<Account> accounts = new ArrayList<>();
    private boolean isBankrupt;



    public Person(String id) {
        this.id = id;
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = ( Person ) o;
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Person{" + "id='" + id + '\'' + ", name='" + this.name + '\'' + ", balance='"
                + Helper.getPersonBalance(this) + ", accounts=" + accounts + '}';
    }


//    @Override
//    public String toString() {
//        return "Person{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", accounts=" + accounts + ", isBankrupt=" + isBankrupt + '}';
//    }


//    @Override
//    public String toString() {
//        return "Person{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
