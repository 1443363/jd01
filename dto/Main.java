package dto;
import dto.*;

public class Main {
    public static void main(String[] args) {
        IComputer c1 = new AsusComputer(new Ram(10), new Hdd(1008));
        IComputer c2 = new AsusComputer(10, 1008);
        IComputer c3 = new AsusComputer(10, 4608);

        c1.on();
        c1.work();

        c3.on();
        c3.work();


    }
}
