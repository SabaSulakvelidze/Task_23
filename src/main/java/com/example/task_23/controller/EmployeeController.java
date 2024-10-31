package com.example.task_23.controller;

import com.example.task_23.model.request.EmployeeRequest;
import com.example.task_23.model.response.EmployeeResponse;
import com.example.task_23.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping
    public Page<EmployeeResponse> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                  @RequestParam(defaultValue = "5") Integer pageSize,
                                                  @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                                  @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getAllEmployees(pageNumber, pageSize, direction, sortBy);
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse getEmployeeById(@PathVariable long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping("/{employeeId}")
    public EmployeeResponse updateProduct(@PathVariable Long employeeId, @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.updateEmployee(employeeId, employeeRequest);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteProduct(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }
}
