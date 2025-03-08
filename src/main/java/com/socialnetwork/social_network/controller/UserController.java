package com.socialnetwork.social_network.controller;


import com.socialnetwork.social_network.model.User;
import com.socialnetwork.social_network.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }


    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
