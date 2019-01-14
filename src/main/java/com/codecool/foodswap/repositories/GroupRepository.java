package com.codecool.foodswap.repositories;

import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<Group> findAllByName(String name);

}
