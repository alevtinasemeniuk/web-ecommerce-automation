package models;

public class User {

    private final String title;
    private final String fullName;
    private final String email;
    private final String password;
    private final int day;
    private final Month month;
    private final int year;
    private final Address address;

    public User(String title, String fullName, String email, String password, int day, Month month, int year, Address address) {
        this.title = title;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.address = address;
    }

    public String getFullNameName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTitle() {
        return title;
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString(){
        return "User Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "Password: " + password;
    }
}
