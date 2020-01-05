package ch.bfh.ti.cookingWebapp.auth.repository;

import ch.bfh.ti.cookingWebapp.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
