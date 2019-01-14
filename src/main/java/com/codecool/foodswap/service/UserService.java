package com.codecool.foodswap.service;

import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
        userRepository.flush();
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

 //   public boolean checkIfEmailExisting(String email);
}
