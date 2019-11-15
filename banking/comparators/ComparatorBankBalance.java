package banking.comparators;

import banking.additionals.Helper;
import banking.banks.Bank;

import java.util.Comparator;

public class ComparatorBankBalance implements Comparator<Bank> {

    @Override
    public int compare(Bank o1, Bank o2) {
        return Double.compare(Helper.getBankBalance(o1), Helper.getBankBalance(o2));
    }
}
