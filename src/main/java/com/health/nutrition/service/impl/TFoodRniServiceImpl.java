package com.health.nutrition.service.impl;

import com.health.nutrition.entity.TFoodRniEntity;
import com.health.nutrition.entity.UserInfoEntity;
import com.health.nutrition.repository.TFoodRniRepository;
import com.health.nutrition.service.TFoodRniService;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Log4j2
@Service
public class TFoodRniServiceImpl implements TFoodRniService {

    @Autowired
    private TFoodRniRepository tFoodRniRepository;


    @Override
    public List<TFoodRniEntity> getAll(UserInfoEntity userInfoEntity) throws Exception{
        // Assume user is a:
        // Male,
        // 24 y/o (1995-2-5),
        // 177cm tall,
        // 75kg of weight,
        // Non-pregnant,
        // None in healthStatus,
        // Light in activityIntensity,
        // false in isSmoker,
        // Never in alcohol status,
        // No in drugStatus

        System.out.println("test age: "+ageConverter(userInfoEntity.getDob()));

        return tFoodRniRepository.findAll();
    }

    // 此方法：根据身体活动水平来计算该用户的RNI（摄入量）
    @Override
    public TFoodRniEntity getRniByBodyHorizontal(UserInfoEntity userInfoEntity) throws Exception{

        List<TFoodRniEntity> tFoodRniEntityList = new ArrayList<>();

        switch (userInfoEntity.getActivityIntensity()){
            case "轻活动水平":
                tFoodRniEntityList = tFoodRniRepository.getRniByBodyHorizontal((byte)1);
                break;
            case "中活动水平":
                tFoodRniEntityList = tFoodRniRepository.getRniByBodyHorizontal((byte)2);
                break;
            case "重活动水平":
                tFoodRniEntityList = tFoodRniRepository.getRniByBodyHorizontal((byte)3);
                break;
        }


        return filterByAgeAndSex(userInfoEntity,tFoodRniEntityList);

    }

    // 此方法：通过年龄和性别进行筛选从而计算不同人的RNI
    public TFoodRniEntity filterByAgeAndSex(UserInfoEntity userInfoEntity, List<TFoodRniEntity> tFoodRniEntityList) throws Exception{
        TFoodRniEntity resultRniEntity = new TFoodRniEntity();
        double age = ageConverter(userInfoEntity.getDob());
        for (TFoodRniEntity tFoodRniEntity : tFoodRniEntityList){
            if ((tFoodRniEntity.getAgeScope().contains("-"))){
                if ((age > Double.parseDouble(tFoodRniEntity.getAgeScope().split("-")[0])) &&
                        ((age < Double.parseDouble(tFoodRniEntity.getAgeScope().split("-")[1])))){
                    if (userInfoEntity.getSex().equals("男")){
                        if (tFoodRniEntity.getSex() == 0){
                            BeanUtils.copyProperties(tFoodRniEntity,resultRniEntity);
                        }
                    }
                    else{
                        if (tFoodRniEntity.getSex() == 1){
                            BeanUtils.copyProperties(tFoodRniEntity,resultRniEntity);
                        }
                    }
                }
            }
            else{
                if (Double.parseDouble(tFoodRniEntity.getAgeScope()) == age){
                    if (userInfoEntity.getSex().equals("男")){
                        if (tFoodRniEntity.getSex() == 0){
                            BeanUtils.copyProperties(tFoodRniEntity,resultRniEntity);
                        }
                    }
                    else{
                        if (tFoodRniEntity.getSex() == 1){
                            BeanUtils.copyProperties(tFoodRniEntity,resultRniEntity);
                        }
                    }
                }
            }
        }

        if (userInfoEntity.getActivityIntensity().equals("中活动水平")){
            if (age == 0.5){
                resultRniEntity.setEnergy(Double.toString(80*Double.parseDouble(userInfoEntity.getWeight())));
                resultRniEntity.setCho(Double.toString(1.0 - ((Double.parseDouble(resultRniEntity.getProtein())*4)/(80*Double.parseDouble(userInfoEntity.getWeight()))+Double.parseDouble(resultRniEntity.getFat()))));

            }
            else if (age == 0){
                resultRniEntity.setEnergy(Double.toString(90*Double.parseDouble(userInfoEntity.getWeight())));
                resultRniEntity.setCho(Double.toString(1.0 - ((Double.parseDouble(resultRniEntity.getProtein())*4)/(90*Double.parseDouble(userInfoEntity.getWeight()))+Double.parseDouble(resultRniEntity.getFat()))));

            }

        }

        return resultRniEntity;
    }

    // 此方法：给孕妇计算RNI
    @Override
    public TFoodRniEntity getRniByFactor(UserInfoEntity userInfoEntity) throws Exception{
        TFoodRniEntity resultRniEntity = new TFoodRniEntity();
        switch (userInfoEntity.getPregnancyStatus()){
            case "孕期（早）":
                switch (userInfoEntity.getActivityIntensity()){
                    case "轻活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)1, (byte)1);
                        break;
                    case "中活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)2, (byte)1);
                        break;
                    case "重活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)3, (byte)1);
                        break;
                }
                break;
            case "孕期（中）":
                switch (userInfoEntity.getActivityIntensity()){
                    case "轻活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)1, (byte)2);
                        break;
                    case "中活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)2, (byte)2);
                        break;
                    case "重活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)3, (byte)2);
                        break;
                }
                break;
            case "孕期（晚）":
                switch (userInfoEntity.getActivityIntensity()){
                    case "轻活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)1, (byte)3);
                        break;
                    case "中活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)2, (byte)3);
                        break;
                    case "重活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)3, (byte)3);
                        break;
                }
                break;
            case "乳母":
                switch (userInfoEntity.getActivityIntensity()){
                    case "轻活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)1, (byte)4);
                        break;
                    case "中活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)2, (byte)4);
                        break;
                    case "重活动水平":
                        resultRniEntity = tFoodRniRepository.getRniByFactor((byte)3, (byte)4);
                        break;
                }
                break;
        }
        System.out.println("rniImpl test: "+resultRniEntity.getEnergy());
        return resultRniEntity;
    }

    // 此方法：用于根据用户保存的ta的生日（yyyy/mm/dd）来计算/转换成具体年龄
    public double ageConverter(String userDob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dob= sdf.parse(userDob);
        Calendar c = Calendar.getInstance();
        c.setTime(dob);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate localDob = LocalDate.of(year, month, date);
        LocalDate  currentDate = LocalDate.now();
        if ((Period.between(localDob, currentDate)).getYears() >= 1){
            return (double)(Period.between(localDob, currentDate)).getYears();
        }
        else{
            if ((Period.between(localDob, currentDate)).getMonths()>=6){
                System.out.println("test age converter: " + (Period.between(localDob, currentDate)).getMonths());

                return 0.5;
            }
            else{
                return 0.0;
            }
        }
    }

}
