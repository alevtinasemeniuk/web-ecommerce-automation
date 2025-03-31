package utils;

import java.util.Random;

public class DataGenerator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();


public static String generateUserName() {
    StringBuilder name = new StringBuilder();
    int len = random.nextInt(10) + 2; // даёт число от 0 до 9 и смещает диапазон в 2–11 (это будет длина имени)

    for (int i = 0; i < len ; i++) {
        int index = random.nextInt(ALPHABET.length()); // для случайного индекса в пределах строки алфавита
        name.append(ALPHABET.charAt(index));
        }
    return name.substring(0, 1).toUpperCase() + name.substring(1); // чтобы первая буква строки была заглавной
    }

    public static String generateUserEmail() {
        StringBuilder email = new StringBuilder("user");
        for (int i = 0; i < 5; i++) {
            email.append(random.nextInt(10)); // число от 0 до 9
        }
       return email.toString() + "@qa.com";
    }
}
