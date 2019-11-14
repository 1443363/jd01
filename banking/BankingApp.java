package banking;

import banking.Account;
import banking.Bank;
import banking.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankingApp {

    static Random rnd = new Random();

    static Queue<String> namesOfBank = new ConcurrentLinkedQueue<String>(){{
        add("Идея Банк");
        add("Банк БелВЭБ");
        add("Банк Решение");
        add("Банк Дабрабыт");
        add("Абсолютбанк");
        add("Альфа-Банк");
        add("БПС-Сбербанк");
        add("БСБ Банк (БелСвиссБанк)");
        add("БТА Банк");
        add("ВТБ Беларусь");
        add("БелГазпромБанк");
        add("БелАгроПромБанк");
        add("БеларусБанк");
        add("БелИнвестБанк");
        add("Белорусский Банк Малого Бизнеса");
        add("Белорусский Народный Банк");
        add("РРБ-Банк");
        add("ИнтерПэйБанк");
        add("Паритетбанк");
        add("Национальный Банк Республики Беларусь");
        add("ПриорБанк");
        add("МТБанк");
        add("Статусбанк (ЕвроТоргИнвестБанк)");
        add("ФрансаБанк");
        add("ТК Банк");
        add("Хоум Кредит Банк");
        add("ТехноБанк");
        add("ЕвроБанк");
        add("Дельта Банк");
        add("Цептер Банк");
    }};

    static List<String> names = new ArrayList<String>(){{
        add("Аарон");
        add("Абрам");
        add("Аваз");
        add("Августин");
        add("Авраам");
        add("Агап");
        add("Агапит");
        add("Агат");
        add("Агафон");
        add("Адам");
        add("Адриан");
        add("Азамат");
        add("Азат");
        add("Азиз");
        add("Айдар");
        add("Айрат");
        add("Акакий");
        add("Аким");
        add("Алан");
        add("Александр");
        add("Алексей");
        add("Али");
        add("Алик");
        add("Алим");
        add("Алихан");
        add("Алишер");
        add("Алмаз");
        add("Альберт");
        add("Амир");
        add("Амирам");
        add("Анар");
        add("Анастасий");
        add("Анатолий");
        add("Анвар");
        add("Ангел");
        add("Андрей");
        add("Анзор");
        add("Антон");
        add("Анфим");
        add("Арам");
        add("Аристарх");
        add("Аркадий");
        add("Арман");
        add("Армен");
        add("Арсен");
        add("Арсений");
        add("Арслан");
        add("Артём");
        add("Артемий");
        add("Артур");
        add("Архип");
        add("Аскар");
        add("Асхан");
        add("Асхат");
        add("Ахмет");
        add("Ашот");
    }};

    final static List<Person> peoples = Stream.generate(() -> {
        return new Person("MP" + rnd.nextInt(), names.get(names.size() - 1));
    })
//                .limit(100_000)
            .limit(100)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Bank> banks = Stream.generate(() -> {
            return new Bank(namesOfBank.poll());
        })
//                .limit(namesOfBank.size())
                .limit(10)
                .collect(Collectors.toList());

        List<Person> peoples = Stream.generate(() -> {
            return new Person("MP" + rnd.nextInt(), names.get(names.size() - 1));
        })
//                .limit(100_000)
                .limit(100)
                .collect(Collectors.toList());

        peoples.parallelStream()
                .filter(p -> rnd.nextBoolean())
                .forEach(p -> {
                    int countCreate = rnd.nextInt(20) + 1;
                    for (int i = 0; i < countCreate; i++) {
                        Bank bank = Helper.getRandomBank(banks);
                        bank.createAccountForPerson(p, rnd.nextDouble() * (rnd.nextInt(10_000) + 10));
                    }
                });



//        banks.parallelStream()
//                .filter(b -> rnd.nextBoolean())
//                .forEach(b -> {
//                    Person person = peoples.get(rnd.nextInt(peoples.size()));
//                    person.setAccounts(b.getData().get(person));
//                });
//
//
//
//        Person person1 = new Person("MP255_____1", "Илья");
//        Person person2 = new Person("MP255_____2", "Игорь");
//        Person person3 = new Person("MP255_____3", "Света");
//
//        List<Account> accounts = person1.getAccounts();
//
//        accounts.add(bank.createAccountForPerson(person1, 10_000d));
//        accounts.add(bank.createAccountForPerson(person1, 10_000d));
        Bank bank = Helper.getRandomBank(banks);

        Account account1 = Helper.getRandomAccount(peoples);

//        while(!Helper.isAccountExistInBank(bank, account1)) {
//            account1 = Helper.getRandomAccount(peoples);
//        }
        Account account2 = Helper.getRandomAccount(peoples);
//
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
//        for (int i = 0; i < 3; i++) {
//            executor.execute(new TransferTread(Helper.getRandomAccount(peoples), Helper.getRandomAccount(peoples), Helper.getRandomBank(banks)));
//        }


        System.out.println("--------------------");
        System.out.println(account1.getId());
        System.out.println(Helper.getPersonFromId(peoples, account1.getId()).toString());

        Thread t1 = new Thread(new TransferTread(account1, account2, bank));
//        Thread t2 = new Thread(new TransferTread(account1, account2, bank));
//        Thread t3 = new Thread(new TransferTread(account1, account2, bank));
//        Thread t4 = new Thread(new TransferTread(account1, account2, bank));

        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

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
                System.out.println("ТРАНСФЕР СОВЕРШЕН");
            }
        }
    }
}
