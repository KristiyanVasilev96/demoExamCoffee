package com.example.demoexamcoffee.service.impl;

import com.example.demoexamcoffee.model.entity.User;
import com.example.demoexamcoffee.model.services.UserServiceModel;
import com.example.demoexamcoffee.model.view.UserViewModel;
import com.example.demoexamcoffee.repository.UserRepository;
import com.example.demoexamcoffee.sec.CurrentUser;
import com.example.demoexamcoffee.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByUserNameAndPassword(String password, String username) {
        return userRepository.findByUsernameAndPassword(password, username)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);

    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOfOrderByCountDesc() {
        return userRepository.findAllByOrderByOrdersDesc().stream().map(user -> {
            UserViewModel userViewModel=new UserViewModel();
            userViewModel.setUsername(user.getUsername());
            userViewModel.setCountOfOrders(user.getOrders().size());

            return userViewModel ;
        }).collect(Collectors.toList());
    }
}
