package dto;

public class Computer implements IComputer {

    private Ram ram;
    private Hdd hdd;


    public Computer(Ram ram, Hdd hdd)
    {
        this.ram = ram;
        this.hdd = hdd;
    }
    public void on() {
        System.out.println("On");
    }

    public void off() {
        System.out.println("off");
    }

    public void reset() {
        System.out.println("reset");
    }

    public void work() {};

    public Ram getRam() {
        return ram;
    }

    public Hdd getHdd() {
        return hdd;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "ram = " + getRam().getSize() + ", hdd = " +
                "" + getHdd().getCapacity() + '}';
    }
}
