package com.codecool.foodswap.service;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        boolean userAlreadyRegister = checkIfEmailExisting(user);
        if (!userAlreadyRegister) {
            userRepository.save(user);
            userRepository.flush();
            System.out.println("Registration DONE");
        } else {
            System.out.println("Registration DENIED");
        }
    }

    public void remove(User user) {
        userRepository.delete(user);
    }

//    public int verifyUser(String email, String password);

    public void addDietType(User user, DietType dietType) {
        User userFromDb = getUserById(user.getId());
        user.addDietType(dietType);
        userRepository.save(userFromDb);

    }
    public User getUserById(int id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return userFromDb.isPresent()? userFromDb.get(): null;
    }

    public void joinGroup(User user, Group group) {
        User userFromDb  = getUserById(user.getId());
        userFromDb.joinGroup(group, true);
    }

    public boolean checkIfEmailExisting(User userWhoWantsToRegister) {
        String email = userWhoWantsToRegister.getEmail();
        User userByEmail = userRepository.findUserByEmail(email);
        if (userByEmail != null) {return true;}
        return false;
    }
}
