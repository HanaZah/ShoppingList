package com.shoppinglist.backend.services;

import com.shoppinglist.backend.models.DTOs.LoginUserDTO;
import com.shoppinglist.backend.models.DTOs.NewUserDTO;
import com.shoppinglist.backend.models.User;
import com.shoppinglist.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsernameAndDeleted(username, false).orElse(null);
    }

    @Override
    public User createNewUser(NewUserDTO userData) {

        String username = userData.getUsername();

        if(findUserByUsername(username) != null) {
            return null;
        }

        String password = passwordEncoder.encode(userData.getPassword());
        User newUser = new User(username, password);

        return userRepository.save(newUser);
    }

    @Override
    public User loginUser(LoginUserDTO loginData) {
        User user = userRepository.findUserByUsernameAndDeleted(loginData.getUsername(), false)
                .orElse(null);

        if(user != null && passwordEncoder.matches(loginData.getPassword(), user.getPassword())) {
            return user;
        }

        return null;
    }
}
