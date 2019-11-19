package banking.additionals;

import banking.Account;
import banking.BankingApp;
import banking.Person;
import banking.banks.Bank;
import banking.comparators.ComparatorBankBalance;
import banking.comparators.ComparatorBankOperations;
import homework04.dto.File;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.text.Format;
import java.util.*;
import java.util.stream.Collectors;

import static banking.BankingApp.banks;
import static banking.BankingApp.peoples;


public class Helper {
    static Random rnd = new Random();
    final static int ds = 2;

    //Если пользователи разные или не принадлежат одному банку, то банк берет процент за перевод
    public static double sumWithCommision(Bank bank, Person p1, Person p2, double sum) {
        if ((p1.equals(p2)) && (bank.getData().containsKey(p1))) {
            return sum;
        }
        if (sum > 500) {
            bank.setBalanceFromOperations(bank.getBalanceFromOperations() + (sum * 0.01));
        } else {
            bank.setBalanceFromOperations(bank.getBalanceFromOperations() + 5);
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

    public static Person getPersonFromId(String id) {
        for (Person person : peoples) {
            for (Account account : person.getAccounts()) {
                if (account.getId().equalsIgnoreCase(id)) {
                    return person;
                }
            }
        }
        throw new IllegalArgumentException("Не найден искомый id среди существующих пользователей");
    }

    public static Account getAccountFromId(String id) {
        for (Person person : peoples) {
            for (Account account : person.getAccounts()) {
                if (account.getId().equalsIgnoreCase(id)) {
                    return account;
                }
            }
        }
        throw new IllegalArgumentException("Не найден пользователь с таким id");
    }

    //Баланс банка в USD Currency
    public static double getBankBalance(Bank bank) {
        double bankBalance = 0.0;

        for (List<Account> accounts : bank.getData().values()) {
            bankBalance += accounts.stream().
                    mapToDouble(a -> convertToUSD(a, a.getBalance())).
                    sum();
        }
        return (bankBalance + bank.getBalanceFromOperations());
    }

    public static double getPersonBalance(Person person) {
        double personBalance = person.getAccounts().stream().mapToDouble(Account::getBalance).sum();

        return personBalance;
    }

    public static void viewBanksTop10Balance() {
        List<Bank> banks = new ArrayList<>(BankingApp.banks);
        List<Bank> top10Banks = new ArrayList<>();

        top10Banks = banks.stream().sorted(new ComparatorBankBalance()).limit(10).collect(Collectors.toList());

        Collections.reverse(top10Banks);
        System.out.println("Ниже приведен список топ 10 банков по балансу: ");
        System.out.println(top10Banks.toString());
    }

    public static void viewBanksTop10Transfers() {
        List<Bank> banks = new ArrayList<>(BankingApp.banks);
        List<Bank> top10Banks = new ArrayList<>();


        top10Banks = banks.stream().sorted(new ComparatorBankOperations()).limit(10).collect(Collectors.toList());

        Collections.reverse(top10Banks);
        System.out.println("Ниже приведен список топ 10 банков по проведенным операциям: ");
        System.out.println(top10Banks.toString());
    }


    public static void banksToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("listOfBanks.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {

            for (Bank bank : banks) {
                objectOut.writeObject(bank.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void personsToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("listOfPersons.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {

            for (Person person : peoples) {
                objectOut.writeObject(person.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double convertSum(Account accountFrom, Account accountTo, double sum) {
        if (accountFrom.getCurrency().equals(Currency.USD)) {
            double resultOfConvertation = 0;
            switch (accountTo.getCurrency()) {
                case USD:
                    return resultOfConvertation = sum;
                case EUR:
                    return resultOfConvertation = sum * 0.9;
                case BYR:
                    return resultOfConvertation = sum * 2.04;
            }
        } else if (accountFrom.getCurrency().equals(Currency.EUR)) {
            double resultOfConvertation = 0;
            switch (accountTo.getCurrency()) {
                case USD:
                    return resultOfConvertation = sum * 1.11;
                case EUR:
                    return resultOfConvertation = sum;
                case BYR:
                    return resultOfConvertation = sum * 2.26;
            }
        } else {
            double resultOfConvertation = 0;
            switch (accountTo.getCurrency()) {
                case USD:
                    return resultOfConvertation = sum * 0.49;
                case EUR:
                    return resultOfConvertation = sum * 0.44;
                case BYR:
                    return resultOfConvertation = sum;
            }
        }

        throw new IllegalArgumentException("Невозможно произвести конвертацию, неизвестная валюта");
    }

    public static double convertToUSD(Account accountTo, double sum) {
        double resultOfConvertation = 0;
        switch (accountTo.getCurrency()) {
            case USD:
                return resultOfConvertation = sum;
            case EUR:
                return resultOfConvertation = sum * 0.9;
            case BYR:
                return resultOfConvertation = sum * 2.04;

        }
        throw new IllegalArgumentException("Невозможно произвести конвертацию, неизвестная валюта");
    }
}