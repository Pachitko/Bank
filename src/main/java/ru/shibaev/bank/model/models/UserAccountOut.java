package ru.shibaev.bank.model.models;

import java.math.BigDecimal;

public class UserAccountOut {

    // todo how to use UPPER c. for java public and l. case for frontend dtoIn props
    public BigDecimal money;
    public String currency;

    public UserAccountOut(BigDecimal money, String currency) {
        this.money = money;
        this.currency = currency;
    }
}
