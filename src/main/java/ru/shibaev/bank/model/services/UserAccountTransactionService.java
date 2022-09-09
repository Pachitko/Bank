package ru.shibaev.bank.model.services;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import ru.shibaev.bank.data.entities.UserAccountTransaction;
import ru.shibaev.bank.data.repositories.UserAccountTransactionsRepositoy;
import ru.shibaev.bank.data.repositories.UserAccountsRepository;
import ru.shibaev.bank.model.exceptions.UserException;

@Component("userAccountTransactionService")
public class UserAccountTransactionService {

    @Autowired
    private UserAccountTransactionsRepositoy userAccountTransactionsRepositoy;

    @Autowired
    private UserAccountsRepository userAccountsRepository;

    public void TransferMoney(UUID userId, UUID fromAccountId, UUID toAccountId, BigDecimal amount)
            throws UserException {
        if (fromAccountId.compareTo(toAccountId) == 0)
            throw new UserException("User account IDs must be different", HttpStatus.BAD_REQUEST);

        var userAccountFromDb = userAccountsRepository.findById(fromAccountId);
        if (userAccountFromDb.isEmpty())
            throw new UserException(
                    String.format("Account with id '%s' does not exists", fromAccountId.toString()),
                    HttpStatus.NOT_FOUND);

        var toAccountFromDb = userAccountsRepository.findById(toAccountId);
        if (toAccountFromDb.isEmpty())
            throw new UserException(
                    String.format("Account with id '%s' does not exists", toAccountId.toString()),
                    HttpStatus.NOT_FOUND);

        var fromAccount = userAccountFromDb.get();
        if (fromAccount.getUser().getId() != userId)
            throw new UserException(
                    String.format("From account id does not match with provided user id"), HttpStatus.BAD_REQUEST);

        var toAccount = toAccountFromDb.get();

        fromAccount.deductMoney(amount);
        toAccount.addMoney(fromAccount.getCurrency(), amount);

        var newTransaction = new UserAccountTransaction(fromAccountId, toAccountId);
        userAccountTransactionsRepositoy.save(newTransaction);
    }
}
