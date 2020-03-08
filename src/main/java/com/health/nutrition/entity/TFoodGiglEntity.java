package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food_gigl", schema = "nutritiondb", catalog = "")
public class TFoodGiglEntity {
    private long id;
    private String foodCode;
    private String codeG;
    private String foodName;
    private String conditionGigl;
    private String brand;
    private String location;
    private Integer gi;
    private Double cho;
    private Integer gl;
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="food_code")
    private TFoodNutrientEntity tFoodNutrientEntity;

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
    @Column(name = "code_g")
    public String getCodeG() {
        return codeG;
    }

    public void setCodeG(String codeG) {
        this.codeG = codeG;
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
    @Column(name = "condition_gigl")
    public String getConditionGigl() {
        return conditionGigl;
    }

    public void setConditionGigl(String conditionGigl) {
        this.conditionGigl = conditionGigl;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "gi")
    public Integer getGi() {
        return gi;
    }

    public void setGi(Integer gi) {
        this.gi = gi;
    }

    @Basic
    @Column(name = "cho")
    public Double getCho() {
        return cho;
    }

    public void setCho(Double cho) {
        this.cho = cho;
    }

    @Basic
    @Column(name = "gl")
    public Integer getGl() {
        return gl;
    }

    public void setGl(Integer gl) {
        this.gl = gl;
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

        TFoodGiglEntity that = (TFoodGiglEntity) o;

        if (id != that.id) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (codeG != null ? !codeG.equals(that.codeG) : that.codeG != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (conditionGigl != null ? !conditionGigl.equals(that.conditionGigl) : that.conditionGigl != null)
            return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (gi != null ? !gi.equals(that.gi) : that.gi != null) return false;
        if (cho != null ? !cho.equals(that.cho) : that.cho != null) return false;
        if (gl != null ? !gl.equals(that.gl) : that.gl != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (codeG != null ? codeG.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (conditionGigl != null ? conditionGigl.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (gi != null ? gi.hashCode() : 0);
        result = 31 * result + (cho != null ? cho.hashCode() : 0);
        result = 31 * result + (gl != null ? gl.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }
}
