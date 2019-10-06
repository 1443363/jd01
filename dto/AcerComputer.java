package dto;

public class AcerComputer  extends Computer {
    public AcerComputer(Ram ram, Hdd hdd) {
        super(ram, hdd);
    }

    public AcerComputer(int ram, int hdd)
    {
        super(new Ram(ram), new Hdd(hdd));
    }

    public void work() {
        System.out.println("Я асер! Я работаю");
    }

    @Override
    public void on() {
        super.on();
        System.out.println("hdd: " + this.getHdd().getCapacity() + " ram: " + this.getRam().getSize());
    }
}
