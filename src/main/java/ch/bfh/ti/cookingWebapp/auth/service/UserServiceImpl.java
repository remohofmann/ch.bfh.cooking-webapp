package ch.bfh.ti.cookingWebapp.auth.service;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.repository.RoleRepository;
import ch.bfh.ti.cookingWebapp.auth.repository.UserRepository;
import ch.bfh.ti.cookingWebapp.auth.validator.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

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
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }



    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByMail(String mailAddress) {
        return userRepository.findByMail(mailAddress);
    }
}
