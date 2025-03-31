package utils;

import models.User;

public class UserGenerator {

    public static User generateRandomUser() {
        return new User(DataGenerator.generateUserNickName(),
                DataGenerator.generateUserEmail(),
                DataGenerator.generatePassword());
    }
}
