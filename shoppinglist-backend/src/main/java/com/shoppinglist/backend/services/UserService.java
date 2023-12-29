package com.shoppinglist.backend.services;

import com.shoppinglist.backend.models.DTOs.LoginUserDTO;
import com.shoppinglist.backend.models.DTOs.NewUserDTO;
import com.shoppinglist.backend.models.User;

public interface UserService {
    User findUserByUsername(String username);

    User createNewUser(NewUserDTO userData);

    User loginUser(LoginUserDTO loginData);
}
