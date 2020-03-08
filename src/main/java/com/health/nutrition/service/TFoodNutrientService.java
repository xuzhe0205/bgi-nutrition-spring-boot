package com.health.nutrition.service;

import com.health.nutrition.entity.TFoodNutrientEntity;

import java.util.List;

public interface TFoodNutrientService {

    public TFoodNutrientEntity getTFoodNutrientEntityByFoodCodeEquals(String foodCode) throws Exception;

    public List<TFoodNutrientEntity> findAllGIGLFoodCombined() throws Exception;


}
