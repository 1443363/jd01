package homework03;

import dto.AcerComputer;
import dto.AsusComputer;
import homework1.car.types.Ferrari;
import homework1.car.types.Lada;

import java.nio.charset.Charset;
import java.util.Random;

public class Task03 {
    private Object[] masOfTheRandomObjects;

    public void displayMasOfTheRandomObjects(int numOfElements) {
        masOfTheRandomObjects = new Object[numOfElements];
        Random random = new Random();

        for (int i = 0; i < masOfTheRandomObjects.length; i++) {
            if ((i % 2 == 0)) {
                masOfTheRandomObjects[i] = new AsusComputer(random.nextInt() & Integer.MAX_VALUE, random.nextInt()
                        & Integer.MAX_VALUE);
                System.out.println(masOfTheRandomObjects[i]);
            } else {
                masOfTheRandomObjects[i] = new AcerComputer(random.nextInt() & Integer.MAX_VALUE, random.nextInt()
                        & Integer.MAX_VALUE);
                System.out.println(masOfTheRandomObjects[i]);
            }
        }
    }
}
