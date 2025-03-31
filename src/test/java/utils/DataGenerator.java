package utils;

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

    public static String generateUserNickName() {
        return generateRandomWord() + random.nextInt(1000);
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

    public static String generateUserFullName() {
        String word1 = generateRandomWord();
        String word2 = generateRandomWord();
        String firstName = word1.substring(0, 1).toUpperCase() + word1.substring(1);
        String lastName = word2.substring(0, 1).toUpperCase() + word2.substring(1);

        return firstName + " " + lastName;
    }

    public static String generateUserEmail() {
        StringBuilder email = new StringBuilder("user");
        for (int i = 0; i < 5; i++) {
            email.append(random.nextInt(10)); // число от 0 до 9
        }
       return email + "@qa.com";
    }
}
