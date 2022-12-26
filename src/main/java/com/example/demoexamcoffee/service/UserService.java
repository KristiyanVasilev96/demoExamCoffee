package com.example.demoexamcoffee.service;

import com.example.demoexamcoffee.model.entity.User;
import com.example.demoexamcoffee.model.services.UserServiceModel;
import com.example.demoexamcoffee.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUserNameAndPassword(String password, String username);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrderByCountDesc();
}
