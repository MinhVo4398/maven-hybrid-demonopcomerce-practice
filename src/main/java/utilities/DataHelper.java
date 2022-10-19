package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);

    public static DataHelper getDataHelper() {
        return new DataHelper();

    }


    public String getFirstName() {
        return faker.address().firstName();
    }

    public String getLastName() {
        return faker.address().lastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getCtityName() {
        return faker.address().city();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    //Number / Text / Special
    public String getPassword() {
        return faker.internet().password();
    }

    public String getCompanyName() {
        return faker.company().name();

    }

    public String getZipCode() {
        return faker.address().zipCode();

    }

    public String getCountry() {
        return faker.country().name();

    }

}
