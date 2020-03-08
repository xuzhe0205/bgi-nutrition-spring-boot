package com.health.nutrition.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TFoodNutrientInqEntity implements Serializable {

    private String foodCode;

    private String foodName;

    private List<TInqEntity> nutrientInqEntityList = new ArrayList<>();

    private Integer gi;
    private Integer gl;

    private Double purine;

    private Double sfa;
    private Double cholesterol;

    private Double caKMgInq;

    private Double folicAcidI;

    private Double feCaI;

    private Double vitaACaProteinI;

    private List<String> foodTagList = new ArrayList<>();


    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public List<TInqEntity> getNutrientInqEntityList() {
        return nutrientInqEntityList;
    }

    public void addNutrientInqEntityList(TInqEntity tInqEntity) {
        this.nutrientInqEntityList.add(tInqEntity);
    }

    public Integer getGi() {
        return gi;
    }

    public void setGi(Integer gi) {
        this.gi = gi;
    }

    public Integer getGl() {
        return gl;
    }

    public void setGl(Integer gl) {
        this.gl = gl;
    }

    public Double getPurine() {
        return purine;
    }

    public void setPurine(Double purine) {
        this.purine = purine;
    }

    public Double getSfa() {
        return sfa;
    }

    public void setSfa(Double sfa) {
        this.sfa = sfa;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Double getCaKMgInq() {
        return caKMgInq;
    }

    public void setCaKMgInq(Double caKMgInq) {
        this.caKMgInq = caKMgInq;
    }

    public Double getFolicAcidI() {
        return folicAcidI;
    }

    public void setFolicAcidI(Double folicAcidI) {
        this.folicAcidI = folicAcidI;
    }

    public Double getFeCaI() {
        return feCaI;
    }

    public void setFeCaI(Double feCaI) {
        this.feCaI = feCaI;
    }

    public Double getVitaACaProteinI() {
        return vitaACaProteinI;
    }

    public void setVitaACaProteinI(Double vitaACaProteinI) {
        this.vitaACaProteinI = vitaACaProteinI;
    }

    public List<String> getFoodTagList() {
        return foodTagList;
    }

    public void addFoodTag(String foodTag) {
        this.foodTagList.add(foodTag);
    }
}
