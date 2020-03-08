package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food_fattyacid", schema = "nutritiondb", catalog = "")
public class TFoodFattyacidEntity {
    private long id;
    private String foodCode;
    private String foodName;
    private Double totalFa;
    private Double sfa;
    private Double mufa;
    private Double pufa;
    private Double unFa;
    private Double linoleicAcid;
    private Double ala;
    private Double epa;
    private Double dpa;
    private Double dha;
    private String remark;

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
    @Column(name = "total_fa")
    public Double getTotalFa() {
        return totalFa;
    }

    public void setTotalFa(Double totalFa) {
        this.totalFa = totalFa;
    }

    @Basic
    @Column(name = "sfa")
    public Double getSfa() {
        return sfa;
    }

    public void setSfa(Double sfa) {
        this.sfa = sfa;
    }

    @Basic
    @Column(name = "mufa")
    public Double getMufa() {
        return mufa;
    }

    public void setMufa(Double mufa) {
        this.mufa = mufa;
    }

    @Basic
    @Column(name = "pufa")
    public Double getPufa() {
        return pufa;
    }

    public void setPufa(Double pufa) {
        this.pufa = pufa;
    }

    @Basic
    @Column(name = "un_fa")
    public Double getUnFa() {
        return unFa;
    }

    public void setUnFa(Double unFa) {
        this.unFa = unFa;
    }

    @Basic
    @Column(name = "linoleic_acid")
    public Double getLinoleicAcid() {
        return linoleicAcid;
    }

    public void setLinoleicAcid(Double linoleicAcid) {
        this.linoleicAcid = linoleicAcid;
    }

    @Basic
    @Column(name = "ala")
    public Double getAla() {
        return ala;
    }

    public void setAla(Double ala) {
        this.ala = ala;
    }

    @Basic
    @Column(name = "epa")
    public Double getEpa() {
        return epa;
    }

    public void setEpa(Double epa) {
        this.epa = epa;
    }

    @Basic
    @Column(name = "dpa")
    public Double getDpa() {
        return dpa;
    }

    public void setDpa(Double dpa) {
        this.dpa = dpa;
    }

    @Basic
    @Column(name = "dha")
    public Double getDha() {
        return dha;
    }

    public void setDha(Double dha) {
        this.dha = dha;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFoodFattyacidEntity that = (TFoodFattyacidEntity) o;

        if (id != that.id) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (totalFa != null ? !totalFa.equals(that.totalFa) : that.totalFa != null) return false;
        if (sfa != null ? !sfa.equals(that.sfa) : that.sfa != null) return false;
        if (mufa != null ? !mufa.equals(that.mufa) : that.mufa != null) return false;
        if (pufa != null ? !pufa.equals(that.pufa) : that.pufa != null) return false;
        if (unFa != null ? !unFa.equals(that.unFa) : that.unFa != null) return false;
        if (linoleicAcid != null ? !linoleicAcid.equals(that.linoleicAcid) : that.linoleicAcid != null) return false;
        if (ala != null ? !ala.equals(that.ala) : that.ala != null) return false;
        if (epa != null ? !epa.equals(that.epa) : that.epa != null) return false;
        if (dpa != null ? !dpa.equals(that.dpa) : that.dpa != null) return false;
        if (dha != null ? !dha.equals(that.dha) : that.dha != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (totalFa != null ? totalFa.hashCode() : 0);
        result = 31 * result + (sfa != null ? sfa.hashCode() : 0);
        result = 31 * result + (mufa != null ? mufa.hashCode() : 0);
        result = 31 * result + (pufa != null ? pufa.hashCode() : 0);
        result = 31 * result + (unFa != null ? unFa.hashCode() : 0);
        result = 31 * result + (linoleicAcid != null ? linoleicAcid.hashCode() : 0);
        result = 31 * result + (ala != null ? ala.hashCode() : 0);
        result = 31 * result + (epa != null ? epa.hashCode() : 0);
        result = 31 * result + (dpa != null ? dpa.hashCode() : 0);
        result = 31 * result + (dha != null ? dha.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
