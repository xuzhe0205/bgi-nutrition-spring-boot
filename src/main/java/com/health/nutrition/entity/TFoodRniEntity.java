package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food_rni", schema = "nutritiondb", catalog = "")
public class TFoodRniEntity {
    private int id;
    private Byte sex;
    private String ageScope;
    private Byte bodyHorizontal;
    private Byte factor;
    private String energy;
    private String protein;
    private String fat;
    private String cho;
    private String vitA;
    private String vitamineD;
    private String vitamineE;
    private String vitamineK;
    private String thiamin;
    private String riboflavin;
    private String vitamineB6;
    private String vitamineB12;
    private String vitamineB5;
    private String folicAcid;
    private String niacin;
    private String choline;
    private String vitamineH;
    private String vitamineC;
    private String ca;
    private String p;
    private String k;
    private String na;
    private String mg;
    private String lu;
    private String fe;
    private String i;
    private String zn;
    private String se;
    private String cu;
    private String fu;
    private String cr;
    private String mn;
    private String mu;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age_scope")
    public String getAgeScope() {
        return ageScope;
    }

    public void setAgeScope(String ageScope) {
        this.ageScope = ageScope;
    }

    @Basic
    @Column(name = "body_horizontal")
    public Byte getBodyHorizontal() {
        return bodyHorizontal;
    }

    public void setBodyHorizontal(Byte bodyHorizontal) {
        this.bodyHorizontal = bodyHorizontal;
    }

    @Basic
    @Column(name = "factor")
    public Byte getFactor() {
        return factor;
    }

    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    @Basic
    @Column(name = "energy")
    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    @Basic
    @Column(name = "protein")
    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    @Basic
    @Column(name = "fat")
    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    @Basic
    @Column(name = "cho")
    public String getCho() {
        return cho;
    }

    public void setCho(String cho) {
        this.cho = cho;
    }

    @Basic
    @Column(name = "vit_a")
    public String getVitA() {
        return vitA;
    }

    public void setVitA(String vitA) {
        this.vitA = vitA;
    }

    @Basic
    @Column(name = "vitamine_d")
    public String getVitamineD() {
        return vitamineD;
    }

    public void setVitamineD(String vitamineD) {
        this.vitamineD = vitamineD;
    }

    @Basic
    @Column(name = "vitamine_e")
    public String getVitamineE() {
        return vitamineE;
    }

    public void setVitamineE(String vitamineE) {
        this.vitamineE = vitamineE;
    }

    @Basic
    @Column(name = "vitamine_k")
    public String getVitamineK() {
        return vitamineK;
    }

    public void setVitamineK(String vitamineK) {
        this.vitamineK = vitamineK;
    }

    @Basic
    @Column(name = "thiamin")
    public String getThiamin() {
        return thiamin;
    }

    public void setThiamin(String thiamin) {
        this.thiamin = thiamin;
    }

    @Basic
    @Column(name = "riboflavin")
    public String getRiboflavin() {
        return riboflavin;
    }

    public void setRiboflavin(String riboflavin) {
        this.riboflavin = riboflavin;
    }

    @Basic
    @Column(name = "vitamine_b6")
    public String getVitamineB6() {
        return vitamineB6;
    }

    public void setVitamineB6(String vitamineB6) {
        this.vitamineB6 = vitamineB6;
    }

    @Basic
    @Column(name = "vitamine_b12")
    public String getVitamineB12() {
        return vitamineB12;
    }

    public void setVitamineB12(String vitamineB12) {
        this.vitamineB12 = vitamineB12;
    }

    @Basic
    @Column(name = "vitamine_b5")
    public String getVitamineB5() {
        return vitamineB5;
    }

    public void setVitamineB5(String vitamineB5) {
        this.vitamineB5 = vitamineB5;
    }

    @Basic
    @Column(name = "folic_acid")
    public String getFolicAcid() {
        return folicAcid;
    }

    public void setFolicAcid(String folicAcid) {
        this.folicAcid = folicAcid;
    }

    @Basic
    @Column(name = "niacin")
    public String getNiacin() {
        return niacin;
    }

