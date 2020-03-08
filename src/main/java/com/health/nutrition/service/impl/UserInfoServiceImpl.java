package com.health.nutrition.service.impl;

import com.health.nutrition.entity.UserInfoEntity;
import com.health.nutrition.service.UserInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserInfoServiceImpl implements UserInfoService {


    // 此方法： 用于根据逻辑来解析出当前用户的特征标签，比如他身体属于Normal(正常) 或者Overweight(超重) 或者Obese(肥胖)
    @Override
    public UserInfoEntity manageUserInfoTags(UserInfoEntity userInfoEntity) throws Exception{
        Double bmi = Double.parseDouble(userInfoEntity.getWeight())/((Math.pow(Double.parseDouble(userInfoEntity.getHeight())/100,2)));
        TFoodRniServiceImpl tFoodRniServiceImpl = new TFoodRniServiceImpl();
        System.out.println("Check my bmi: " + bmi);
        if (bmi >= 18.5 && bmi < 24){
            userInfoEntity.addTags("Normal");
        }
        else if (bmi >= 24 && bmi < 28){
            userInfoEntity.addTags("Overweight");
        }
        else if (bmi >= 28){
            userInfoEntity.addTags("Obese");
        }

        return userInfoEntity;
    }
}
