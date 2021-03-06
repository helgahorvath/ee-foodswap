package com.codecool.foodswap.restController;

import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.UserRepository;
import org.springframework.stereotype.Component;

import com.codecool.foodswap.service.UserService;
import com.codecool.foodswap.util.Bcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Component
public class AuthorizationREST{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public AuthorizationREST (UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void processRegistrationForm(@RequestBody User registerUser) {
        User newUser = new User(registerUser.getFirstName(), registerUser.getLastName(), registerUser.getEmail(), Bcrypt.hashPassword(registerUser.getPassword()));
        userService.add(newUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@RequestBody User loginUser) {
        User userByEmailFromDB = userRepository.findUserByEmail(loginUser.getEmail());
        boolean verifyPassword = Bcrypt.verifyPassword(loginUser.getPassword(), userByEmailFromDB.getPassword());
        if (verifyPassword) {
            System.out.println("Login Successful");
            return "Login Successful";
        }
        System.out.println("Login Failed");
        return "Login Failed";
    }
}
