package banking;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Helper {
    static Random rnd = new Random();
    final static int ds = 2;

    public static double sumWithCommision(Person p1, Person p2, double sum) {
        if (p1.equals(p2)) {
            return sum;
        }

        return (sum > 500) ? (sum + (sum * 0.01)) : (sum + 5);
    }

    public static Account getRandomAccount(List<Person> peoples) {
        Person randomPerson = peoples.get(rnd.nextInt(peoples.size()));

        while (randomPerson.getAccounts().size() < 1) {
            randomPerson = peoples.get(rnd.nextInt(peoples.size()));
        }

        Account randomAccount = randomPerson.getAccounts().get(rnd.nextInt(randomPerson.getAccounts().size()));
        return randomAccount;
    }

    public static Bank getRandomBank(List<Bank> banks) {
        Bank randomBank = banks.get(rnd.nextInt(banks.size()));
        return randomBank;
    }

    public static boolean isAccountExistInBank(Bank bank, Account account) {
        List<Account> existingAccount = new ArrayList<>();
        Map<Person, List<Account>> data = bank.getData();
        data.forEach((k, v) -> existingAccount.addAll(v));

        return existingAccount.contains(account);
    }

    public static Person getPersonFromId(List<Person> peoples, String id) {
        //создаем рандомный аккаунт с таким же ид, т.к. equals переопределен на сравнение по id
        Account acc = new Account(id, rnd.nextDouble());
        for (Person person: peoples) {
            if (person.getAccounts().contains(acc)) {
                return person;
            }
        }
        return null;
    }

    public static Account getAccountFromId(List<Person> peoples, String id) {
        //создаем рандомный аккаунт с таким же ид, т.к. equals переопределен на сравнение по id
        Person person = getPersonFromId(BankingApp.peoples, id);
        Account fakeAcc = new Account(id, rnd.nextDouble());
        for (Account acc : person.getAccounts()) {
            if (acc.equals(fakeAcc)) {
                return acc;
            }
        }
        throw new IllegalArgumentException("Не найден пользователь с таким id");
    }


//    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        List<String> newStrings = new ArrayList<>();
//
//        strings.add("dsadas");
//        strings.add("dsadas");
//        strings.add("dsadas");
//        strings.add("dsadas");
//        newStrings.add("qqweqewqwe");
//        newStrings.add("qqweqewqwe");
//
//        newStrings.addAll(strings);
//
//        System.out.println("string: " + strings.toString());
//        System.out.println("newString: " + newStrings.toString());
//    }
}
