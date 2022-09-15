package ru.shibaev.bank.web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.shibaev.bank.model.exceptions.UserException;
import ru.shibaev.bank.model.models.*;
import ru.shibaev.bank.model.services.UserAccountTransactionService;

@RestController
// todo: use global CORS for angular
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class UserAccountTransactionsController {

    @Autowired
    private UserAccountTransactionService userAccountTransactionService;

    @GetMapping("/transactions")
    @ResponseBody
    public Response<List<UserAccountTransactionOut>> getAllTransactions() {
        return Response.Ok(userAccountTransactionService.getAllTransactions());
    }

    @PostMapping("/transactions")
    private Response<Boolean> transferFunds(@RequestBody UserAccountTransactionIn userAccountTransactionIn) {
        try {
            userAccountTransactionService.TransferMoney(userAccountTransactionIn.getFromUserAccountId(),
                    userAccountTransactionIn.getToUserAccountId(), userAccountTransactionIn.getAmount());
            return Response.Ok(true);
        } catch (UserException e) {
            return Response.Fail(false, Arrays.asList(new ResponseError(e.statusCode.toString(), e.getMessage())));
        }
    }
}