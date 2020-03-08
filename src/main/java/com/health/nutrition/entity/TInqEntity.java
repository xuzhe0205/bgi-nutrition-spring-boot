package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_inq", schema = "nutritiondb", catalog = "")
public class TInqEntity {
    private long id;
    private Long customerId;
    private String foodCode;
    private String foodName;
    private String nutrientName;
    private Double inq;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
    @Column(name = "food_name")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "nutrient_name")
    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    @Basic
    @Column(name = "inq")
    public Double getInq() {
        return inq;
    }

    public void setInq(Double inq) {
        this.inq = inq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TInqEntity that = (TInqEntity) o;

        if (id != that.id) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (nutrientName != null ? !nutrientName.equals(that.nutrientName) : that.nutrientName != null) return false;
        if (inq != null ? !inq.equals(that.inq) : that.inq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (nutrientName != null ? nutrientName.hashCode() : 0);
        result = 31 * result + (inq != null ? inq.hashCode() : 0);
        return result;
    }
}
