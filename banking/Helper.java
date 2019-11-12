package banking;

public class Helper {

    public static double sumWithCommision(Person p1, Person p2, double sum) {
        if (p1.equals(p2)) {
            return sum;
        }

        return (sum > 500) ? (sum + (sum * 0.01)) : (sum + 5);
    }
}
