package com.health.nutrition.repository;

import com.health.nutrition.entity.TFoodGiglEntity;
import com.health.nutrition.entity.TFoodNutrientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TFoodGiGlRepository extends JpaRepository<TFoodGiglEntity, Long> {

    @Query(value = "SELECT * FROM t_food_gigl GROUP BY t_food_gigl.food_code ORDER BY t_food_gigl.gl ASC, t_food_gigl.gi ASC", nativeQuery = true)
    List<TFoodGiglEntity> findAllSorted();

    @Query(value = "SELECT * FROM t_food_gigl GROUP BY food_code", nativeQuery = true)
    List<TFoodGiglEntity> findAllDistinct();
}
