package banking.comparators;

import banking.banks.Bank;

import java.util.Comparator;

public class ComparatorBankOperations implements Comparator<Bank> {

    @Override
    public int compare(Bank o1, Bank o2) {
        if (o1.getTransferOperations() < o2.getTransferOperations()) return -1;
        if (o1.getTransferOperations() == o2.getTransferOperations()) return 0;
        return 1;
    }
}
