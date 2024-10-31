package com.example.task_23.service;

import com.example.task_23.exception.ResourceNotFoundException;
import com.example.task_23.mapper.EmployeeMapper;
import com.example.task_23.model.entity.EmployeeEntity;
import com.example.task_23.model.request.EmployeeRequest;
import com.example.task_23.model.response.EmployeeResponse;
import com.example.task_23.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest){
        return EmployeeMapper.mapEntityToResponse(employeeRepository.save(EmployeeMapper.mapRequestToEntity(employeeRequest)));
    }

    public EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest){
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id %d was not found".formatted(employeeId)));
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeEntity.setEmail(employeeRequest.getEmail());
        employeeEntity.setSalary(employeeRequest.getSalary());
        return EmployeeMapper.mapEntityToResponse(employeeRepository.save(employeeEntity));
    }

    public Page<EmployeeResponse> getAllEmployees(Integer pageNumber, Integer pageSize, Sort.Direction direction, String sortBy) {
        return employeeRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by(direction,sortBy)))
                .map(EmployeeMapper::mapEntityToResponse);
    }

    public EmployeeResponse getEmployeeById(Long employeeId){
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id %d was not found".formatted(employeeId)));
        return EmployeeMapper.mapEntityToResponse(employeeEntity);
    }

    public String deleteEmployeeById(Long employeeId){
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id %d was not found".formatted(employeeId)));
        employeeRepository.delete(employeeEntity);
        return "Employee with id %d was deleted".formatted(employeeId);
    }
}
