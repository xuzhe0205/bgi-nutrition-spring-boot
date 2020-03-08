package com.health.nutrition.service.impl;

import com.health.nutrition.entity.TFoodNutrientEntity;
import com.health.nutrition.repository.TFoodNutrientRepository;
import com.health.nutrition.repository.TFoodPurineRepository;
import com.health.nutrition.service.TFoodNutrientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TFoodNutrientServiceImpl implements TFoodNutrientService {

    @Autowired
    private TFoodNutrientRepository tFoodNutrientRepository;


    @Override
    public TFoodNutrientEntity getTFoodNutrientEntityByFoodCodeEquals(String foodCode) throws Exception{
        return tFoodNutrientRepository.getTFoodNutrientEntityByFoodCodeEquals(foodCode);
    }

    @Override
    public List<TFoodNutrientEntity> findAllGIGLFoodCombined() throws Exception{
        return tFoodNutrientRepository.findAllGIGLFoodCombined();
    }

}
