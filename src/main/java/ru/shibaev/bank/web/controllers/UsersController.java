package ru.shibaev.bank.web.controllers;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.shibaev.bank.model.exceptions.UserException;
import ru.shibaev.bank.model.models.*;
import ru.shibaev.bank.model.services.UserAccountTransactionService;
import ru.shibaev.bank.model.services.UserManager;

@RestController
// todo: use global CORS for angular
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class UsersController {

    @Autowired
    private UserAccountTransactionService userAccountTransactionService;

    @Autowired
    private UserManager userManager;

    @GetMapping("/users")
    @ResponseBody
    public Response<List<UserOut>> getAllUsers() {
        return Response.Ok(userManager.getAllUsers());
    }

    @PostMapping("/users")
    private void addUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        userManager.createUser(userRegistrationDto);
    }

    @PostMapping("/transfers")
    private Response<Boolean> transferFunds(UUID userId, UUID fromAccountId, UUID toAccountId, BigDecimal amount) {
        try {
            userAccountTransactionService.TransferMoney(userId, fromAccountId, toAccountId, amount);
            return Response.Ok(true);
        } catch (UserException e) {
            List<ResponseError> errors = Arrays.asList(new ResponseError(e.statusCode.toString(), e.getMessage()));
            return Response.Fail(false, errors);
        }
    }
}