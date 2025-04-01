package utils;

import models.User;

public class UserGenerator {

    public static User generateRandomUser() {
        return new User(
                DataGenerator.getRandomTitle(),
                DataGenerator.generateUserFullName(),
                DataGenerator.generateUserEmail(),
                DataGenerator.generatePassword(),
                DataGenerator.getRandomDay(),
                DataGenerator.getRandomMonth(),
                DataGenerator.getRandomYear(),
                AddressGenerator.generateRandomAddress()
        );
    }
}
