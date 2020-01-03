package ch.bfh.ti.cookingWebapp.auth.service;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.validator.UserRegistrationDto;

public interface UserService {
    void save(UserRegistrationDto user);

    User findByUsername(String username);

    User findByMail(String mailAddress);
}
