package com.health.nutrition.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_food_meal_category", schema = "nutritiondb", catalog = "")
public class TFoodMealCategoryEntity {
    private int id;
    private Byte timeInDay;
    private String clazz;
    private Byte classCode;
    private String subClass;
    private Byte subclassCode;
    private String foodName;
    private String foodCode;
    private Byte choiceNumber;
    private String note;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time_in_day")
    public Byte getTimeInDay() {
        return timeInDay;
    }

    public void setTimeInDay(Byte timeInDay) {
        this.timeInDay = timeInDay;
    }

    @Basic
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "class_code")
    public Byte getClassCode() {
        return classCode;
    }

    public void setClassCode(Byte classCode) {
        this.classCode = classCode;
    }

    @Basic
    @Column(name = "sub_class")
    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    @Basic
    @Column(name = "subclass_code")
    public Byte getSubclassCode() {
        return subclassCode;
    }

    public void setSubclassCode(Byte subclassCode) {
        this.subclassCode = subclassCode;
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
    @Column(name = "food_code")
    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    @Basic
    @Column(name = "choice_number")
    public Byte getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(Byte choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFoodMealCategoryEntity that = (TFoodMealCategoryEntity) o;

        if (id != that.id) return false;
        if (timeInDay != null ? !timeInDay.equals(that.timeInDay) : that.timeInDay != null) return false;
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (classCode != null ? !classCode.equals(that.classCode) : that.classCode != null) return false;
        if (subClass != null ? !subClass.equals(that.subClass) : that.subClass != null) return false;
        if (subclassCode != null ? !subclassCode.equals(that.subclassCode) : that.subclassCode != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (choiceNumber != null ? !choiceNumber.equals(that.choiceNumber) : that.choiceNumber != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timeInDay != null ? timeInDay.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (classCode != null ? classCode.hashCode() : 0);
        result = 31 * result + (subClass != null ? subClass.hashCode() : 0);
        result = 31 * result + (subclassCode != null ? subclassCode.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (choiceNumber != null ? choiceNumber.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
