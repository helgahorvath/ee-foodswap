package com.codecool.foodswap.repositories;

import com.codecool.foodswap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);


}
