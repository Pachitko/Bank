package ru.shibaev.bank.data.entities;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import ru.shibaev.bank.model.models.UserAccountOut;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Getter
    private BigDecimal money;

    @Getter
    private String currency;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserAccount() {
    }

    public UserAccount(String currency, BigDecimal money) {
        this.currency = currency;
        this.money = money;
    }

    public UserAccountOut toDto() {
        return new UserAccountOut(money, currency);
    }

    public void deductMoney(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(
                    String.format("Amount of money to deduct cann't be less or equal than 0", amount));

        if (this.money.compareTo(amount) < 0)
            throw new IllegalArgumentException("Not enough money to transfer");

        money = money.subtract(amount);
    }

    public void addMoney(String currency, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(
                    String.format("Amount of money to add cann't be less or equal than 0", amount));

        if (!this.currency.equalsIgnoreCase(currency))
            throw new IllegalArgumentException(
                    String.format("Currencies \"%s\" and \"%s\" do not match", this.currency, currency));

        money = money.add(amount);
    }
}
