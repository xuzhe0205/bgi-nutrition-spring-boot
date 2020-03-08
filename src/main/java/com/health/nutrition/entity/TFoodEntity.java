package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food", schema = "nutritiondb", catalog = "")
public class TFoodEntity {
    private long id;
    private String code;
    private String name;
    private String defaultName;
    private String alias;
    private String classify;
    private String classifyCode;
    private String subgenera;
    private String subgeneraCode;
    private String subclass;
    private String subclassCode;
    private Integer standardQuality;
    private Byte unit;
    private Double convertQuality;
    private Byte unit2;
    private Double convertQuality2;
    private Byte unit3;
    private Double convertQuality3;
    private String origin;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 50)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "default_name", nullable = true, length = 60)
    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @Basic
    @Column(name = "alias", nullable = true, length = 100)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "classify", nullable = true, length = 60)
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Basic
    @Column(name = "classify_code", nullable = true, length = 32)
    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
    }

    @Basic
    @Column(name = "subgenera", nullable = true, length = 60)
    public String getSubgenera() {
        return subgenera;
    }

    public void setSubgenera(String subgenera) {
        this.subgenera = subgenera;
    }

    @Basic
    @Column(name = "subgenera_code", nullable = true, length = 32)
    public String getSubgeneraCode() {
        return subgeneraCode;
    }

    public void setSubgeneraCode(String subgeneraCode) {
        this.subgeneraCode = subgeneraCode;
    }

    @Basic
    @Column(name = "subclass", nullable = true, length = 60)
    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    @Basic
    @Column(name = "subclass_code", nullable = true, length = 32)
    public String getSubclassCode() {
        return subclassCode;
    }

    public void setSubclassCode(String subclassCode) {
        this.subclassCode = subclassCode;
    }

    @Basic
    @Column(name = "standard_quality", nullable = true)
    public Integer getStandardQuality() {
        return standardQuality;
    }

    public void setStandardQuality(Integer standardQuality) {
        this.standardQuality = standardQuality;
    }

    @Basic
    @Column(name = "unit", nullable = true)
    public Byte getUnit() {
        return unit;
    }

    public void setUnit(Byte unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "convert_quality", nullable = true, precision = 2)
    public Double getConvertQuality() {
        return convertQuality;
    }

    public void setConvertQuality(Double convertQuality) {
        this.convertQuality = convertQuality;
    }

    @Basic
    @Column(name = "unit2", nullable = true)
    public Byte getUnit2() {
        return unit2;
    }

    public void setUnit2(Byte unit2) {
        this.unit2 = unit2;
    }

    @Basic
    @Column(name = "convert_quality2", nullable = true, precision = 2)
    public Double getConvertQuality2() {
        return convertQuality2;
    }

    public void setConvertQuality2(Double convertQuality2) {
        this.convertQuality2 = convertQuality2;
    }

    @Basic
    @Column(name = "unit3", nullable = true)
    public Byte getUnit3() {
        return unit3;
    }

    public void setUnit3(Byte unit3) {
        this.unit3 = unit3;
    }

    @Basic
    @Column(name = "convert_quality3", nullable = true, precision = 2)
    public Double getConvertQuality3() {
        return convertQuality3;
    }

    public void setConvertQuality3(Double convertQuality3) {
        this.convertQuality3 = convertQuality3;
    }

    @Basic
    @Column(name = "origin", nullable = true, length = 40)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
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

        TFoodEntity that = (TFoodEntity) o;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (defaultName != null ? !defaultName.equals(that.defaultName) : that.defaultName != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (classify != null ? !classify.equals(that.classify) : that.classify != null) return false;
        if (classifyCode != null ? !classifyCode.equals(that.classifyCode) : that.classifyCode != null) return false;
        if (subgenera != null ? !subgenera.equals(that.subgenera) : that.subgenera != null) return false;
        if (subgeneraCode != null ? !subgeneraCode.equals(that.subgeneraCode) : that.subgeneraCode != null)
            return false;
        if (subclass != null ? !subclass.equals(that.subclass) : that.subclass != null) return false;
        if (subclassCode != null ? !subclassCode.equals(that.subclassCode) : that.subclassCode != null) return false;
        if (standardQuality != null ? !standardQuality.equals(that.standardQuality) : that.standardQuality != null)
            return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (convertQuality != null ? !convertQuality.equals(that.convertQuality) : that.convertQuality != null)
            return false;
        if (unit2 != null ? !unit2.equals(that.unit2) : that.unit2 != null) return false;
        if (convertQuality2 != null ? !convertQuality2.equals(that.convertQuality2) : that.convertQuality2 != null)
            return false;
        if (unit3 != null ? !unit3.equals(that.unit3) : that.unit3 != null) return false;
        if (convertQuality3 != null ? !convertQuality3.equals(that.convertQuality3) : that.convertQuality3 != null)
            return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (defaultName != null ? defaultName.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (classify != null ? classify.hashCode() : 0);
        result = 31 * result + (classifyCode != null ? classifyCode.hashCode() : 0);
        result = 31 * result + (subgenera != null ? subgenera.hashCode() : 0);
        result = 31 * result + (subgeneraCode != null ? subgeneraCode.hashCode() : 0);
        result = 31 * result + (subclass != null ? subclass.hashCode() : 0);
        result = 31 * result + (subclassCode != null ? subclassCode.hashCode() : 0);
        result = 31 * result + (standardQuality != null ? standardQuality.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (convertQuality != null ? convertQuality.hashCode() : 0);
        result = 31 * result + (unit2 != null ? unit2.hashCode() : 0);
        result = 31 * result + (convertQuality2 != null ? convertQuality2.hashCode() : 0);
        result = 31 * result + (unit3 != null ? unit3.hashCode() : 0);
        result = 31 * result + (convertQuality3 != null ? convertQuality3.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
