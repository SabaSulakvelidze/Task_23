package com.example.task_23.model.response;

import com.example.task_23.model.entity.RestaurantEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private RestaurantEntity restaurantEntity;
}
