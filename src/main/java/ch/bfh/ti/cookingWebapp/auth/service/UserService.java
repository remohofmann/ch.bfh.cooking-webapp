package ch.bfh.ti.cookingWebapp.auth.service;

import ch.bfh.ti.cookingWebapp.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
