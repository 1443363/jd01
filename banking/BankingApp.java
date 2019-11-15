package banking;

import banking.additionals.Helper;
import banking.banks.Bank;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    static Queue<String> names = new ConcurrentLinkedQueue<String>(){{
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

    public final static List<Person> peoples = Stream.generate(() -> {
        return new Person("MP" + rnd.nextInt(), names.poll());
    })
                .limit(10_000)
            .collect(Collectors.toList());

    public final static List<Bank> banks = Stream.generate(() -> {
        return new Bank(namesOfBank.poll());
    })
//            .limit(namesOfBank.size())
            .limit(10)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();



        peoples.stream()
                .filter(p -> rnd.nextBoolean())
                .forEach(p -> {
                    int countCreate = rnd.nextInt(20) + 1;
                    for (int i = 0; i < countCreate; i++) {
                        Bank bank = Helper.getRandomBank(banks);
                        bank.createAccountForPerson(p, rnd.nextDouble() * (rnd.nextInt(10_000) + 10));
                    }
                });

        for (int i = 0; i < 4; i++) {
            executor.execute(new TransferThread(Helper.getRandomAccount(peoples), Helper.getRandomAccount(peoples),
                    Helper.getRandomBank(banks)));
        }
        executor.shutdown();

        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Helper.viewBanksTop10Balance();
        Helper.viewBanksTop10Transfers();
    }

    private static class TransferThread implements Runnable{
        private final Account account1;
        private final Account account2;
        private final Bank bank;

        private TransferThread(Account account1, Account account2, Bank bank) {
            this.account1 = account1;
            this.account2 = account2;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (!bank.isBankLock()){
                Account acc1 = rnd.nextBoolean() ? account1 : account2;
                Account acc2 = acc1.equals(account1) ? account2 : account1;
                bank.transfer(acc1.getId(), acc2.getId(), 10 + (500 - 10) * rnd.nextDouble());
            }
        }
    }
}
