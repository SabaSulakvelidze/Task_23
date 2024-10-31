package com.example.task_23.mapper;

import com.example.task_23.model.entity.RestaurantEntity;
import com.example.task_23.model.request.RestaurantRequest;
import com.example.task_23.model.response.RestaurantResponse;

public class RestaurantMapper {

    public static RestaurantResponse mapEntityToResponse(RestaurantEntity restaurantEntity) {
        return new RestaurantResponse(restaurantEntity.getId(), restaurantEntity.getRestaurantName(), restaurantEntity.getEmployeeEntities());
    }

    public static RestaurantEntity mapRequestToEntity(RestaurantRequest restaurantRequest) {
        return new RestaurantEntity(null, restaurantRequest.getRestaurantName(), null);
    }
}
