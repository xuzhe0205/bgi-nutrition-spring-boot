package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food_purine", schema = "nutritiondb", catalog = "")
public class TFoodPurineEntity {
    private long id;
    private String foodCode;
    private String purineCode;
    private String foodName;
    private Double purine;
    private String source;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    @Column(name = "purine_code")
    public String getPurineCode() {
        return purineCode;
    }

    public void setPurineCode(String purineCode) {
        this.purineCode = purineCode;
    }

    @Basic
    @Column(name = "food_name")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "purine")
    public Double getPurine() {
        return purine;
    }

    public void setPurine(Double purine) {
        this.purine = purine;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFoodPurineEntity that = (TFoodPurineEntity) o;

        if (id != that.id) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (purineCode != null ? !purineCode.equals(that.purineCode) : that.purineCode != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (purine != null ? !purine.equals(that.purine) : that.purine != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (purineCode != null ? purineCode.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (purine != null ? purine.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }
}
