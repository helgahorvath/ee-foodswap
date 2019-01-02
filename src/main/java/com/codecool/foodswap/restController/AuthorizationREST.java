package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationREST {

    private UserRepository userRepository;

    private AuthorizationREST (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String startingPage() {
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam User user) {
        userRepository.save(user);
        return ;

    }
}
