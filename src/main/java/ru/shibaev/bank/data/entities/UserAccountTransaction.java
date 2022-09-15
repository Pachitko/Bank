package ru.shibaev.bank.data.entities;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.*;

import lombok.Getter;
import ru.shibaev.bank.model.models.UserAccountTransactionOut;

@Entity
@Table(name = "user_account_transactions")
public class UserAccountTransaction {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private UUID fromUserAccountId;

    @Getter
    private UUID toUserAccountId;

    @Getter
    private BigDecimal amount;

    public UserAccountTransaction() {
    }

    public UserAccountTransaction(UUID fromUserAccountId, UUID toUserAccountId, BigDecimal amount) {
        this.fromUserAccountId = fromUserAccountId;
        this.toUserAccountId = toUserAccountId;
        this.amount = amount;
    }

    public UserAccountTransactionOut toDtoOut() {
        return new UserAccountTransactionOut(fromUserAccountId, toUserAccountId, amount);
    }
}
