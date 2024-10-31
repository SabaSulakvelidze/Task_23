package com.example.task_23.repository;

import com.example.task_23.model.entity.EmployeeEntity;
import com.example.task_23.model.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    @Override
    Page<RestaurantEntity> findAll(Pageable pageable);
}
