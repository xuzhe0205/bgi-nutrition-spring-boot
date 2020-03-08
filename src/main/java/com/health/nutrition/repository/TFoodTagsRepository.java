package com.health.nutrition.repository;

import com.health.nutrition.entity.TFoodTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TFoodTagsRepository extends JpaRepository<TFoodTagsEntity, Long> {

//    @Modifying
//    @Query(value = "INSERT INTO t_food_tags (food_code, food_tag) values (:foodCode, :foodTag)", nativeQuery = true)
//    void addFoodTag(@Param("foodCode") String foodCode, @Param("foodTag") String foodTag);


}
