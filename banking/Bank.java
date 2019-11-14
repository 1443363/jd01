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

    private synchronized void addAccount(Person p, Account account){
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //У пользователя уже есть учетка
        }
        //TODO проверить что счета с таким номером в банке больше уже нет
        //Done!
//        existingAccounts.addAll(v)
//        List<Account> existingAccounts = new ArrayList<>();
//
//            for (Map.Entry<Person, List<Account>> entry : data.entrySet()) {
//                existingAccounts.addAll(entry.getValue());
//            }

//        Iterator iterator = data.values().iterator();
//
//        while(iterator.hasNext()) {
//            Object accounts = iterator.next();
//            existingAccounts.add(accounts);
//        }

//        if(!existingAccounts.contains(account)) {
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
        Account accountFrom = null;
        Account accountTo = null;
        Person sender = null;
        Person receiver = null;
        double sumWithCom = 0;
        System.out.println("ТРАНСФЕР НАЧАЛСЯ");

        //получаем аккаунты из банка на основании id
        for (List<Account> accounts : data.values()) {
            for (Account account: accounts) {
                if (account.getId().equalsIgnoreCase(idFrom)) {
                    accountFrom = account;
                    System.out.println("-----------------");
                    System.out.println(accountFrom.getId());
                } else if (account.getId().equalsIgnoreCase(idTo)) {
                    accountTo = account;
                }
            }
        }

        //получаем персонов на основании id
        sender = Helper.getPersonFromId(BankingApp.peoples, idFrom);
        receiver = Helper.getPersonFromId(BankingApp.peoples, idFrom);
        System.out.println("~~~~~~~~T~~~~~~~~~");
        System.out.println("dsadas" + sender.toString());
        System.out.println(receiver.toString());

        //получаем аккаунты на основании id



        for(Map.Entry<Person, List<Account>> entry : data.entrySet()) {
            if (entry.getValue().contains(accountFrom)) {
                sender = entry.getKey();
            }

            if (entry.getValue().contains(accountTo)) {
                receiver = entry.getKey();
            }
        }
//        System.out.println("Sender" + sender.toString());
//        System.out.println("Receiver" + receiver.toString());
//        System.out.println("dsadsadsa");
//
//        while(accountFrom == null && accountTo == null) {
//            try {
//                throw new IllegalArgumentException("Получать или отправитель не является клиентом банка");
//            }catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("From" + accountFrom);
        System.out.println("To" + accountTo);
        if (accountFrom == null && accountTo == null) {
            throw new IllegalArgumentException("Получать или отправитель не является клиентом банка");
        }

        System.out.println("Sender" + sender.toString());
        System.out.println("Receiver" + receiver.toString());

        synchronized (accountFrom){
            synchronized (accountTo){
                //сумма с коммиссией, в случае если пользователи разные
                sumWithCom = Helper.sumWithCommision(sender, receiver, sum);
                if(accountFrom.getBalance() >= sumWithCom){
                    accountFrom.withdraw(sumWithCom);
                    accountTo.deposit(sum);
                    System.out.println("Для банка " + this.name + " было произведено операций: " + ++transferOperations);
                } else {
                    throw new IllegalArgumentException("Недостаточно средств на аккаунте отправителя");
                }
            }
        }
    }

    public Map<Person, List<Account>> getData() {
        return data;
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
