package com.health.nutrition.service;

import com.health.nutrition.entity.TFoodEntity;

import java.util.List;
import java.util.Optional;

public interface TFoodService {

    /**
     *通过食材CODE查找食材
     * @param code
     * @return
     */
    public TFoodEntity getTFoodEntityByCode(String code) throws Exception;

    public Optional<List<TFoodEntity>> findByNameContaining(String foodName) throws Exception;

    public List<TFoodEntity> getAll() throws Exception;
    public void task1() throws InterruptedException;
    public void task2() throws InterruptedException;
    public void task3() throws InterruptedException;

}

