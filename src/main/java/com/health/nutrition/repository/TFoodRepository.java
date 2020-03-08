package com.health.nutrition.repository;

import com.health.nutrition.entity.TFoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TFoodRepository extends JpaRepository<TFoodEntity,Long>{

    TFoodEntity getTFoodEntityByCode(String code);

    Optional<List<TFoodEntity>> findByNameContaining (String foodName);

    @Query(value = "select distinct t_inq.food_code, t_inq.food_name, t_food_tags.food_tag from t_food_tags join t_food on t_food_tags.food_code = t_food.code join t_inq on t_food_tags.food_code = t_inq.food_code where t_food.classify_code in :foodCategoryList order by t_inq.id",nativeQuery = true)
    List<Object[]> findFoodInqCombinedCategoryResult(@Param("foodCategoryList") List<String> foodCategoryList);

    @Query(value = "select distinct t_inq.food_code, t_inq.food_name, t_food_tags.food_tag from t_food_tags join t_food on t_food_tags.food_code = t_food.code join t_inq on t_food_tags.food_code = t_inq.food_code WHERE t_inq.food_name LIKE CONCAT('%', :keyword,'%') order by t_inq.id;",nativeQuery = true)
    List<Object[]> searchFoodByKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT t_food.code, t_food.name, t_inq.nutrient_name, t_inq.inq, t_food_tags.food_tag FROM t_food JOIN t_inq ON t_food.code = t_inq.food_code JOIN t_food_tags ON t_food.code = t_food_tags.food_code",nativeQuery = true)
    List<Object[]> findFoodInqCombinedResult();



}
