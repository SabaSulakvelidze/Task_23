package com.example.task_23.model.request;

import com.example.task_23.model.entity.EmployeeEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RestaurantRequest {
    private String restaurantName;
    private List<EmployeeEntity> employeeEntities;
}
