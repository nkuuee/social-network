package com.socialnetwork.social_network.service;

import com.socialnetwork.social_network.model.User;
import com.socialnetwork.social_network.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserById(long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(user1 -> "Пользователь " + user1 + " найден")
                .orElse("Пользователь не найден");
    }

    @PostMapping("")
    public User addUser(User user) {
        return userRepository.save(user);
    }

}
