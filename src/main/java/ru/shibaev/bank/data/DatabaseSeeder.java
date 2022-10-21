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
            var account1 = new UserAccount("RUB", new BigDecimal(100));
            User user1 = new User("user1", "mail1@mail.ru", "Password1", Arrays.asList(account1));
            account1.setUser(user1);

            var account2 = new UserAccount("RUB", new BigDecimal(200));
            User user2 = new User("user2", "mail2@mail.ru", "Password2", Arrays.asList(account2));
            account2.setUser(user2);

            var account3 = new UserAccount("RUB", new BigDecimal(80));
            User user3 = new User("timofei", "timofei@mail.ru", "12qwasZX", Arrays.asList(account3));
            account3.setUser(user3);

            var account4 = new UserAccount("RUB", new BigDecimal(150));
            var account5 = new UserAccount("EUR", new BigDecimal(100));
            User user4 = new User("somaname", "somaname@mail.ru", "12qwasZX",
                    Arrays.asList(account4, account5));
            account4.setUser(user4);
            account5.setUser(user4);

            usersRepository.save(user1);
            usersRepository.save(user2);
            usersRepository.save(user3);
            usersRepository.save(user4);
        }

        System.out.println(usersRepository.count());
    }
}
