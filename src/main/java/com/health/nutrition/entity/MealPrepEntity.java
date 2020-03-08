package com.health.nutrition.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MealPrepEntity implements Serializable {

    private String className;
    private Byte classCode;
    private String subclassName;
    private String subclassCode;
    List<TFoodNutrientEntity> tFoodNutrientEntityList = new ArrayList<>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Byte getClassCode() {
        return classCode;
    }

    public void setClassCode(Byte classCode) {
        this.classCode = classCode;
    }

    public String getSubClassName() {
        return subclassName;
    }

    public void setSubClassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public String getSubClassCode() {
        return subclassCode;
    }

    public void setSubClassCode(String subclassCode) {
        this.subclassCode = subclassCode;
    }

    public List<TFoodNutrientEntity> gettFoodNutrientEntityList() {
        return tFoodNutrientEntityList;
    }

    public void addtFoodNutrientEntityList(TFoodNutrientEntity tFoodNutrientEntity) {
        this.tFoodNutrientEntityList.add(tFoodNutrientEntity);
    }
}
