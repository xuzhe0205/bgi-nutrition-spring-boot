package com.health.nutrition.entity;

public class MealPrepFoodINQEntity {

    private String className;
    private Byte classCode;
    private String subclassName;
    private Byte subclassCode;
    private TFoodNutrientInqEntity tFoodNutrientInqEntity;

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

    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public Byte getSubclassCode() {
        return subclassCode;
    }

    public void setSubclassCode(Byte subclassCode) {
        this.subclassCode = subclassCode;
    }

    public TFoodNutrientInqEntity gettFoodNutrientInqEntity() {
        return tFoodNutrientInqEntity;
    }

    public void addtFoodNutrientInqEntity(TFoodNutrientInqEntity tFoodNutrientInqEntity) {
        this.tFoodNutrientInqEntity = tFoodNutrientInqEntity;
    }
}
