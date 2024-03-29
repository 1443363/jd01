package homework05;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date firstDate = new Date();
        Date secondDate = new Date();

        Task01 task01 = new Task01();
        task01.compareDates(firstDate, secondDate); // 1.1 task
        task01.addTimeToDate(firstDate); // 1.2 task
        viewCountryDataByName("FRANCE"); // 2.5 task
        compareEnums(Country.FRANCE, "FRANCE"); // 2.6 task
        returnInvalidEnum("Mongoly"); // 2.7 task "No enum constant homework05.Country.Mongoly" message
    }

    public static void viewCountryDataByName(String countryName) {
        Country country = Country.valueOf(countryName);
        System.out.println("Наименование страны: " + country + "\nПлощадь страны: " + country.getCountryArea()
                + "\nЧисленность населения: " + country.getCountryPopulation());
    }

    public static void compareEnums(Country firstCountry, String secondCountryName) {
        System.out.println("Сравнение стран через оператор \"==\" : "
                + (firstCountry == Country.valueOf(secondCountryName)));
    }

    public static void returnInvalidEnum(String invalidCountryName) {
        System.out.println(Country.valueOf(invalidCountryName));
    }
}
