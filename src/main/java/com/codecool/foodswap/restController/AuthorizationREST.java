package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.UserRepository;
import com.codecool.foodswap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorizationREST {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private AuthorizationREST (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String startingPage() {
        return "Index Page";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void processRegistrationForm(@RequestBody User registerUser) {
        User newUser = new User(registerUser.getFirstName(), registerUser.getLastName(), registerUser.getEmail(), registerUser.getPassword());
        userService.add(newUser);
    }
}
