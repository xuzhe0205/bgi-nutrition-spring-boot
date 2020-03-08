package com.health.nutrition.service.impl;

import com.health.nutrition.common.util.CustomComparators;
import com.health.nutrition.entity.*;
import com.health.nutrition.repository.*;
import com.health.nutrition.service.TFoodNutrientINQService;
import com.health.nutrition.service.TFoodNutrientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Log4j2
@Service
public class TFoodNutrientINQServiceImpl implements TFoodNutrientINQService {


    @Autowired
    private TFoodFattyacidRepository tFoodFattyacidRepository;


    @Autowired
    private TFoodNutrientService tFoodNutrientService;

    @Autowired
    private TFoodNutrientRepository tFoodNutrientRepository;

    @Autowired
    private TInqRepository tInqRepository;

    @Autowired
    private TFoodRepository tFoodRepository;

    private List<TFoodNutrientInqEntity> tFoodNutrientInqEntityList = new ArrayList<>();

    // 此方法 根据入参"userInfoEntity"的用户身体以及健康状况给 `t_food_nutrient` table 里的数据先进行排序
    // 然后通过反射以及公式 计算得出各食材各营养素的INQ值，并调用执行 `sortFoodNutrientINQByConditions` 方法来根据不同人群给食材排序，
    // 最后保存到数据库中的`t_inq`表
    // 此方法较接口 `logUserAndSaveFoodINQ` 进行一个异步处理
    @Async
    @Override
    public void findFoodNutrientINQ(TFoodRniEntity tFoodRniEntity, UserInfoEntity userInfoEntity) throws Exception{
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("waawawawawwaw");
        List<TFoodNutrientEntity> tFoodNutrientEntityList = new ArrayList<>();

        if (userInfoEntity.getHealthStatus().contains("高血糖")){
            tFoodNutrientEntityList = tFoodNutrientService.findAllGIGLFoodCombined();
        }
        else if (userInfoEntity.getHealthStatus().contains("高尿酸")){
            tFoodNutrientEntityList = tFoodNutrientRepository.findAllPurineFoodCombined();
        }
        else{
            tFoodNutrientEntityList = tFoodNutrientRepository.findAll();
        }

        List<TFoodNutrientInqEntity> tFoodNutrientInqEntityList = new ArrayList<>();

        for (TFoodNutrientEntity tFoodNutrientEntity : tFoodNutrientEntityList){
            TFoodNutrientInqEntity tFoodNutrientInqEntity = new TFoodNutrientInqEntity();
            Class<?> clz = tFoodNutrientEntity.getClass();
            Field[] fields = clz.getDeclaredFields();
            Double nutrientEnergy = 0.0;
            for (Field field : fields){

                // If field type is Double, that field is a field of nutrient
                if (field.getGenericType().toString().equals(
                        "class java.lang.Double")) {
                    Method m = (Method) clz.getMethod(
                            "get" + getMethodName(field.getName()));
                    Double val = (Double) m.invoke(tFoodNutrientEntity);
                    if (field.getName() == "energy"){
                        if (val == null || val==0){
                            break;
                        }
                        nutrientEnergy = val;
                    }
                    else{
                        if (val != null && val!=0) {
                            for (Field fieldRni : tFoodRniEntity.getClass().getDeclaredFields()){
                                if (fieldRni.getName() == field.getName()){
                                    if (fieldRni.getName() == "fat"){
                                        try{
                                            // 反射目标对象
                                            TInqEntity tInqEntity = new TInqEntity();
                                            tInqEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            tInqEntity.setNutrientName("fat");
                                            tInqEntity.setFoodName(tFoodNutrientEntity.getFoodName());
                                            tInqEntity.setCustomerId(userInfoEntity.getId());
                                            Double inq = ((val/(Double.parseDouble(tFoodRniEntity.getEnergy())*(Double.parseDouble(tFoodRniEntity.getFat()))/9))/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntity.setInq(inq);
                                            }

                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntity);
                                        }
                                        catch (Exception e){
                                            // 反射目标对象
                                            TInqEntity tInqEntity = new TInqEntity();
                                            // fat参考值最小值
                                            tInqEntity.setNutrientName("fatLow");
                                            tInqEntity.setCustomerId(userInfoEntity.getId());
                                            tInqEntity.setFoodName(tFoodNutrientEntity.getFoodName());
                                            tInqEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            Double inq = ((val/(Double.parseDouble(tFoodRniEntity.getEnergy())*0.2/9))/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntity.setInq(inq);
                                            }
                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntity);

                                            // fat参考值最大值
                                            // 反射目标对象
                                            TInqEntity tInqEntityHigh = new TInqEntity();
                                            tInqEntityHigh.setNutrientName("fatHigh");
                                            tInqEntityHigh.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            tInqEntityHigh.setFoodName(tFoodNutrientEntity.getFoodName());
                                            tInqEntityHigh.setCustomerId(userInfoEntity.getId());
                                            inq = ((val/(Double.parseDouble(tFoodRniEntity.getEnergy())*0.3/9))/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntityHigh.setInq(inq);
                                            }
                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntityHigh);

                                        }

                                    }
                                    else if (fieldRni.getName() == "cho"){
                                        System.out.println("Did I go in?");

                                        try{
                                            // 反射目标对象
                                            TInqEntity tInqEntity = new TInqEntity();
                                            tInqEntity.setNutrientName("cho");
                                            tInqEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            tInqEntity.setFoodName(tFoodNutrientEntity.getFoodName());
                                            tInqEntity.setCustomerId(userInfoEntity.getId());
                                            System.out.println("check INQ cho %E: " + tFoodRniEntity.getCho());
                                            Double inq = ((val/(Double.parseDouble(tFoodRniEntity.getEnergy())*(Double.parseDouble(tFoodRniEntity.getCho()))/4))/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntity.setInq(inq);
                                            }
                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntity);
                                        }
                                        catch (Exception e){
                                            // 反射目标对象
                                            TInqEntity tInqEntity = new TInqEntity();
                                            // cho参考值最小值
                                            tInqEntity.setNutrientName("choLow");
                                            tInqEntity.setCustomerId(userInfoEntity.getId());
                                            tInqEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            tInqEntity.setFoodName(tFoodNutrientEntity.getFoodName());
                                            Double inq = ((val/(Double.parseDouble(tFoodRniEntity.getEnergy())*0.5/4))/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntity.setInq(inq);
                                            }
                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntity);

                                            // cho参考值最大值
                                            // 反射目标对象
                                            TInqEntity tInqEntityHigh = new TInqEntity();
                                            tInqEntityHigh.setNutrientName("choHigh");
                                            tInqEntityHigh.setCustomerId(userInfoEntity.getId());
                                            tInqEntityHigh.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            tInqEntityHigh.setFoodName(tFoodNutrientEntity.getFoodName());
                                            inq = ((val/(Double.parseDouble(tFoodRniEntity.getEnergy())*0.65/4))/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntityHigh.setInq(inq);
                                            }
                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntityHigh);
                                        }


                                    }
                                    else{
                                        Method m2 = tFoodRniEntity.getClass().getMethod("get"+getMethodName(fieldRni.getName()));
                                        Double valRni = Double.parseDouble((String) m2.invoke(tFoodRniEntity));
                                        // 反射目标对象
                                        TInqEntity tInqEntity = new TInqEntity();
                                        if (fieldRni.getName() != "energy"){
                                            tInqEntity.setNutrientName(fieldRni.getName());
                                            tInqEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
                                            tInqEntity.setFoodName(tFoodNutrientEntity.getFoodName());
                                            tInqEntity.setCustomerId(userInfoEntity.getId());
                                            Double inq = ((val/valRni)/nutrientEnergy)*Double.parseDouble(tFoodRniEntity.getEnergy());
                                            if (!Double.isNaN(inq) && !Double.isInfinite(inq)){
                                                tInqEntity.setInq(inq);
                                            }
                                            tFoodNutrientInqEntity.addNutrientInqEntityList(tInqEntity);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (nutrientEnergy != 0.0){
                if (tFoodNutrientEntity.getCholesterol() != null){
                    tFoodNutrientInqEntity.setCholesterol(tFoodNutrientEntity.getCholesterol());
                }
                tFoodNutrientInqEntity.setFoodCode(tFoodNutrientEntity.getFoodCode());
                tFoodNutrientInqEntity.setFoodName(tFoodNutrientEntity.getFoodName());
                tFoodNutrientInqEntityList.add(tFoodNutrientInqEntity);
            }

        }




        this.tFoodNutrientInqEntityList = sortFoodNutrientINQByConditions(userInfoEntity, tFoodNutrientInqEntityList);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("解析INQ任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }

    // 此方法 根据不同人群来给解析好inq的食材列表排序，最后保存到数据库中的`t_inq`表里
    public List<TFoodNutrientInqEntity> sortFoodNutrientINQByConditions(UserInfoEntity userInfoEntity, List<TFoodNutrientInqEntity> tFoodNutrientInqEntityList) throws Exception{

        if (userInfoEntity.getPregnancyStatus().equals("孕期（早）")){

            for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
                Double folicAcidIINQ = 0.0;
                for (TInqEntity tInqEntity : tFoodNutrientInqEntity.getNutrientInqEntityList()){
                    if (tInqEntity.getNutrientName().equals("folidAcid") || tInqEntity.getNutrientName().equals("i")) {
                        if (tInqEntity.getInq() != null) {
                            folicAcidIINQ += tInqEntity.getInq();
                        }
                    }
                }
                tFoodNutrientInqEntity.setFolicAcidI(folicAcidIINQ);

            }
            Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodPregnantEarlyComparator);
        }

        else if (userInfoEntity.getPregnancyStatus().equals("孕期（中）") || userInfoEntity.getPregnancyStatus().equals("孕期（晚）")){
            for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
                Double feCaIINQ = 0.0;
                for (TInqEntity tInqEntity : tFoodNutrientInqEntity.getNutrientInqEntityList()){
                    if (tInqEntity.getNutrientName().equals("fe") || tInqEntity.getNutrientName().equals("i")|| tInqEntity.getNutrientName().equals("ca")) {
                        if (tInqEntity.getInq() != null) {
                            feCaIINQ += tInqEntity.getInq();
                        }
                    }
                }
                tFoodNutrientInqEntity.setFeCaI(feCaIINQ);

            }
            Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodPregnantMediumLateComparator.thenComparing(CustomComparators.foodNaComparator));
        }

        else if (userInfoEntity.getPregnancyStatus().equals("乳母")){
            for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
                Double vitaACaProteinIINQ = 0.0;
                for (TInqEntity tInqEntity : tFoodNutrientInqEntity.getNutrientInqEntityList()){
                    if (tInqEntity.getNutrientName().equals("vitA") || tInqEntity.getNutrientName().equals("i")|| tInqEntity.getNutrientName().equals("ca")|| tInqEntity.getNutrientName().equals("protein")) {
                        if (tInqEntity.getInq() != null) {
                            vitaACaProteinIINQ += tInqEntity.getInq();
                        }
                    }
                }
                tFoodNutrientInqEntity.setVitaACaProteinI(vitaACaProteinIINQ);

            }
            Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodBreastfeedingComparator);
        }

        // 由于针对高血糖人群的特殊需求的食材排序在 `findFoodNutrientINQ` 方法开头已经排序过了，所以以下之前写的排序方法可以省略（已注释）
        else if (!userInfoEntity.getHealthStatus().contains("无")){
            if (userInfoEntity.getHealthStatus().contains("高血糖")){
//                List<TFoodNutrientInqEntity> tFoodNutrientInqEntityListSorted = new ArrayList<>();
//                List<TFoodGiglEntity> tFoodGiglEntityList = tFoodGiGlRepository.findAllSorted();
//                for (TFoodGiglEntity tFoodGiglEntity : tFoodGiglEntityList){
//                    for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
//                        if (tFoodGiglEntity.getFoodCode() != null){
//                            if (tFoodGiglEntity.getFoodCode().equals(tFoodNutrientInqEntity.getFoodCode())){
//                                if (tFoodGiglEntity.getGl() != null && tFoodGiglEntity.getGi() != null){
//                                    tFoodNutrientInqEntity.setGl(tFoodGiglEntity.getGl());
//                                    tFoodNutrientInqEntity.setGi(tFoodGiglEntity.getGi());
//                                    tFoodNutrientInqEntityListSorted.add(tFoodNutrientInqEntity);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//
//                tFoodNutrientInqEntityList = tFoodNutrientInqEntityListSorted;
//                Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodGLGIComparator);
            }
            else if (userInfoEntity.getHealthStatus().contains("血脂异常")){
                List<TFoodFattyacidEntity> tFoodFattyacidEntityList= tFoodFattyacidRepository.findAll();
                for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
                    for (TFoodFattyacidEntity tFoodFattyacidEntity : tFoodFattyacidEntityList){
                        if (tFoodFattyacidEntity.getFoodCode() != null){
                            if (tFoodFattyacidEntity.getFoodCode().equals(tFoodNutrientInqEntity.getFoodCode())){
                                if (tFoodFattyacidEntity.getSfa() != null && tFoodNutrientInqEntity.getCholesterol() != null){
                                    tFoodNutrientInqEntity.setSfa(tFoodFattyacidEntity.getSfa());
                                    break;
                                }
                            }
                        }
                    }
                }
                Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodCholesterolSFAComparator);
            }
            else if (userInfoEntity.getHealthStatus().contains("高血压")){
                Double caKMgINQ = 0.0;
                for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
                    for (TInqEntity tInqEntity : tFoodNutrientInqEntity.getNutrientInqEntityList()){
                        if (tInqEntity.getNutrientName().equals("ca") || tInqEntity.getNutrientName().equals("k") || tInqEntity.getNutrientName().equals("mg")) {
                            if (tInqEntity.getInq() != null) {
                                caKMgINQ += tInqEntity.getInq();
                            }
                        }
                    }
                    tFoodNutrientInqEntity.setCaKMgInq(caKMgINQ);

                }
                Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodCaKMgINQComparator);
            }

            // 由于针对高尿酸人群的特殊需求的食材排序在 `findFoodNutrientINQ` 方法开头已经排序过了，所以以下之前写的排序方法可以省略（已注释）
            else if (userInfoEntity.getHealthStatus().contains("高尿酸")){
//                List<TFoodPurineEntity> tFoodPurineEntityList = tFoodPurineRepository.findAll();
//                for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
//                    for (TFoodPurineEntity tFoodPurineEntity : tFoodPurineEntityList){
//                        if (tFoodPurineEntity.getFoodCode() != null){
//                            if (tFoodPurineEntity.getFoodCode().equals(tFoodNutrientInqEntity.getFoodCode())){
//                                if (tFoodPurineEntity.getPurine() != null){
//                                    tFoodNutrientInqEntity.setPurine(tFoodPurineEntity.getPurine());
//                                }
//                            }
//                        }
//                    }
//                }
//                Collections.sort(tFoodNutrientInqEntityList, CustomComparators.foodPurineComparator);
            }
        }

        // 如果用户的个人健康状况没问题（无三高和血脂异常）或者非孕妇，作为正常人，则直接给各食材的INQ排序；若为特殊人群，以下排序INQ的方法
        // 作为第二或第三层等的排序
        for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
            Collections.sort(tFoodNutrientInqEntity.getNutrientInqEntityList(), CustomComparators.nutrientINQComparator);

        }

        // 这部分代码用来: 遍历 `t_inq`表里已经存在的 `customerId`, 即若当前用户已经登陆并使用过这个软件，则不需要再次保存属于他的
        // 食材以及inq到 `t_inq`表中。但如果单纯在开发中用不同的用户 测试这个接口以及这个功能，可以先注释掉
        for (int customerId : tInqRepository.findAllCustomerId()){
            if (customerId == userInfoEntity.getId()){
                return tFoodNutrientInqEntityList;
            }
        }
        // 保存当前用户的排好序的食材以及inq到 `t_inq`表里
        tInqRepository.deleteAll();
        for (TFoodNutrientInqEntity tFoodNutrientInqEntity : tFoodNutrientInqEntityList){
            tInqRepository.saveAll(tFoodNutrientInqEntity.getNutrientInqEntityList());
        }
        System.out.println("解析对应食材营养INQ成功");
        return tFoodNutrientInqEntityList;
    }

    // 根据不同的需求/方法(来自前端)来获取用户想要的食材信息（通过传入参数：食材种类，或者食材关键词），并且根据前端给的需求，来给
    // 系统“搜索”或“按类别”得出的答案食材列表进行分页处理
    @Override
    public List<TFoodNutrientInqEntity> findFoodNutrientINQByPage(int from, int to, String category, String keyword) throws Exception{
        List<TFoodNutrientInqEntity> foodInqResultList = new ArrayList<>();
        if (keyword.equals("")){
            foodInqResultList = findFoodByCategory(foodInqResultList, category);
        }
        else{
            foodInqResultList = searchFoodByKeyword(foodInqResultList, keyword);
        }

        if (to <= foodInqResultList.size()){
            return foodInqResultList.subList(from, to);
        }
        else{
            return foodInqResultList.subList(from, foodInqResultList.size());
        }

    }

    // 此为被调用的方法：根据前端用户选择的食材，结合数据库现有的表里的食材类别代码，从而进行分类提取数据
    private List<TFoodNutrientInqEntity> findFoodByCategory(List<TFoodNutrientInqEntity> foodInqResultList, String category) throws Exception{
        List<String> categoryList = new ArrayList<>();
        switch (category){
            case "谷薯类":
                categoryList = Arrays.asList("01","02","03");
                break;
            case "蔬菜类":
                categoryList = Arrays.asList("04","05");
                break;
            case "水果类":
                categoryList = Arrays.asList("06");
                break;
            case "畜禽肉":
                categoryList = Arrays.asList("08", "09");
                break;
            case "水产品":
                categoryList = Arrays.asList("12");
                break;
            case "蛋类":
                categoryList = Arrays.asList("11");
                break;
            case "奶及奶制品":
                categoryList = Arrays.asList("10");
                break;
            case "大豆及坚果类":
                categoryList = Arrays.asList("03","07");
                break;
        }

        long currentTimeMillis = System.currentTimeMillis();
        List<Object[]> resultList = tFoodRepository.findFoodInqCombinedCategoryResult(categoryList);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println( "'findFoodInqCombinedCategoryResult'任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return organizeResultList(resultList,foodInqResultList);
    }

    // 此为被调用的方法：根据前端用户输入的食材名字/关键词来在已经存在数据库中、排好序的表提取数据
    private List<TFoodNutrientInqEntity> searchFoodByKeyword(List<TFoodNutrientInqEntity> foodInqResultList, String keyword) throws Exception{
        List<Object[]> resultList = tFoodRepository.searchFoodByKeyword(keyword);
        return organizeResultList(resultList, foodInqResultList);
    }

    private List<TFoodNutrientInqEntity> organizeResultList(List<Object[]> resultList, List<TFoodNutrientInqEntity> foodInqResultList) throws Exception{
        TFoodNutrientInqEntity tFoodNutrientInqEntity = new TFoodNutrientInqEntity();
        for (Object[] result : resultList){
            boolean isExisted = false;
            if (foodInqResultList.size() == 0){
                tFoodNutrientInqEntity = new TFoodNutrientInqEntity();
                tFoodNutrientInqEntity.setFoodCode((String)result[0]);
                tFoodNutrientInqEntity.setFoodName((String)result[1]);
                tFoodNutrientInqEntity.addFoodTag((String)result[2]);
                foodInqResultList.add(tFoodNutrientInqEntity);
            }
            else{

                for (TFoodNutrientInqEntity item : foodInqResultList){
                    if (item.getFoodCode().equals((String)result[0])){
                        item.addFoodTag((String)result[2]);
                        System.out.println("weafada"+item.getFoodName());
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted){
                    tFoodNutrientInqEntity = new TFoodNutrientInqEntity();
                    tFoodNutrientInqEntity.setFoodCode((String)result[0]);
                    tFoodNutrientInqEntity.setFoodName((String)result[1]);
                    tFoodNutrientInqEntity.addFoodTag((String)result[2]);
                    foodInqResultList.add(tFoodNutrientInqEntity);
                }

            }

        }
        return foodInqResultList;
    }

    // 把一个String的第一个字母大写， 然后提取该method名
    private static String getMethodName(String fieldName) throws Exception{
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

}