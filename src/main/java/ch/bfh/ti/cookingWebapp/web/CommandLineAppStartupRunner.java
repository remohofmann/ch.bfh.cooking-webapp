package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.repository.UserRepository;
import ch.bfh.ti.cookingWebapp.auth.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public void run(String...args) throws Exception {
        userServiceImpl.createAdmin();
    }
}