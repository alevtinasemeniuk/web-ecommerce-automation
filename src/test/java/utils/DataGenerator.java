package utils;

import models.Month;

import java.util.*;

public class DataGenerator {
    private static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SYMBOLS = "!@#$%^&*()_+-=";
    private static final String DIGITS = "01234567890";
    private static final String ALL_CHARS = ALPHABET_UPPER + ALPHABET_LOWER + SYMBOLS + DIGITS;
    private static final Random random = new Random();

    public static String generateRandomWord() { //метод генерирует случайную строку из букв длиной от 2 до 11
        StringBuilder word = new StringBuilder();
        int len = random.nextInt(10) + 2;// даёт число от 0 до 9 и смещает диапазон в 2–11 (это будет длина слова)

        for (int i = 0; i < len; i++) {
            int index = random.nextInt(ALPHABET_LOWER.length()); // для случайного индекса в пределах строки алфавита
            word.append(ALPHABET_LOWER.charAt(index));
        }
        return word.toString();
    }

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        password.append(ALPHABET_UPPER.charAt(random.nextInt(ALPHABET_UPPER.length())));
        password.append(ALPHABET_LOWER.charAt(random.nextInt(ALPHABET_LOWER.length())));
        password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));

        for (int i = 0; i < 6; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }
        //Перемешиваем символы:
        List<Character> chars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        // Собираем обратно из листа в строку
        StringBuilder finalPassword = new StringBuilder();
        for (char c : chars) {
            finalPassword.append(c);
        }
        return finalPassword.toString();
    }

    public static String generateRandomUserName() {
        String word = generateRandomWord();
        return  word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static String generateUserFullName() {
        return generateRandomUserName() + " " + generateRandomUserName();
    }

    public static String generateUserEmail() {
        StringBuilder email = new StringBuilder("user");
        for (int i = 0; i < 5; i++) {
            email.append(random.nextInt(10)); // число от 0 до 9
        }
       return email + "@qa.com";
    }

    public static Month getRandomMonth() {
        Month[] months = Month.values();
        return months[random.nextInt(months.length)];
    }

    public static int getRandomDay() {
        return random.nextInt(28) + 1; // от 1 до 28 включительно
    }

    public static int getRandomYear() {
        return random.nextInt(2021 - 1900 + 1) + 1900; // от 1900 до 2021 включительно
    }

    public static String getRandomCountry() {
        String[] countries = {
                "India",
                "United States",
                "Canada",
                "Australia",
                "Israel",
                "New Zealand",
                "Singapore"
        };
        return countries[random.nextInt(countries.length)];
    }

    public static String generateRandomStreetAddress() {
        return (random.nextInt(1000) + 1) + " " + generateRandomWord() + " " + "Street" ;
    }

    public static String generateRandomAddress2() {
        return "apt № " + (random.nextInt(1000) + 1);
    }

    public static String generateRandomZipCode() {
        return String.valueOf(random.nextInt(99999 - 10000 + 1) + 10000); //от 10000 до 99999
    }

    public static String generateRandomMobileNumber() {
        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phone.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return phone.toString();
    }

    public static String getRandomTitle() {
        String[] titles = {"Mr", "Mrs"};
        return titles[random.nextInt(2)];
    }
}
