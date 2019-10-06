package homework02;

    /*
    Данный метод не скомпилируется. Отобразится ошибка NPE, т.к. переменные непроинициализированны.
    И если примитивы int в таком случае по default будут равняться нулю,
    то переменная с ссылочным типом Integer = null по умолчанию из-за чего и отобразится данная ошибка.
    */
public class Task06 {

    private Integer k;
    private int z;
    private int i;

    public void method() {
        i = k + z;
    }

    public static void main(String[] args) {
        Task06 t = new Task06();
        t.method();
        System.out.println(t.i);
    }
}
