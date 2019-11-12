package banking;

import java.math.BigDecimal;
import java.util.*;

public class Bank implements IBank{
    private final String name;
    private Map<Person, List<Account>> data = new HashMap<>();
    private int transferOperations = 0;

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

    private void addAccount(Person p, Account account) throws IllegalArgumentException{
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //У пользователя уже есть учетка
        }
        //TODO проверить что счета с таким номером в банке больше уже нет
        //Done!
        List<Account> existingAccounts = new ArrayList<>();
        data.forEach((k, v) -> existingAccounts.addAll(v));

        if(!existingAccounts.contains(account)) {
            List<Account> accounts = this.data.get(p);
            accounts.add(account);
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
        Account accountFrom = null;
        Account accountTo = null;
        Person sender = null;
        Person receiver = null;
        double sumWithCom = 0;

        //получаем аккаунты из банка на основании id
        for (List<Account> accounts : data.values()) {
            for (Account account: accounts) {
                if (account.getId().equalsIgnoreCase(idFrom)) {
                    accountFrom = account;
                } else if (account.getId().equalsIgnoreCase(idTo)) {
                    accountTo = account;
                }
            }
        }

        //получаем персонов из банка на основании id
        for(Map.Entry<Person, List<Account>> entry : data.entrySet()) {
            if (entry.getValue().contains(accountFrom)) {
                sender = entry.getKey();
            }

            if (entry.getValue().contains(accountTo)) {
                receiver = entry.getKey();
            }
        }



        if (accountFrom == null && accountTo == null) {
            throw new IllegalArgumentException("Получать или отправитель не является клиентом банка");
        }

        synchronized (accountFrom){
            synchronized (accountTo){
                //сумма с коммиссией, в случае если пользователи разные
                sumWithCom = Helper.sumWithCommision(sender, receiver, sum);
                if(accountFrom.getBalance() >= sumWithCom){
                    accountFrom.withdraw(sumWithCom);
                    accountTo.deposit(sum);
                    System.out.println("Количество проведенных операций: " + this.transferOperations++);
                } else {
                    throw new IllegalArgumentException("Недостаточно средств на аккаунте отправителя");
                }
            }
        }
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
                " Accounts = " + accountsNum + '}';
    }
}