    public void setNiacin(String niacin) {
        this.niacin = niacin;
    }

    @Basic
    @Column(name = "choline")
    public String getCholine() {
        return choline;
    }

    public void setCholine(String choline) {
        this.choline = choline;
    }

    @Basic
    @Column(name = "vitamine_h")
    public String getVitamineH() {
        return vitamineH;
    }

    public void setVitamineH(String vitamineH) {
        this.vitamineH = vitamineH;
    }

    @Basic
    @Column(name = "vitamine_c")
    public String getVitamineC() {
        return vitamineC;
    }

    public void setVitamineC(String vitamineC) {
        this.vitamineC = vitamineC;
    }

    @Basic
    @Column(name = "ca")
    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    @Basic
    @Column(name = "p")
    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    @Basic
    @Column(name = "k")
    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Basic
    @Column(name = "na")
    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    @Basic
    @Column(name = "mg")
    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    @Basic
    @Column(name = "lu")
    public String getLu() {
        return lu;
    }

    public void setLu(String lu) {
        this.lu = lu;
    }

    @Basic
    @Column(name = "fe")
    public String getFe() {
        return fe;
    }

    public void setFe(String fe) {
        this.fe = fe;
    }

    @Basic
    @Column(name = "i")
    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    @Basic
    @Column(name = "zn")
    public String getZn() {
        return zn;
    }

    public void setZn(String zn) {
        this.zn = zn;
    }

