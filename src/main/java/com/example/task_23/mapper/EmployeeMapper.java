package com.example.task_23.mapper;

import com.example.task_23.model.entity.EmployeeEntity;
import com.example.task_23.model.request.EmployeeRequest;
import com.example.task_23.model.response.EmployeeResponse;

public class EmployeeMapper {
    public static EmployeeResponse mapEntityToResponse(EmployeeEntity employeeEntity) {
        return new EmployeeResponse(employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getEmail(),
                employeeEntity.getSalary(),
                employeeEntity.getRestaurantEntity());
    }

    public static EmployeeEntity mapRequestToEntity(EmployeeRequest employeeRequest) {
        return new EmployeeEntity(null,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail(),
                employeeRequest.getSalary(),
                employeeRequest.getRestaurantEntity());
    }

}
