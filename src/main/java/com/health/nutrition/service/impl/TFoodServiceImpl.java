package com.health.nutrition.service.impl;

import com.health.nutrition.entity.TFoodEntity;
import com.health.nutrition.repository.TFoodRepository;
import com.health.nutrition.service.TFoodService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class TFoodServiceImpl implements TFoodService{

    @Autowired
    private TFoodRepository tFoodRepository;


    @Override
    public TFoodEntity getTFoodEntityByCode(String code) throws Exception{
        return tFoodRepository.getTFoodEntityByCode(code);
    }

    @Override
    public Optional<List<TFoodEntity>> findByNameContaining(String foodName) throws  Exception{
        int size = tFoodRepository.findByNameContaining(foodName).map(List::size).orElse(0);
        if (size>0){
            List<TFoodEntity> foodList = tFoodRepository.findByNameContaining(foodName).orElseGet(ArrayList::new);

            for (int i = 0; i<size; i++){
                System.out.println("Field Length: " + foodList.get(1).getClass().getDeclaredFields().length);
            }

            for (Field field : foodList.get(1).getClass().getDeclaredFields()){
                System.out.println("Column Name:"+field.getName());
            }


        }

        return tFoodRepository.findByNameContaining(foodName);
    }

    @Override
    public List<TFoodEntity> getAll() throws Exception{
        return tFoodRepository.findAll();
    }

    @Async
    @Override
    public void task1() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task1任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }

    @Async
    @Override
    public void task2() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(2000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task2任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }
    @Async
    @Override
    public void task3() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(3000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task3任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }

}
