package models;

public class Address {

    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address;
    private final String address2;
    private final String country;
    private final String zipCode;
    private final String city;
    private final String state;
    private final String mobileNumber;

    public Address(String firstName, String lastName, String company, String address, String address2, String country, String state, String zipCode, String city, String mobileNumber) {
        this.firstName = firstName;
        this.mobileNumber = mobileNumber;
        this.company = company;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address2 = address2;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
