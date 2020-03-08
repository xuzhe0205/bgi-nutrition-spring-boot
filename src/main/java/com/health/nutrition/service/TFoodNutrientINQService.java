package com.health.nutrition.service;

import com.health.nutrition.entity.TFoodNutrientInqEntity;
import com.health.nutrition.entity.TFoodRniEntity;
import com.health.nutrition.entity.UserInfoEntity;

import java.util.ArrayList;
import java.util.List;

public interface TFoodNutrientINQService {
    public void findFoodNutrientINQ(TFoodRniEntity tFoodRniEntity, UserInfoEntity userInfoEntity) throws Exception;

    public List<TFoodNutrientInqEntity> findFoodNutrientINQByPage(int from, int to, String category, String keyword) throws Exception;


}
