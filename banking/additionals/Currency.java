package banking.additionals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Currency {
    USD,
    EUR,
    BYR;

    private static final List<Currency> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Currency getRandomCurrency(){
        return Currency.VALUES.get(RANDOM.nextInt(SIZE));
    }
}
