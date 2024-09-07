package models.builderss;

import models.User;

public class UserBuilder {

    User user;

    private UserBuilder() {
        user= new User();
    }

    public static UserBuilder with(){
        return new UserBuilder();
    }

    public UserBuilder name(String name){
        this.user.setName(name);
        return this;
    }

    public UserBuilder city(String city){
        this.user.setCity(city);
        return this;
    }

    public UserBuilder country(String country){
        this.user.setCountry(country);
        return this;
    }

    public UserBuilder creditCard(String creditCard){
        this.user.setCreditCard(creditCard);
        return this;
    }

    public UserBuilder month(String month){
        this.user.setMonth(month);
        return this;
    }

    public UserBuilder year(String year){
        this.user.setYear(year);
        return this;
    }

    public User build(){
        return user;
    }
}
