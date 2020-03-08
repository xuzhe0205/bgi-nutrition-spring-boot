package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food_tags", schema = "nutritiondb", catalog = "")
public class TFoodTagsEntity {
    private int id;
    private String foodCode;
    private String foodTag;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "food_code")
    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    @Basic
    @Column(name = "food_tag")
    public String getFoodTag() {
        return foodTag;
    }

    public void setFoodTag(String foodTag) {
        this.foodTag = foodTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFoodTagsEntity that = (TFoodTagsEntity) o;

        if (id != that.id) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (foodTag != null ? !foodTag.equals(that.foodTag) : that.foodTag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (foodTag != null ? foodTag.hashCode() : 0);
        return result;
    }
}
