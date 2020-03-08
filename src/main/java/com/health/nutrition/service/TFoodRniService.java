package com.health.nutrition.service;

import com.health.nutrition.entity.TFoodRniEntity;
import com.health.nutrition.entity.UserInfoEntity;

import java.util.List;

public interface TFoodRniService {
    public List<TFoodRniEntity> getAll(UserInfoEntity userInfoEntity) throws Exception;

    public TFoodRniEntity getRniByBodyHorizontal(UserInfoEntity userInfoEntity) throws Exception;

    public TFoodRniEntity getRniByFactor(UserInfoEntity userInfoEntity) throws Exception;

}
