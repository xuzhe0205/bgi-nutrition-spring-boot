package com.health.nutrition.repository;

import com.health.nutrition.entity.TInqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TInqRepository extends JpaRepository<TInqEntity, Long> {

    @Query(value = "SELECT customer_id FROM t_inq", nativeQuery = true)
    List<Integer> findAllCustomerId();



}
