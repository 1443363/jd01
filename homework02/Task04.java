package homework02;

import dto.*;

public class Task04 {
    public void exampleInstanceOfOperator01() {
        IComputer computer = new Computer(new Ram(32), new Hdd(32));
        IComputer acerComputer = new AcerComputer(346, 24);

        //значение false т.к. сравнение принадлежности типа идет слева направо, но не наоборот
        System.out.println(computer instanceof AcerComputer);

        //значение true т.к. асер наследуется от класса компьютер, который в свою очередь имплементируется от интерфейса IComputer (сравнение слева направо)
        System.out.println(acerComputer instanceof IComputer);
    }

    public void exampleInstanceOfOperator02() {
        IComputer acerComputer = new AcerComputer(346, 24);
        IComputer asusComputer = new AsusComputer(23, 32);

        if(acerComputer instanceof AsusComputer) {
            acerComputer = ( AsusComputer ) acerComputer;
        } else {
            System.out.println("Incorrect casting!");
        }
    }
}
