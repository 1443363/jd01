package banking;

import java.math.BigDecimal;
import java.util.*;

public class Bank implements IBank{
    private final String name;
    private Map<Person, List<Account>> data = new HashMap<>();

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

//    public void transfer(final String idFrom, final String idTo, double sum){
//        Person sender = null;
//        Person receiver = null;
//
//        for (Person person : data.keySet()) {
//            if (person.getId().equals(idFrom)){ sender = person;}
//            else if (person.getId().equalsIgnoreCase(idTo)){ receiver = person; }
//            else { throw new IllegalArgumentException("Получать или отправитель не является клиентом банка"); }
//        }
//
//        synchronized (sender.getAccounts()){
//            synchronized (receiver.getAccounts()){
//                if(idFrom.getBalance() > sum){
//                    idFrom.withdraw(sum);
//                    idTo.deposit(sum);
//                }
//            }
//        }
//    }

    public String getName() {
        return name;
    }
}
