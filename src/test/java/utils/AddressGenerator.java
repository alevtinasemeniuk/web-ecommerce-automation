package utils;

import models.Address;

public class AddressGenerator {

    public static Address generateRandomAddress() {
        return new Address(
                DataGenerator.generateRandomUserName(),
                DataGenerator.generateRandomUserName(),
                DataGenerator.generateRandomWord(),
                DataGenerator.generateRandomStreetAddress(),
                DataGenerator.generateRandomAddress2(),
                DataGenerator.getRandomCountry(),
                DataGenerator.generateRandomZipCode(),
                DataGenerator.generateRandomMobileNumber()
        );
    }
}