    @Basic
    @Column(name = "se")
    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }

    @Basic
    @Column(name = "cu")
    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    @Basic
    @Column(name = "fu")
    public String getFu() {
        return fu;
    }

    public void setFu(String fu) {
        this.fu = fu;
    }

    @Basic
    @Column(name = "cr")
    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    @Basic
    @Column(name = "mn")
    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    @Basic
    @Column(name = "mu")
    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFoodRniEntity that = (TFoodRniEntity) o;

        if (id != that.id) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (ageScope != null ? !ageScope.equals(that.ageScope) : that.ageScope != null) return false;
        if (bodyHorizontal != null ? !bodyHorizontal.equals(that.bodyHorizontal) : that.bodyHorizontal != null)
            return false;
        if (factor != null ? !factor.equals(that.factor) : that.factor != null) return false;
        if (energy != null ? !energy.equals(that.energy) : that.energy != null) return false;
        if (protein != null ? !protein.equals(that.protein) : that.protein != null) return false;
        if (fat != null ? !fat.equals(that.fat) : that.fat != null) return false;
        if (cho != null ? !cho.equals(that.cho) : that.cho != null) return false;
        if (vitA != null ? !vitA.equals(that.vitA) : that.vitA != null) return false;
        if (vitamineD != null ? !vitamineD.equals(that.vitamineD) : that.vitamineD != null) return false;
        if (vitamineE != null ? !vitamineE.equals(that.vitamineE) : that.vitamineE != null) return false;
        if (vitamineK != null ? !vitamineK.equals(that.vitamineK) : that.vitamineK != null) return false;
        if (thiamin != null ? !thiamin.equals(that.thiamin) : that.thiamin != null) return false;
        if (riboflavin != null ? !riboflavin.equals(that.riboflavin) : that.riboflavin != null) return false;
        if (vitamineB6 != null ? !vitamineB6.equals(that.vitamineB6) : that.vitamineB6 != null) return false;
        if (vitamineB12 != null ? !vitamineB12.equals(that.vitamineB12) : that.vitamineB12 != null) return false;
        if (vitamineB5 != null ? !vitamineB5.equals(that.vitamineB5) : that.vitamineB5 != null) return false;
        if (folicAcid != null ? !folicAcid.equals(that.folicAcid) : that.folicAcid != null) return false;
        if (niacin != null ? !niacin.equals(that.niacin) : that.niacin != null) return false;
        if (choline != null ? !choline.equals(that.choline) : that.choline != null) return false;
        if (vitamineH != null ? !vitamineH.equals(that.vitamineH) : that.vitamineH != null) return false;
        if (vitamineC != null ? !vitamineC.equals(that.vitamineC) : that.vitamineC != null) return false;
        if (ca != null ? !ca.equals(that.ca) : that.ca != null) return false;
        if (p != null ? !p.equals(that.p) : that.p != null) return false;
        if (k != null ? !k.equals(that.k) : that.k != null) return false;
        if (na != null ? !na.equals(that.na) : that.na != null) return false;
        if (mg != null ? !mg.equals(that.mg) : that.mg != null) return false;
        if (lu != null ? !lu.equals(that.lu) : that.lu != null) return false;
        if (fe != null ? !fe.equals(that.fe) : that.fe != null) return false;
        if (i != null ? !i.equals(that.i) : that.i != null) return false;
        if (zn != null ? !zn.equals(that.zn) : that.zn != null) return false;
        if (se != null ? !se.equals(that.se) : that.se != null) return false;
        if (cu != null ? !cu.equals(that.cu) : that.cu != null) return false;
        if (fu != null ? !fu.equals(that.fu) : that.fu != null) return false;
        if (cr != null ? !cr.equals(that.cr) : that.cr != null) return false;
        if (mn != null ? !mn.equals(that.mn) : that.mn != null) return false;
        if (mu != null ? !mu.equals(that.mu) : that.mu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (ageScope != null ? ageScope.hashCode() : 0);
        result = 31 * result + (bodyHorizontal != null ? bodyHorizontal.hashCode() : 0);
        result = 31 * result + (factor != null ? factor.hashCode() : 0);
        result = 31 * result + (energy != null ? energy.hashCode() : 0);
        result = 31 * result + (protein != null ? protein.hashCode() : 0);
        result = 31 * result + (fat != null ? fat.hashCode() : 0);
        result = 31 * result + (cho != null ? cho.hashCode() : 0);
        result = 31 * result + (vitA != null ? vitA.hashCode() : 0);
        result = 31 * result + (vitamineD != null ? vitamineD.hashCode() : 0);
        result = 31 * result + (vitamineE != null ? vitamineE.hashCode() : 0);
        result = 31 * result + (vitamineK != null ? vitamineK.hashCode() : 0);
        result = 31 * result + (thiamin != null ? thiamin.hashCode() : 0);
        result = 31 * result + (riboflavin != null ? riboflavin.hashCode() : 0);
        result = 31 * result + (vitamineB6 != null ? vitamineB6.hashCode() : 0);
        result = 31 * result + (vitamineB12 != null ? vitamineB12.hashCode() : 0);
        result = 31 * result + (vitamineB5 != null ? vitamineB5.hashCode() : 0);
        result = 31 * result + (folicAcid != null ? folicAcid.hashCode() : 0);
        result = 31 * result + (niacin != null ? niacin.hashCode() : 0);
        result = 31 * result + (choline != null ? choline.hashCode() : 0);
        result = 31 * result + (vitamineH != null ? vitamineH.hashCode() : 0);
        result = 31 * result + (vitamineC != null ? vitamineC.hashCode() : 0);
        result = 31 * result + (ca != null ? ca.hashCode() : 0);
        result = 31 * result + (p != null ? p.hashCode() : 0);
        result = 31 * result + (k != null ? k.hashCode() : 0);
        result = 31 * result + (na != null ? na.hashCode() : 0);
        result = 31 * result + (mg != null ? mg.hashCode() : 0);
        result = 31 * result + (lu != null ? lu.hashCode() : 0);
        result = 31 * result + (fe != null ? fe.hashCode() : 0);
        result = 31 * result + (i != null ? i.hashCode() : 0);
        result = 31 * result + (zn != null ? zn.hashCode() : 0);
        result = 31 * result + (se != null ? se.hashCode() : 0);
        result = 31 * result + (cu != null ? cu.hashCode() : 0);
        result = 31 * result + (fu != null ? fu.hashCode() : 0);
        result = 31 * result + (cr != null ? cr.hashCode() : 0);
        result = 31 * result + (mn != null ? mn.hashCode() : 0);
        result = 31 * result + (mu != null ? mu.hashCode() : 0);
        return result;
    }
}
