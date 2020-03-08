package com.health.nutrition.repository;

import com.health.nutrition.entity.TFoodNutrientEntity;
import io.swagger.annotations.ApiParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TFoodNutrientRepository extends JpaRepository<TFoodNutrientEntity,Long> {
    List<TFoodNutrientEntity> findByFoodNameContaining(String foodName);

    @Query(value = "SELECT food_name, energy, protein, dietary_fiber FROM t_food_nutrient WHERE t_food_nutrient.food_name LIKE CONCAT('%', :foodName, '%')", nativeQuery = true)
    List<Object[]> findSpecificNutrientByFoodName(@Param("foodName") String foodName);

    TFoodNutrientEntity getTFoodNutrientEntityByFoodCodeEquals(String foodCode);

    @Query(value = "SELECT tfn.* FROM t_food_nutrient tfn LEFT JOIN (SELECT * FROM t_food_gigl GROUP BY t_food_gigl.food_code ) tfg ON (tfn.food_code = tfg.food_code) \n" +
            "WHERE tfg.gl IS NOT NULL AND tfg.gi IS NOT NULL AND tfg.food_code IS NOT NULL\n" +
            "ORDER BY tfg.gl ASC, tfg.gi ASC", nativeQuery = true)
    List<TFoodNutrientEntity> findAllGIGLFoodCombined();

    @Query(value = "SELECT tfn.* FROM t_food_nutrient tfn LEFT JOIN t_food_purine tfp ON tfn.food_code = tfp.food_code\n" +
            "WHERE tfp.purine IS NOT NULL\n" +
            "ORDER BY tfp.purine ASC", nativeQuery = true)
    List<TFoodNutrientEntity> findAllPurineFoodCombined();






}


