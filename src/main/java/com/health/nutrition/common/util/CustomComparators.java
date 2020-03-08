package com.health.nutrition.common.util;

import com.health.nutrition.entity.TFoodNutrientInqEntity;
import com.health.nutrition.entity.TInqEntity;

import java.util.Comparator;

public class CustomComparators {

    public static Comparator<TInqEntity> nutrientINQComparator = new Comparator<TInqEntity>() {
        @Override
        public int compare(TInqEntity o1, TInqEntity o2) {
            if (o1.getInq() == null && o2.getInq() != null){
                return -1;
            }
            if (o1.getInq() == null && o2.getInq() == null){
                return 0;
            }
            if (o1.getInq() != null && o2.getInq() == null){
                return 1;
            }
            else{
                if (o1.getInq() > o2.getInq()){
                    return -1;
                }
                else if (o1.getInq() < o2.getInq()){
                    return 1;
                }
                else{
                    return 0;
                }
            }

        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodGLGIComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {

            if (o2.getGl() != o1.getGl()){
                if (o2.getGl()  == null && o1.getGl() != null){
                    return -1;
                }
                else if (o1.getGl()  == null && o2.getGl() != null){
                    return 1;
                }
                return o1.getGl() - o2.getGl();
            }
            else{
                if (o2.getGl()  == null && o1.getGl() == null){
                    return 0;
                }
                else if (o2.getGi()  == null && o1.getGi() == null){
                    return 0;
                }
                else if (o2.getGi()  != null && o1.getGi() == null){
                    return 1;
                }
                else if (o2.getGi()  == null && o1.getGi() != null){
                    return -1;
                }
                return o1.getGi() - o2.getGi();
            }
        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodCholesterolSFAComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {
            if (o1.getCholesterol() == null && o2.getCholesterol() != null){
                return 1;
            }
            if (o1.getCholesterol() == null && o2.getCholesterol() == null){
                return 0;
            }
            if (o1.getCholesterol() != null && o2.getCholesterol() == null){
                return -1;
            }
            if (o1.getCholesterol() != null && o2.getCholesterol() != null){
                if (o1.getCholesterol() > o2.getCholesterol()){
                    return 1;
                }
                else if (o1.getCholesterol() < o2.getCholesterol()){
                    return -1;
                }
                else{
                    if (o1.getSfa() == null && o2.getSfa() != null){
                        return 1;
                    }
                    if (o1.getSfa() == null && o2.getSfa() == null){
                        return 0;
                    }
                    if (o1.getSfa() != null && o2.getSfa() == null){
                        return -1;
                    }
                    if (o1.getSfa() != null && o2.getSfa() != null) {
                        if (o1.getSfa() > o2.getSfa()) {
                            return 1;
                        } else if (o1.getSfa() < o2.getSfa()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
            return 0;
        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodCaKMgINQComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {
            if (o1.getCaKMgInq() == null && o2.getCaKMgInq() != null){
                return 1;
            }
            if (o1.getCaKMgInq() == null && o2.getCaKMgInq() == null){
                return 0;
            }
            if (o1.getCaKMgInq() != null && o2.getCaKMgInq() == null){
                return -1;
            }
            if (o1.getCaKMgInq() != null && o2.getCaKMgInq() != null){
                if (o1.getCaKMgInq() > o2.getCaKMgInq()){

                    return -1;
                }
                else if (o1.getCaKMgInq()< o2.getCaKMgInq()){

                    return 1;
                }
                System.out.println("o1 food name: " + o1.getFoodName() + ", o1 cakmg: " + o1.getCaKMgInq() + "; o2 food name: " + o2.getFoodName() + ", o2 cakmg: " + o2.getCaKMgInq());
                return 0;
            }
            return 0;

        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodPurineComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {

            if (o1.getPurine() == null && o2.getPurine() != null){
                return 1;
            }
            if (o1.getPurine() == null && o2.getPurine() == null){
                return 0;
            }
            if (o1.getPurine() != null && o2.getPurine() == null){
                return -1;
            }
            if (o1.getPurine() != null && o2.getPurine() != null){
                if (o1.getPurine() < o2.getPurine()){
                    return -1;
                }
                else if (o1.getPurine() > o2.getPurine()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            return 0;
        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodPregnantEarlyComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {
            if (o1.getFolicAcidI() == null && o2.getFolicAcidI()!= null){
                return 1;
            }
            if (o1.getFolicAcidI() == null && o2.getFolicAcidI() == null){
                return 0;
            }
            if (o1.getFolicAcidI() != null && o2.getFolicAcidI() == null){
                return -1;
            }
            if (o1.getFolicAcidI() != null && o2.getFolicAcidI() != null){
                if (o1.getFolicAcidI() < o2.getFolicAcidI()){
                    return 1;
                }
                else if (o1.getFolicAcidI() > o2.getFolicAcidI()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            return 0;
        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodPregnantMediumLateComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {
            if (o1.getFeCaI() == null && o2.getFeCaI()!= null){
                return 1;
            }
            if (o1.getFeCaI() == null && o2.getFeCaI() == null){
                return 0;
            }
            if (o1.getFeCaI() != null && o2.getFeCaI() == null){
                return -1;
            }
            if (o1.getFeCaI() != null && o2.getFeCaI() != null){
                if (o1.getFeCaI() < o2.getFeCaI()){
                    return 1;
                }
                else if (o1.getFeCaI() > o2.getFeCaI()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            return 0;
        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodBreastfeedingComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {
            if (o1.getVitaACaProteinI() == null && o2.getVitaACaProteinI()!= null){
                return 1;
            }
            if (o1.getVitaACaProteinI() == null && o2.getVitaACaProteinI() == null){
                return 0;
            }
            if (o1.getVitaACaProteinI() != null && o2.getVitaACaProteinI() == null){
                return -1;
            }
            if (o1.getVitaACaProteinI() != null && o2.getVitaACaProteinI() != null){
                if (o1.getVitaACaProteinI() < o2.getVitaACaProteinI()){
                    return 1;
                }
                else if (o1.getVitaACaProteinI() > o2.getVitaACaProteinI()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            return 0;
        }
    };

    public static Comparator<TFoodNutrientInqEntity> foodNaComparator = new Comparator<TFoodNutrientInqEntity>() {
        @Override
        public int compare(TFoodNutrientInqEntity o1, TFoodNutrientInqEntity o2) {
            Double naINQ1 = 0.0;
            Double naINQ2 = 0.0;
            for (TInqEntity tInqEntity : o1.getNutrientInqEntityList()){
                if (tInqEntity.getNutrientName() == "na"){
                    naINQ1 = tInqEntity.getInq();
                }
            }
            for (TInqEntity tInqEntity : o2.getNutrientInqEntityList()){
                if (tInqEntity.getNutrientName() == "na"){
                    naINQ2 = tInqEntity.getInq();
                }
            }
            if (naINQ1 == null && naINQ2 != null){
                return 1;
            }
            if (naINQ1 == null && naINQ2 == null){
                return 0;
            }
            if (naINQ1 != null && naINQ2 == null){
                return -1;
            }
            if (naINQ1 != null && naINQ2 != null){
                if (naINQ1 > naINQ2){
                    return 1;
                }
                else if (naINQ1 < naINQ2){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            return 0;

        }
    };


}
