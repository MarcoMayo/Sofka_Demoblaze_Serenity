package data;

import com.github.javafaker.Faker;
import models.User;
import models.builderss.UserBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataUser {

    private static final Faker faker = new Faker();

    public static User newUser(){
        Date date = faker.date().future(5000, TimeUnit.DAYS);
        return UserBuilder.with()
                .name(faker.name().firstName())
                .country(faker.country().name())
                .city(faker.country().capital())
                .creditCard(String.valueOf(faker.number().randomNumber(10, true)))
                .month(String.valueOf(1 + date.getMonth()))
                .year(String.valueOf(1900 + date.getYear()))
                .build();
    }

}
