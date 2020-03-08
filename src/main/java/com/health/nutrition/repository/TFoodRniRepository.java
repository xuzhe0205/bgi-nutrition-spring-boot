package com.health.nutrition.repository;

import com.health.nutrition.entity.TFoodRniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TFoodRniRepository extends JpaRepository<TFoodRniEntity, Long> {

    @Query(value = "SELECT * FROM t_food_rni WHERE body_horizontal = :bodyHorizontal AND factor = :factor", nativeQuery = true)
    TFoodRniEntity getRniByFactor(@Param("bodyHorizontal") byte bodyHorizontal, @Param("factor") byte factor);

    @Query(value = "SELECT * FROM t_food_rni WHERE body_horizontal = :bodyHorizontal AND factor IS NULL AND energy IS NOT NULL",nativeQuery = true)
    List<TFoodRniEntity> getRniByBodyHorizontal(@Param("bodyHorizontal") byte bodyHorizontal);



}
