package ru.shibaev.bank.model.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import ru.shibaev.bank.data.entities.UserAccountTransaction;
import ru.shibaev.bank.data.repositories.UserAccountTransactionsRepositoy;
import ru.shibaev.bank.data.repositories.UserAccountsRepository;
import ru.shibaev.bank.model.exceptions.UserException;
import ru.shibaev.bank.model.models.UserAccountTransactionOut;

@Component("userAccountTransactionService")
public class UserAccountTransactionService {

    @Autowired
    private UserAccountTransactionsRepositoy userAccountTransactionsRepositoy;

    @Autowired
    private UserAccountsRepository userAccountsRepository;

    public List<UserAccountTransactionOut> getAllTransactions() {
        List<UserAccountTransactionOut> transactionsDtoOut = new ArrayList<>();

        for (var transaction : userAccountTransactionsRepositoy.findAll()) {
            transactionsDtoOut.add(transaction.toDtoOut());
        }

        return transactionsDtoOut;
    }

    public void TransferMoney(UUID fromAccountId, UUID toAccountId, BigDecimal amount) throws UserException {
        if (fromAccountId.compareTo(toAccountId) == 0) {
            throw new UserException("User account IDs must be different", HttpStatus.BAD_REQUEST);
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new UserException("Amount can not be less than or equal to 0", HttpStatus.NOT_FOUND);
        }

        var fromAccountEntity = userAccountsRepository.findById(fromAccountId);
        if (fromAccountEntity.isEmpty()) {
            throw new UserException(String.format("Account with id '%s' does not exists", fromAccountId.toString()),
                    HttpStatus.NOT_FOUND);
        }

        var toAccountFromDb = userAccountsRepository.findById(toAccountId);
        if (toAccountFromDb.isEmpty()) {
            throw new UserException(String.format("Account with id '%s' does not exists", toAccountId.toString()),
                    HttpStatus.NOT_FOUND);
        }

        var fromAccount = fromAccountEntity.get();
        var toAccount = toAccountFromDb.get();

        fromAccount.deductMoney(amount);
        toAccount.addMoney(fromAccount.getCurrency(), amount);

        var newTransaction = new UserAccountTransaction(fromAccountId, toAccountId, amount);
        userAccountTransactionsRepositoy.save(newTransaction);
    }
}
