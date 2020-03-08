package com.health.nutrition.service.impl;

import com.health.nutrition.entity.*;
import com.health.nutrition.repository.TFoodGiGlRepository;
import com.health.nutrition.repository.TFoodNutrientRepository;
import com.health.nutrition.repository.TFoodPurineRepository;
import com.health.nutrition.repository.TFoodTagsRepository;
import com.health.nutrition.service.TFoodTagsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;


@Log4j2
@Service
public class TFoodTagsServiceImpl implements TFoodTagsService {

    @Autowired
    private TFoodPurineRepository tFoodPurineRepository;

    @Autowired
    private TFoodGiGlRepository tFoodGiGlRepository;

    @Autowired
    private TFoodTagsRepository tFoodTagsRepository;

    @Autowired
    private TFoodNutrientRepository tFoodNutrientRepository;


    @Override
    public List<TFoodTagsEntity> addFoodTags() throws Exception{

        tFoodTagsRepository.deleteAll();


        List<TFoodPurineEntity> tFoodPurineEntityList = tFoodPurineRepository.findAll();
        List<TFoodTagsEntity> tFoodTagsEntityList = new ArrayList<>();
        for (TFoodPurineEntity tFoodPurineEntity : tFoodPurineEntityList){

            if (tFoodPurineEntity.getFoodCode() != null && tFoodPurineEntity.getPurine() != null && tFoodPurineEntity.getFoodCode() != null){
                TFoodTagsEntity tFoodTagsEntity = new TFoodTagsEntity();
                tFoodTagsEntityList.add(manageTag(tFoodTagsEntity, tFoodPurineEntity, null, null));

            }
        }


        List<TFoodGiglEntity> tFoodGiglEntityList = tFoodGiGlRepository.findAllDistinct();
        for (TFoodGiglEntity tFoodGiglEntity : tFoodGiglEntityList){
            if (tFoodGiglEntity.getGl() != null && tFoodGiglEntity.getGi() != null && tFoodGiglEntity.getFoodCode() != null){
                TFoodTagsEntity tFoodTagsEntity = new TFoodTagsEntity();
                tFoodTagsEntityList.add(manageTag(tFoodTagsEntity, null, tFoodGiglEntity,null));
            }
        }

        List<TFoodNutrientEntity> tFoodNutrientEntityList = tFoodNutrientRepository.findAll();
        for (TFoodNutrientEntity tFoodNutrientEntity : tFoodNutrientEntityList) {
            if (tFoodNutrientEntity.getFoodCode() != null && tFoodNutrientEntity.getFat() != null) {
                TFoodTagsEntity tFoodTagsEntity = new TFoodTagsEntity();
                tFoodTagsEntity = manageTag(tFoodTagsEntity, null, null,tFoodNutrientEntity);
                if (tFoodTagsEntity.getFoodTag().equals("")){
                    continue;
                }
                else{
                    tFoodTagsEntityList.add(tFoodTagsEntity);
                }
                tFoodTagsEntityList.add(tFoodTagsEntity);

            }
        }


        tFoodTagsRepository.saveAll(tFoodTagsEntityList);

        return tFoodTagsRepository.findAll();
    }

    @Override
    public List<TFoodTagsEntity> addNewFoodTags(String foodCode) throws Exception{

        List<TFoodPurineEntity> tFoodPurineEntityList = tFoodPurineRepository.findAll();
        for (TFoodPurineEntity tFoodPurineEntity : tFoodPurineEntityList){
            if (tFoodPurineEntity.getFoodCode() != null && tFoodPurineEntity.getPurine() != null && tFoodPurineEntity.getFoodCode() != null){
                if (tFoodPurineEntity.getFoodCode().equals(foodCode)){
                    TFoodTagsEntity tFoodTagsEntity = new TFoodTagsEntity();
                    tFoodTagsRepository.save(manageTag(tFoodTagsEntity, tFoodPurineEntity, null, null));
                    break;
                }
            }
        }


        List<TFoodGiglEntity> tFoodGiglEntityList = tFoodGiGlRepository.findAllDistinct();
        for (TFoodGiglEntity tFoodGiglEntity : tFoodGiglEntityList){
            if (tFoodGiglEntity.getGl() != null && tFoodGiglEntity.getGi() != null && tFoodGiglEntity.getFoodCode() != null){
                if (tFoodGiglEntity.getFoodCode().equals(foodCode)){
                    TFoodTagsEntity tFoodTagsEntity = new TFoodTagsEntity();
                    tFoodTagsRepository.save(manageTag(tFoodTagsEntity, null, tFoodGiglEntity,null));
                    break;
                }
            }
        }


        List<TFoodNutrientEntity> tFoodNutrientEntityList = tFoodNutrientRepository.findAll();
        for (TFoodNutrientEntity tFoodNutrientEntity : tFoodNutrientEntityList){
            if (tFoodNutrientEntity.getFoodCode() != null && tFoodNutrientEntity.getFat() != null){
                if (tFoodNutrientEntity.getFoodCode().equals(foodCode)){
                    TFoodTagsEntity tFoodTagsEntity = new TFoodTagsEntity();
                    tFoodTagsRepository.save(manageTag(tFoodTagsEntity, null, null,tFoodNutrientEntity));
                    break;
                }
            }

        }

        return tFoodTagsRepository.findAll();

    }

    private TFoodTagsEntity manageTag(TFoodTagsEntity tFoodTagsEntity, TFoodPurineEntity tFoodPurineEntity, TFoodGiglEntity tFoodGiglEntity, TFoodNutrientEntity tFoodNutrientEntity){

        if (tFoodPurineEntity != null){
            tFoodTagsEntity.setFoodCode(tFoodPurineEntity.getFoodCode());
            if (tFoodPurineEntity.getPurine() < 25.0){
                tFoodTagsEntity.setFoodTag("低嘌呤");
            }
            else if (tFoodPurineEntity.getPurine() >= 25.0 && tFoodPurineEntity.getPurine() <= 150){
                tFoodTagsEntity.setFoodTag("中嘌呤");
            }
            else{
                tFoodTagsEntity.setFoodTag("高嘌呤");
            }
        }
        else if (tFoodGiglEntity != null){
            tFoodTagsEntity.setFoodCode(tFoodGiglEntity.getFoodCode());
            if (tFoodGiglEntity.getGl() <= 10){

                tFoodTagsEntity.setFoodTag("低血糖负荷");
            }
            else if (tFoodGiglEntity.getGl() > 10 && tFoodGiglEntity.getGl() < 20){
                tFoodTagsEntity.setFoodTag("中血糖负荷");
            }
            else{
                tFoodTagsEntity.setFoodTag("高血糖负荷");
            }
            if (tFoodGiglEntity.getGi() <= 55){
                tFoodTagsEntity.setFoodTag("低升糖指数");
            }
            else if (tFoodGiglEntity.getGl() > 55 && tFoodGiglEntity.getGl() < 70){
                tFoodTagsEntity.setFoodTag("中升糖指数");
            }
            else{
                tFoodTagsEntity.setFoodTag("高升糖指数");
            }
        }
        else if (tFoodNutrientEntity != null){
            tFoodTagsEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
            if (tFoodNutrientEntity.getFat() < 3.0){
                tFoodTagsEntity.setFoodTag("低脂肪");
            }
            else{
                tFoodTagsEntity.setFoodTag("");
            }
        }
        return tFoodTagsEntity;
    }

}
