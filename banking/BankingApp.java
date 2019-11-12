package banking;

import banking.Account;
import banking.Bank;
import banking.Person;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BankingApp {

    public static void main(String[] args) {
        Bank bank = new Bank("BankOfAmerica");

        Person person1 = new Person("MP255_____1", "Илья");
        Person person2 = new Person("MP255_____2", "Игорь");
        Person person3 = new Person("MP255_____3", "Света");

        List<Account> accounts = person1.getAccounts();

        accounts.add(bank.createAccountForPerson(person1, 10_000d));
        accounts.add(bank.createAccountForPerson(person1, 10_000d));

        Account account1 = accounts.get(0);
        Account account2 = accounts.get(1);

        Thread t1 = new Thread(new TransferTread(account1, account2, bank));
        Thread t2 = new Thread(new TransferTread(account1, account2, bank));
        Thread t3 = new Thread(new TransferTread(account1, account2, bank));
        Thread t4 = new Thread(new TransferTread(account1, account2, bank));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println(bank.toString());

        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            double avg = (account1.getBalance() + account2.getBalance()) / 2;
            System.out.println("Acc1 " + account1.getBalance());
            System.out.println("Acc2 " + account2.getBalance());
            System.out.println("AVG " + avg);
        }
    }

    private static class TransferTread implements Runnable{
        private final Account account1;
        private final Account account2;
        private final Bank bank;
        private Random rnd = new Random();

        private TransferTread(Account account1, Account account2, Bank bank) {
            this.account1 = account1;
            this.account2 = account2;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                Account acc1 = rnd.nextBoolean() ? account1 : account2;
                Account acc2 = acc1.equals(account1) ? account2 : account1;

                bank.transfer(acc1.getId(), acc2.getId(), rnd.nextDouble());
            }
        }
    }
}
