package com.health.nutrition.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_food_nutrient", schema = "nutritiondb", catalog = "")
public class TFoodNutrientEntity {
    private long id;
    private String foodCode;
    private String foodName;
    private Double edible;
    private Double water;
    private Double energy;
    private Double protein;
    private Double fat;
    private Double cho;
    private Double dietaryFiber;
    private Double cholesterol;
    private Double ash;
    private Double vitA;
    private Double totCarotene;
    private Double retinol;
    private Double thiamin;
    private Double riboflavin;
    private Double niacin;
    private Double vitamineB5;
    private Double vitamineB6;
    private Double vitamineB12;
    private Double vitamineC;
    private Double vitamineD;
    private Double vitamineE;
    private Double vitamineK;
    private Double vitamineH;
    private Double folicAcid;
    private Double ca;
    private Double p;
    private Double k;
    private Double na;
    private Double mg;
    private Double fe;
    private Double zn;
    private Double se;
    private Double cu;
    private Double mn;
    private Double i;
    private Double choline;
    private String dataSources;

    @OneToMany(mappedBy = "tFoodNutrientEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TFoodGiglEntity> tFoodGiglEntityList= new ArrayList<>();


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
    @Column(name = "food_name")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "edible")
    public Double getEdible() {
        return edible;
    }

    public void setEdible(Double edible) {
        this.edible = edible;
    }

    @Basic
    @Column(name = "water")
    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    @Basic
    @Column(name = "energy")
    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    @Basic
    @Column(name = "protein")
    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    @Basic
    @Column(name = "fat")
    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
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
    @Column(name = "dietary_fiber")
    public Double getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(Double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    @Basic
    @Column(name = "cholesterol")
    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }

    @Basic
    @Column(name = "ash")
    public Double getAsh() {
        return ash;
    }

    public void setAsh(Double ash) {
        this.ash = ash;
    }

    @Basic
    @Column(name = "vit_a")
    public Double getVitA() {
        return vitA;
    }

    public void setVitA(Double vitA) {
        this.vitA = vitA;
    }

    @Basic
    @Column(name = "tot_carotene")
    public Double getTotCarotene() {
        return totCarotene;
    }

    public void setTotCarotene(Double totCarotene) {
        this.totCarotene = totCarotene;
    }

    @Basic
    @Column(name = "retinol")
    public Double getRetinol() {
        return retinol;
    }

    public void setRetinol(Double retinol) {
        this.retinol = retinol;
    }

    @Basic
    @Column(name = "thiamin")
    public Double getThiamin() {
        return thiamin;
    }

    public void setThiamin(Double thiamin) {
        this.thiamin = thiamin;
    }

    @Basic
    @Column(name = "riboflavin")
    public Double getRiboflavin() {
        return riboflavin;
    }

    public void setRiboflavin(Double riboflavin) {
        this.riboflavin = riboflavin;
    }

    @Basic
    @Column(name = "niacin")
    public Double getNiacin() {
        return niacin;
    }

    public void setNiacin(Double niacin) {
        this.niacin = niacin;
    }

    @Basic
    @Column(name = "vitamine_b5")
    public Double getVitamineB5() {
        return vitamineB5;
    }

    public void setVitamineB5(Double vitamineB5) {
        this.vitamineB5 = vitamineB5;
    }

    @Basic
    @Column(name = "vitamine_b6")
    public Double getVitamineB6() {
        return vitamineB6;
    }

    public void setVitamineB6(Double vitamineB6) {
        this.vitamineB6 = vitamineB6;
    }

    @Basic
    @Column(name = "vitamine_b12")
    public Double getVitamineB12() {
        return vitamineB12;
    }

    public void setVitamineB12(Double vitamineB12) {
        this.vitamineB12 = vitamineB12;
    }

    @Basic
    @Column(name = "vitamine_c")
    public Double getVitamineC() {
        return vitamineC;
    }

    public void setVitamineC(Double vitamineC) {
        this.vitamineC = vitamineC;
    }

    @Basic
    @Column(name = "vitamine_d")
    public Double getVitamineD() {
        return vitamineD;
    }

    public void setVitamineD(Double vitamineD) {
        this.vitamineD = vitamineD;
    }

    @Basic
    @Column(name = "vitamine_e")
    public Double getVitamineE() {
        return vitamineE;
    }

    public void setVitamineE(Double vitamineE) {
        this.vitamineE = vitamineE;
    }

