package helpers;

import com.ibm.icu.text.Transliterator;

import java.util.Random;

public class Utils {

    private static String [] firstNames = {"Дмитрий", "Алексей", "Иван", "Сергей", "Кирилл", "Генадий", "Артем", "Владимир", "Руслан", "Егор"};
    private static String [] lastNames = {"Иванов", "Петров", "Герасимов", "Швецов", "Крылов", "Пушкин", "Грачёв", "Глушков", "Духов"};
    private static String [] settlements = {"г. Москва", "г. Кострома", "п. Вохма", "д. Тихон", "г. Ярославль", "г. Севастополь", "г. Мариуполь"};
    private static String [] streets = {"Ленина", "Советская", "Профсоюзная", "Лесная", "Пушкина", "Победы", "Труда", "Космонавтов", "Гагарина"};
    private static String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
    private static String [] gender = {"Мужчина", "Женщина"};

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static String genFirstName() {
        Random random = new Random();
        int i = random.nextInt(firstNames.length);
        return  firstNames[i];
    }

    public static String genLastName() {
        Random random = new Random();
        int i = random.nextInt(lastNames.length);
        return  lastNames[i];
    }

    public static String genPhone() {
        Random random = new Random();
        String operatorCode = String.valueOf((random.nextInt(100)+900));
        String subscriberNumberOne = String.valueOf((random.nextInt(100)+900));
        String subscriberNumberTwo = String.valueOf((random.nextInt(10)+90));
        String subscriberNumberThree = String.valueOf((random.nextInt(10)+90));
        String phone = "+7(" + operatorCode + ")" + subscriberNumberOne + "-" + subscriberNumberTwo + "-" + subscriberNumberThree;
        return phone;
    }

    public static String genEmail(String firstName, String lastName) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        firstName = toLatinTrans.transliterate(firstName);
        lastName = toLatinTrans.transliterate(lastName);
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
        return email;
    }

    public static String genAddress() {
        Random random = new Random();
        int i = random.nextInt(settlements.length);
        String locality = settlements[i];
        i = random.nextInt(settlements.length);
        String street = streets[i];
        int numberHouse = random.nextInt(150);
        int numberApartment = random.nextInt(200);
        String address = locality + " ул. " + street + " д. " + numberHouse + " кв. " + numberApartment;
        return address;
    }

    public static String genGender() {
        Random random = new Random();
        return gender[random.nextInt(gender.length)];
    }

    public static String genPassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}


