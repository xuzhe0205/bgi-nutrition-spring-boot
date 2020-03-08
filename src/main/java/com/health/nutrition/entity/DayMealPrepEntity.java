package com.health.nutrition.entity;

import java.util.ArrayList;
import java.util.List;

public class DayMealPrepEntity {

    private String timeInDay;
    private List<MealPrepEntity> mealPrepEntityList = new ArrayList<>();;

    public String getTimeInDay() {
        return timeInDay;
    }

    public void setTimeInDay(String timeInDay) {
        this.timeInDay = timeInDay;
    }

    public List<MealPrepEntity> getMealPrepEntityList() {
        return mealPrepEntityList;
    }

    public void addMealPrepEntityList(MealPrepEntity mealPrepEntity) {
        this.mealPrepEntityList.add(mealPrepEntity);
    }
}