    @Basic
    @Column(name = "vitamine_k")
    public Double getVitamineK() {
        return vitamineK;
    }

    public void setVitamineK(Double vitamineK) {
        this.vitamineK = vitamineK;
    }

    @Basic
    @Column(name = "vitamine_h")
    public Double getVitamineH() {
        return vitamineH;
    }

    public void setVitamineH(Double vitamineH) {
        this.vitamineH = vitamineH;
    }

    @Basic
    @Column(name = "folic_acid")
    public Double getFolicAcid() {
        return folicAcid;
    }

    public void setFolicAcid(Double folicAcid) {
        this.folicAcid = folicAcid;
    }

    @Basic
    @Column(name = "ca")
    public Double getCa() {
        return ca;
    }

    public void setCa(Double ca) {
        this.ca = ca;
    }

    @Basic
    @Column(name = "p")
    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    @Basic
    @Column(name = "k")
    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
    }

    @Basic
    @Column(name = "na")
    public Double getNa() {
        return na;
    }

    public void setNa(Double na) {
        this.na = na;
    }

    @Basic
    @Column(name = "mg")
    public Double getMg() {
        return mg;
    }

    public void setMg(Double mg) {
        this.mg = mg;
    }

    @Basic
    @Column(name = "fe")
    public Double getFe() {
        return fe;
    }

    public void setFe(Double fe) {
        this.fe = fe;
    }

    @Basic
    @Column(name = "zn")
    public Double getZn() {
        return zn;
    }

    public void setZn(Double zn) {
        this.zn = zn;
    }

    @Basic
    @Column(name = "se")
    public Double getSe() {
        return se;
    }

    public void setSe(Double se) {
        this.se = se;
    }

    @Basic
    @Column(name = "cu")
    public Double getCu() {
        return cu;
    }

    public void setCu(Double cu) {
        this.cu = cu;
    }

    @Basic
    @Column(name = "mn")
    public Double getMn() {
        return mn;
    }

    public void setMn(Double mn) {
        this.mn = mn;
    }

    @Basic
    @Column(name = "i")
    public Double getI() {
        return i;
    }

    public void setI(Double i) {
        this.i = i;
    }

    @Basic
    @Column(name = "choline")
    public Double getCholine() {
        return choline;
    }

    public void setCholine(Double choline) {
        this.choline = choline;
    }

    @Basic
    @Column(name = "data_sources")
    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFoodNutrientEntity that = (TFoodNutrientEntity) o;

        if (id != that.id) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (edible != null ? !edible.equals(that.edible) : that.edible != null) return false;
        if (water != null ? !water.equals(that.water) : that.water != null) return false;
        if (energy != null ? !energy.equals(that.energy) : that.energy != null) return false;
        if (protein != null ? !protein.equals(that.protein) : that.protein != null) return false;
        if (fat != null ? !fat.equals(that.fat) : that.fat != null) return false;
        if (cho != null ? !cho.equals(that.cho) : that.cho != null) return false;
        if (dietaryFiber != null ? !dietaryFiber.equals(that.dietaryFiber) : that.dietaryFiber != null) return false;
        if (cholesterol != null ? !cholesterol.equals(that.cholesterol) : that.cholesterol != null) return false;
        if (ash != null ? !ash.equals(that.ash) : that.ash != null) return false;
        if (vitA != null ? !vitA.equals(that.vitA) : that.vitA != null) return false;
        if (totCarotene != null ? !totCarotene.equals(that.totCarotene) : that.totCarotene != null) return false;
        if (retinol != null ? !retinol.equals(that.retinol) : that.retinol != null) return false;
        if (thiamin != null ? !thiamin.equals(that.thiamin) : that.thiamin != null) return false;
        if (riboflavin != null ? !riboflavin.equals(that.riboflavin) : that.riboflavin != null) return false;
        if (niacin != null ? !niacin.equals(that.niacin) : that.niacin != null) return false;
        if (vitamineB5 != null ? !vitamineB5.equals(that.vitamineB5) : that.vitamineB5 != null) return false;
        if (vitamineB6 != null ? !vitamineB6.equals(that.vitamineB6) : that.vitamineB6 != null) return false;
        if (vitamineB12 != null ? !vitamineB12.equals(that.vitamineB12) : that.vitamineB12 != null) return false;
        if (vitamineC != null ? !vitamineC.equals(that.vitamineC) : that.vitamineC != null) return false;
        if (vitamineD != null ? !vitamineD.equals(that.vitamineD) : that.vitamineD != null) return false;
        if (vitamineE != null ? !vitamineE.equals(that.vitamineE) : that.vitamineE != null) return false;
        if (vitamineK != null ? !vitamineK.equals(that.vitamineK) : that.vitamineK != null) return false;
        if (vitamineH != null ? !vitamineH.equals(that.vitamineH) : that.vitamineH != null) return false;
        if (folicAcid != null ? !folicAcid.equals(that.folicAcid) : that.folicAcid != null) return false;
        if (ca != null ? !ca.equals(that.ca) : that.ca != null) return false;
        if (p != null ? !p.equals(that.p) : that.p != null) return false;
        if (k != null ? !k.equals(that.k) : that.k != null) return false;
        if (na != null ? !na.equals(that.na) : that.na != null) return false;
        if (mg != null ? !mg.equals(that.mg) : that.mg != null) return false;
        if (fe != null ? !fe.equals(that.fe) : that.fe != null) return false;
        if (zn != null ? !zn.equals(that.zn) : that.zn != null) return false;
        if (se != null ? !se.equals(that.se) : that.se != null) return false;
        if (cu != null ? !cu.equals(that.cu) : that.cu != null) return false;
        if (mn != null ? !mn.equals(that.mn) : that.mn != null) return false;
        if (i != null ? !i.equals(that.i) : that.i != null) return false;
        if (choline != null ? !choline.equals(that.choline) : that.choline != null) return false;
        if (dataSources != null ? !dataSources.equals(that.dataSources) : that.dataSources != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (edible != null ? edible.hashCode() : 0);
        result = 31 * result + (water != null ? water.hashCode() : 0);
        result = 31 * result + (energy != null ? energy.hashCode() : 0);
        result = 31 * result + (protein != null ? protein.hashCode() : 0);
        result = 31 * result + (fat != null ? fat.hashCode() : 0);
        result = 31 * result + (cho != null ? cho.hashCode() : 0);
        result = 31 * result + (dietaryFiber != null ? dietaryFiber.hashCode() : 0);
        result = 31 * result + (cholesterol != null ? cholesterol.hashCode() : 0);
        result = 31 * result + (ash != null ? ash.hashCode() : 0);
        result = 31 * result + (vitA != null ? vitA.hashCode() : 0);
        result = 31 * result + (totCarotene != null ? totCarotene.hashCode() : 0);
        result = 31 * result + (retinol != null ? retinol.hashCode() : 0);
        result = 31 * result + (thiamin != null ? thiamin.hashCode() : 0);
        result = 31 * result + (riboflavin != null ? riboflavin.hashCode() : 0);
        result = 31 * result + (niacin != null ? niacin.hashCode() : 0);
        result = 31 * result + (vitamineB5 != null ? vitamineB5.hashCode() : 0);
        result = 31 * result + (vitamineB6 != null ? vitamineB6.hashCode() : 0);
        result = 31 * result + (vitamineB12 != null ? vitamineB12.hashCode() : 0);
        result = 31 * result + (vitamineC != null ? vitamineC.hashCode() : 0);
        result = 31 * result + (vitamineD != null ? vitamineD.hashCode() : 0);
        result = 31 * result + (vitamineE != null ? vitamineE.hashCode() : 0);
        result = 31 * result + (vitamineK != null ? vitamineK.hashCode() : 0);
        result = 31 * result + (vitamineH != null ? vitamineH.hashCode() : 0);
        result = 31 * result + (folicAcid != null ? folicAcid.hashCode() : 0);
        result = 31 * result + (ca != null ? ca.hashCode() : 0);
        result = 31 * result + (p != null ? p.hashCode() : 0);
        result = 31 * result + (k != null ? k.hashCode() : 0);
        result = 31 * result + (na != null ? na.hashCode() : 0);
        result = 31 * result + (mg != null ? mg.hashCode() : 0);
        result = 31 * result + (fe != null ? fe.hashCode() : 0);
        result = 31 * result + (zn != null ? zn.hashCode() : 0);
        result = 31 * result + (se != null ? se.hashCode() : 0);
        result = 31 * result + (cu != null ? cu.hashCode() : 0);
        result = 31 * result + (mn != null ? mn.hashCode() : 0);
        result = 31 * result + (i != null ? i.hashCode() : 0);
        result = 31 * result + (choline != null ? choline.hashCode() : 0);
        result = 31 * result + (dataSources != null ? dataSources.hashCode() : 0);
        return result;
    }
}
