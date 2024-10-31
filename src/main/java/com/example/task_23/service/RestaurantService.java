package com.example.task_23.service;

import com.example.task_23.exception.ResourceNotFoundException;
import com.example.task_23.mapper.RestaurantMapper;
import com.example.task_23.model.entity.RestaurantEntity;
import com.example.task_23.model.request.RestaurantRequest;
import com.example.task_23.model.response.RestaurantResponse;
import com.example.task_23.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RestaurantService {

    RestaurantRepository restaurantRepository;

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest) {
        return RestaurantMapper.mapEntityToResponse(restaurantRepository.save(RestaurantMapper.mapRequestToEntity(restaurantRequest)));
    }

    public RestaurantResponse updateRestaurant(Long restaurantId, RestaurantRequest restaurantRequest) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id %d was not found".formatted(restaurantId)));
        restaurantEntity.setRestaurantName(restaurantRequest.getRestaurantName());
        restaurantEntity.setEmployeeEntities(restaurantRequest.getEmployeeEntities());
        return RestaurantMapper.mapEntityToResponse(restaurantRepository.save(restaurantEntity));
    }

    public Page<RestaurantResponse> getAllRestaurants(Integer pageNumber, Integer pageSize, Sort.Direction direction, String sortBy) {
        return restaurantRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy)))
                .map(RestaurantMapper::mapEntityToResponse);
    }

    public RestaurantResponse getRestaurantById(Long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id %d was not found".formatted(restaurantId)));
        return RestaurantMapper.mapEntityToResponse(restaurantEntity);
    }

    public String deleteRestaurantById(Long restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id %d was not found".formatted(restaurantId)));
        restaurantRepository.delete(restaurantEntity);
        return "Restaurant with id %d was deleted".formatted(restaurantId);
    }
}
