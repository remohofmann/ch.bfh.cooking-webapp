package ch.bfh.ti.cookingWebapp.auth.service;

import ch.bfh.ti.cookingWebapp.auth.model.Role;
import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.repository.RoleRepository;
import ch.bfh.ti.cookingWebapp.auth.repository.UserRepository;
import ch.bfh.ti.cookingWebapp.auth.validator.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private Set<Role> userSet;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserRegistrationDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setMail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        Set<Role> userSet = new HashSet<>();
        Role role = roleRepository.findByName("USER");
        userSet.add(role);
        user.setRoles(userSet);
        userRepository.save(user);
    }

    public Set<Role> getUserSet() {
        return this.userSet;
    }

    public void createAdmin() {
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role adminRoleSaved = roleRepository.saveAndFlush(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        Role userRoleSaved = roleRepository.saveAndFlush(userRole);

        User user = new User();
        user.setUsername("admin");
        user.setMail("admin@admin");
        user.setFirstName("Admin");
        user.setLastName("Istrator");
        user.setPassword(bCryptPasswordEncoder.encode("supersecret!"));
        Set<Role> adminSet = new HashSet<>();
        adminSet.add(adminRoleSaved);
        adminSet.add(userRoleSaved);
        user.setRoles(adminSet);
        userRepository.save(user);

        Set<Role> userSet = new HashSet<>();
        userSet.add(userRoleSaved);
        this.userSet = userSet;

        User anyUser = new User();
        anyUser.setUsername("dude");
        anyUser.setMail("user@user");
        anyUser.setFirstName("Normal");
        anyUser.setLastName("Dude");
        anyUser.setPassword(bCryptPasswordEncoder.encode("dude"));
        anyUser.setRoles(userSet);
        userRepository.save(anyUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByMail(String mailAddress) {
        return userRepository.findByMail(mailAddress);
    }

    //ADMIN commands
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.removeIf(u -> u.getUsername().equals("admin"));
        return users;
    }

    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }
}
