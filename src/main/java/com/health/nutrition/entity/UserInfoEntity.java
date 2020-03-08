package com.health.nutrition.entity;

import com.health.nutrition.common.aspect.annotation.IsValidUserInfo;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@IsValidUserInfo()
public class UserInfoEntity implements Serializable {
    private long id;

    private String name;
    @ApiModelProperty(value = "性别：男、女")
    private String sex;
    @ApiModelProperty(value = "生日：yyyy/mm/dd")
    private String dob;
    @ApiModelProperty(value = "身高：'177.5'")
    private String height;
    @ApiModelProperty(value = "体重: '76.5'")
    private String weight;
    @ApiModelProperty(value = "怀孕状态: 孕期（早），孕期（中），孕期（晚），乳母")
    private String pregnancyStatus;
    @ApiModelProperty(value = "健康状态，有无四高")
    private List<String> healthStatus = new ArrayList<>();
    @ApiModelProperty(value = "身体活动水平：轻活动水平、中活动水平、重活动水平")
    private String activityIntensity;
    @ApiModelProperty(value = "0为不吸烟，1为吸烟")
    private String isSmoker;
    @ApiModelProperty(value = "饮酒情况: 不喝酒, 以前喝现在不喝, 喝酒")
    private String alcoholicStatus;
    @ApiModelProperty(value = "用药状态: 有（有的话请描述）、无")
    private String drugStatus;
    @ApiModelProperty(value = "个人标签：肥胖、微胖、偏瘦等由算法计算得出的个人特质标签")
    private List<String> tags = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPregnancyStatus() {
        return pregnancyStatus;
    }

    public void setPregnancyStatus(String pregnancyStatus) {
        this.pregnancyStatus = pregnancyStatus;
    }

    public List<String> getHealthStatus() {
        return healthStatus;
    }

    public void addHealthStatus(String healthStatus) {
        this.healthStatus.add(healthStatus);
    }

    public String getActivityIntensity() {
        return activityIntensity;
    }

    public void setActivityIntensity(String activityIntensity) {
        this.activityIntensity = activityIntensity;
    }

    public String getIsSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(String isSmoker) {
        this.isSmoker = isSmoker;
    }

    public String getAlcoholicStatus() {
        return alcoholicStatus;
    }

    public void setAlcoholicStatus(String alcoholicStatus) {
        this.alcoholicStatus = alcoholicStatus;
    }

    public String getDrugStatus() {
        return drugStatus;
    }

    public void setDrugStatus(String drugStatus) {
        this.drugStatus = drugStatus;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTags(String tag) {
        this.tags.add(tag);
    }
}

