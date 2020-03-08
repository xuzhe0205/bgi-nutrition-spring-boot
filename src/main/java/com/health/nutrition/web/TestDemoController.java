package com.health.nutrition.web;

import com.health.nutrition.common.aspect.annotation.AutoLog;
import com.health.nutrition.common.base.ResponseResult;
import com.health.nutrition.entity.*;
import com.health.nutrition.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "测试DEMO",description = "一个测试DEMO")
@RestController
@RequestMapping("/testDemo")
@EnableAsync
public class TestDemoController {

    @Autowired
    private TFoodService tFoodService;

    @Autowired
    private TFoodRniService tFoodRniService;

    @Autowired
    private TFoodNutrientINQService tFoodNutrientINQService;

    @Autowired
    private TFoodTagsService tFoodTagsService;


    // 此接口用于提取所有食材信息，做测试用
    @AutoLog(value = "测试DEMO")
    @GetMapping("/findAllFood")
    @ResponseBody
    @ApiOperation(value = "获取所有食材",notes = "直接获取所有食材",httpMethod = "GET",produces = "application/json")
    public ResponseResult findAllFood(@ApiParam(required = false,name="Authorization")  @RequestHeader(value = "Authorization",required = false,defaultValue = "") String Authorization){
        String message="获取食材成功";

        Integer result=200;

        try {
            List<TFoodEntity> tFoodEntityList = tFoodService.getAll();
            if(tFoodEntityList==null){
                return new ResponseResult(result,"食材编码不存在",null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            tFoodService.task1();
            tFoodService.task2();
            tFoodService.task3();
            long currentTimeMillis1 = System.currentTimeMillis();
            System.out.println( "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
            return new ResponseResult(result,message,tFoodEntityList);
        } catch (Exception e) {
            message="获取食材失败";
            result=500;
            e.printStackTrace();
        }
        return new ResponseResult(result,message,null);
    }

    //此接口用于：录入用户信息，并在后台计算解析各食材的INQ
    @AutoLog(value = "测试logUserAndSaveFoodINQ")
    @PostMapping("/logUserAndSaveFoodINQ")
    @ResponseBody
    @ApiOperation(value = "录入新用户信息",notes = "填写问卷后录入新用户信息",httpMethod = "POST", produces = "application/json")
    public ResponseResult logUserAndSaveFoodINQ(@ApiParam(required = false,name="Authorization")  @RequestHeader(value = "Authorization",required = false,defaultValue = "") String Authorization,
                                        @Valid @RequestBody UserInfoEntity userInfoEntity){
        String message="用户信息录入成功，准备解析对应食材营养INQ";
        Integer result=200;

        try {

            TFoodRniEntity tFoodRniEntity = new TFoodRniEntity();
            if (userInfoEntity.getPregnancyStatus().equals("无")) {
                tFoodRniEntity = tFoodRniService.getRniByBodyHorizontal(userInfoEntity);
                System.out.println("wtfwtfwtf");
            }
            else {
                tFoodRniEntity = tFoodRniService.getRniByFactor(userInfoEntity);
                System.out.println("yoyoyoyoyoyo");
            }

            tFoodNutrientINQService.findFoodNutrientINQ(tFoodRniEntity, userInfoEntity);
            System.out.println("用户信息录入成功，准备解析对应食材营养INQ");
            return new ResponseResult(result,message, null);
        } catch (Exception e) {

            message="储存食材INQ失败";
            result=500;
            e.printStackTrace();
        }

        return new ResponseResult(result,message,null);

    }

    //此接口用于：根据不同的需求/方法来获取用户想要的食材信息（通过传入参数：食材种类，或者食材关键词）
    @AutoLog(value = "测试DEMO")
    @GetMapping("/findFoodNutrientINQByPage")
    @ResponseBody
    @ApiOperation(value = "获取食材",notes = "获取食材",httpMethod = "GET",produces = "application/json")
    public ResponseResult findFoodNutrientINQByPage(@ApiParam(required = false,name="Authorization")  @RequestHeader(value = "Authorization",required = false,defaultValue = "") String Authorization,
                                                    @ApiParam(required = true,name = "from",value="查询页数") @RequestParam("from") int from,
                                                    @ApiParam(required = true,name = "to",value="查询页数") @RequestParam("to") int to,
                                                    @ApiParam(required = true,name = "category",value="食材种类") @RequestParam("category") String category,
                                                    @ApiParam(required = true,name = "keyword",value="食材关键词") @RequestParam("keyword") String keyword){
        String message="获取食材及其营养素INQ成功";

        Integer result=200;


        try {
            List<TFoodNutrientInqEntity> resultList = tFoodNutrientINQService.findFoodNutrientINQByPage(from, to, category, keyword);
            return new ResponseResult(result,message,resultList);
        } catch (Exception e) {
            message="获取食材失败";
            result=500;
            e.printStackTrace();
        }
        return new ResponseResult(result,message,null);
    }

    //此接口用于：直接给数据库中现有的食材添加标签
    @AutoLog(value = "计算并筛选出食材的特征标签")
    @PostMapping("/generateFoodTags")
    @ResponseBody
    @ApiOperation(value = "计算并筛选出食材的特征标签",notes = "计算并筛选出食材的特征标签",httpMethod = "POST", produces = "application/json")
    public ResponseResult generateFoodTags(){
        String message="获取食材标签成功";
        Integer result=200;
        try {

            List<TFoodTagsEntity> tFoodTagsEntityList = tFoodTagsService.addFoodTags();
            int size = tFoodTagsEntityList.size();
            if(size == 0){
                return new ResponseResult(result,"食材不存在",null);
            }
            return new ResponseResult(result,message,tFoodTagsEntityList);
        } catch (Exception e) {
            message="获取食材标签失败";
            result=500;
            e.printStackTrace();
        }
        return new ResponseResult(result,message,null);
    }

    //此接口用于：给现有食材额外加入新的特征标签
    @AutoLog(value = "给新增食材添加特征标签")
    @PostMapping("/addNewFoodTags")
    @ResponseBody
    @ApiOperation(value = "给新增食材添加特征标签",notes = "给新增食材添加特征标签",httpMethod = "POST", produces = "application/json")
    public ResponseResult addNewFoodTags(@ApiParam(required = true,name="Authorization")  @RequestHeader(value = "Authorization",required = true,defaultValue = "") String Authorization,
                                         @ApiParam(required = true,name = "foodCode",value="食材编号") @RequestParam("foodCode") String foodCode){
        String message="获取食材标签成功";
        Integer result=200;
        try {

            List<TFoodTagsEntity> tFoodTagsEntityList = tFoodTagsService.addNewFoodTags(foodCode);
            int size = tFoodTagsEntityList.size();
            if(size == 0){
                return new ResponseResult(result,"食材不存在",null);
            }
            return new ResponseResult(result,message,tFoodTagsEntityList);
        } catch (Exception e) {
            message="获取食材标签失败";
            result=500;
            e.printStackTrace();
        }
        return new ResponseResult(result,message,null);
    }

}
