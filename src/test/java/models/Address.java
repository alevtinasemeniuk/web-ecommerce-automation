package models;

public class Address {

    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String country;
    private String zipCode;
    private String mobileNumber;

    public Address(String firstName, String lastName, String company, String address, String address2, String country, String zipCode, String mobileNumber) {
        this.firstName = firstName;
        this.mobileNumber = mobileNumber;
        this.company = company;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.country = country;
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
}
