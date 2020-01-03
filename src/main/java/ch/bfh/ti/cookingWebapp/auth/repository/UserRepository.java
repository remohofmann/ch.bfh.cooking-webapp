package ch.bfh.ti.cookingWebapp.auth.repository;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByMail(String mailAddress);
}
