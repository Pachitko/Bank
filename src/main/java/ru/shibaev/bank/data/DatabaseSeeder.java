package ru.shibaev.bank.data;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ru.shibaev.bank.data.entities.*;
import ru.shibaev.bank.data.repositories.UsersRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }

    private void seedDatabase() {
        if (usersRepository.count() == 0) {
            var user1Account = new UserAccount("RUB", new BigDecimal(100));
            User user1 = new User("user1", "mail1@mail.ru", "Password1", Arrays.asList(user1Account));
            user1Account.setUser(user1);

            var user2Account = new UserAccount("RUB", new BigDecimal(200));
            User user2 = new User("user2", "mail2@mail.ru", "Password2", Arrays.asList(user2Account));
            user2Account.setUser(user2);

            usersRepository.save(user1);
            usersRepository.save(user2);
        }

        System.out.println(usersRepository.count());
    }
}
