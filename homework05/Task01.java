package homework05;

import java.util.Calendar;
import java.util.Date;

public class Task01 {

    public void compareDates(Date firstDate, Date secondDate) {
        System.out.println("Результат сравнения дат при помощи \"==\" : " + (firstDate == secondDate));
        System.out.println("Результат сравнения дат при помощи equals : " + firstDate.equals(secondDate));
    }

    public void addTimeToDate(Date firstDate){
        System.out.println("Первоначальная дата: " + firstDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.DATE, 5);
        calendar.add(Calendar.MONTH, 1);
        firstDate = calendar.getTime();
        System.out.println("Дата после добавления 5 дней и 1 месяца: " + firstDate);

        calendar.set(2020, 01, 29);
        Date secondDate = calendar.getTime();
        System.out.println("Создали новую дату: " + secondDate);
        calendar.add(Calendar.YEAR, 1);
        secondDate = calendar.getTime();
        System.out.println("Прибавили ей 1 год: " + secondDate);
    }



}
