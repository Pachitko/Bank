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
    @ManyToOne
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
}
