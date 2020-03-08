package com.health.nutrition.service;

import com.health.nutrition.entity.TFoodTagsEntity;

import java.util.List;

public interface TFoodTagsService {
    public List<TFoodTagsEntity> addFoodTags() throws Exception;

    public List<TFoodTagsEntity> addNewFoodTags(String foodCode) throws Exception;
}
