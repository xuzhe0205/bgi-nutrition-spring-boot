package com.health.nutrition.repository;

import com.health.nutrition.entity.TFoodNutrientEntity;
import com.health.nutrition.entity.TFoodPurineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TFoodPurineRepository extends JpaRepository<TFoodPurineEntity, Long> {



}
