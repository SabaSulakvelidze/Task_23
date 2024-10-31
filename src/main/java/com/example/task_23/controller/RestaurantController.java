package com.example.task_23.controller;

import com.example.task_23.model.request.RestaurantRequest;
import com.example.task_23.model.response.RestaurantResponse;
import com.example.task_23.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
@AllArgsConstructor
public class RestaurantController {
    RestaurantService restaurantService;

    @GetMapping
    public Page<RestaurantResponse> getAllRestaurants(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                      @RequestParam(defaultValue = "5") Integer pageSize,
                                                      @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                                      @RequestParam(defaultValue = "id") String sortBy) {
        return restaurantService.getAllRestaurants(pageNumber, pageSize, direction, sortBy);
    }

    @GetMapping("/{employeeId}")
    public RestaurantResponse getRestaurantById(@PathVariable long employeeId) {
        return restaurantService.getRestaurantById(employeeId);
    }

    @PostMapping
    public RestaurantResponse createRestaurant(@RequestBody RestaurantRequest employeeRequest) {
        return restaurantService.createRestaurant(employeeRequest);
    }

    @PutMapping("/{employeeId}")
    public RestaurantResponse updateProduct(@PathVariable Long employeeId, @RequestBody RestaurantRequest employeeRequest) {
        return restaurantService.updateRestaurant(employeeId, employeeRequest);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteProduct(@PathVariable Long employeeId) {
        return restaurantService.deleteRestaurantById(employeeId);
    }
}
