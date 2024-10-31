package com.example.task_23.model.request;

import com.example.task_23.model.entity.RestaurantEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private RestaurantEntity restaurantEntity;
}
