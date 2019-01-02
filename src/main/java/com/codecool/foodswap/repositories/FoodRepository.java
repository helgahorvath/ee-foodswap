package com.codecool.foodswap.repositories;

import com.codecool.foodswap.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
