package com.example.task_23.model.response;

import com.example.task_23.model.entity.EmployeeEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantResponse {
    private Long id;
    private String restaurantName;
    private List<EmployeeEntity> employeeEntities;
}
