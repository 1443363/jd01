package banking.banks;

import banking.Account;
import banking.additionals.Helper;
import banking.Person;

import java.util.*;

public class Bank implements IBank {
    private final String name;
    private Map<Person, List<Account>> data = new HashMap<>();
    private int transferOperations = 0;
    private boolean bankLock;

    public Bank(String name) {
        this.name = name;
    }

    public void addClient(Person p) throws IllegalArgumentException{
        if(!data.containsKey(p)){
            data.put(p, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Клиент уже имеет счета в банке");
        }
    }

    public Account createAccountForPerson(Person p, double startAmount){
        Account account = new Account(UUID.randomUUID().toString(), startAmount);
        addAccount(p, account);

        return account;
    }

    private synchronized void addAccount(Person p, Account account){
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //У пользователя уже есть учетка
        }
        //TODO проверить что счета с таким номером в банке больше уже нет
        //Done!
        if(!Helper.isAccountExistInBank(this, account)) {
            List<Account> accounts = this.data.get(p);
            accounts.add(account);
            p.setAccounts(account);
        } else {
            throw  new IllegalArgumentException("Такой счет уже есть в банке");
        }

    }

    public void delClient(Person p) throws IllegalStateException{
        if(!data.containsKey(p)){
            throw new IllegalArgumentException(String.format("Данный человек не имеет счетов в банке %s", this.name));
        } else {
            //TODO Впилить проверку что нельзя удалить клиента пока у него есть деньги на счету
            //Done!
            List<Double> accountBalances = new ArrayList<>();
            boolean isPersonHaveMoney = false;
            p.getAccounts().forEach(a -> accountBalances.add(a.getBalance()));

            for (double balance : accountBalances) {
                if (balance > 0) {
                    isPersonHaveMoney = true;
                }
            }

            if (!isPersonHaveMoney) {
                data.remove(p);
            } else {
                throw new IllegalArgumentException(String.format("Клиент %s имеет деньги на одном из счетов, " +
                        "невозможно удалить данного клиента", p.getName()));
            }
        }
    }

    public void transfer(final String idFrom, final String idTo, double sum){
        Account accountFrom = Helper.getAccountFromId(idFrom);
        Account accountTo = Helper.getAccountFromId(idTo);
        Person sender = Helper.getPersonFromId(idFrom);
        Person receiver = Helper.getPersonFromId(idTo);
        double sumWithCom = 0;
        boolean transferMade = false;

        if (accountFrom == null && accountTo == null) {
            throw new IllegalArgumentException("Получать или отправитель не является клиентом банка");
        }
        synchronized (accountFrom){
            synchronized (accountTo){
                //сумма с коммиссией, в случае если пользователи разные или не принадлежат банку
                sumWithCom = Helper.sumWithCommision(this, sender, receiver, sum);

                for (int i = 0; i < 20; i++) {
                    if (accountFrom.getBalance() >= sumWithCom) {
                        accountFrom.withdraw(sumWithCom);
                        accountTo.deposit(sum);
                        System.out.println("___________________");
                        System.out.println("Баланс аккаунта отправителя:" + accountFrom.getBalance());
                        System.out.println("Баланс аккаунта получателя: " + accountTo.getBalance());
                        System.out.println("Сумма для перевода: " + sum);
                        System.out.println("Сумма с учетом коммисии: " + sumWithCom);
                        System.out.println("AVG: " + (accountFrom.getBalance() + accountTo.getBalance()) / 2);
                        System.out.println("Для банка " + this.name + " было произведено операций: " + ++transferOperations);
                        System.out.println(this.toString());
                        transferMade = true;
                        break;
                    } else {
                        for (Account account : sender.getAccounts()) {
                            if (account.getBalance() >= sumWithCom) {
                                System.out.println("Был использован другой аккаунт отправителя, т.к. на выбранному недостаточно средств");
                                accountFrom.withdraw(sumWithCom);
                                accountTo.deposit(sum);
                                System.out.println("___________________");
                                System.out.println("Баланс аккаунта отправителя:" + accountFrom.getBalance());
                                System.out.println("Баланс аккаунта получателя: " + accountTo.getBalance());
                                System.out.println("Сумма для перевода: " + sum);
                                System.out.println("Сумма с учетом коммисии: " + sumWithCom);
                                System.out.println("AVG: " + (accountFrom.getBalance() + accountTo.getBalance()) / 2);
                                System.out.println("Для банка " + this.name + " было произведено операций: " + ++transferOperations);
                                System.out.println(this.toString());
                                transferMade = true;
                                break;
                            }
                        }
                        if (!transferMade) {
                            sender.setBankrupt(true);
                        }
                        bankLock = true;
                        throw new IllegalArgumentException("Недостаточно средств на аккаунте отправителя");
                    }
                }

            }
        }
    }

    public Map<Person, List<Account>> getData() {
        return data;
    }

    public boolean isBankLock() {
        return bankLock;
    }

    public int getTransferOperations() {
        return transferOperations;
    }

    @Override
    public String toString() {
        int accountsNum = 0;

        for (List<Account> accounts : data.values()) {
            for (Account account: accounts) {
                accountsNum++;
            }
        }

        return "Bank{" + "name ='" + name + '\'' + ", Persons = " + data.keySet().size() + " ," +
                " Accounts = " + accountsNum + ", BankBalance = " + Helper.getBankBalance(this) +'}';
    }
}
