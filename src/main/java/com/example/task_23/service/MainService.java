package com.example.task_23.service;

import com.example.task_23.model.entity.EmployeeEntity;
import com.example.task_23.model.entity.RestaurantEntity;
import com.example.task_23.repository.EmployeeRepository;
import com.example.task_23.repository.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MainService {

    EmployeeRepository employeeRepository;
    RestaurantRepository restaurantRepository;

    @PostConstruct
    public void insertDataInToDatabase() {
        EmployeeEntity John = new EmployeeEntity(null, "John", "Doe", "john.doe@example.com", 65000.00, null);
        EmployeeEntity Jane = new EmployeeEntity(null, "Jane", "Smith", "jane.smith@example.com", 70000.00, null);
        EmployeeEntity Robert = new EmployeeEntity(null, "Robert", "Brown", "robert.brown@example.com", 68000.00, null);
        EmployeeEntity Emily = new EmployeeEntity(null, "Emily", "White", "emily.white@example.com", 72000.00, null);
        EmployeeEntity Michael = new EmployeeEntity(null, "Michael", "Johnson", "michael.johnson@example.com", 75000.00, null);
        EmployeeEntity Sarah = new EmployeeEntity(null, "Sarah", "Davis", "sarah.davis@example.com", 69000.00, null);
        EmployeeEntity David = new EmployeeEntity(null, "David", "Wilson", "david.wilson@example.com", 73000.00, null);
        EmployeeEntity Linda = new EmployeeEntity(null, "Linda", "Thompson", "linda.thompson@example.com", 66000.00, null);
        EmployeeEntity Daniel = new EmployeeEntity(null, "Daniel", "Harris", "daniel.harris@example.com", 67000.00, null);
        EmployeeEntity Karen = new EmployeeEntity(null, "Karen", "Clark", "karen.clark@example.com", 74000.00, null);

        employeeRepository.save(John);
        employeeRepository.save(Jane);
        employeeRepository.save(Robert);
        employeeRepository.save(Emily);
        employeeRepository.save(Michael);
        employeeRepository.save(Sarah);
        employeeRepository.save(David);
        employeeRepository.save(Linda);
        employeeRepository.save(Daniel);
        employeeRepository.save(Karen);

        RestaurantEntity supra = new RestaurantEntity(null, "Supra", List.of(John,Jane));
        RestaurantEntity MtskhetasTaste = new RestaurantEntity(null, "Mtskheta's Taste", List.of(Robert,Emily));
        RestaurantEntity HouseofKhinkali = new RestaurantEntity(null, "House of Khinkali", List.of(Michael,Sarah,David));
        RestaurantEntity Badagi = new RestaurantEntity(null, "Badagi", List.of(Linda,Daniel,Karen));
        RestaurantEntity Javakhuri = new RestaurantEntity(null, "Javakhuri", List.of());

        restaurantRepository.save(supra);
        restaurantRepository.save(MtskhetasTaste);
        restaurantRepository.save(HouseofKhinkali);
        restaurantRepository.save(Badagi);
        restaurantRepository.save(Javakhuri);


    }
}
