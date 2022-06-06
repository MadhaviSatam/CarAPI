package com.mscar.car;

import com.mscar.car.data.Car;
import com.mscar.car.exception.CarApiException;
import com.mscar.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Car REST controller
 */
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    /**
     * Retrieve Car details from H2 database for provided card id
     * @param id
     * @return Car
     */
    @GetMapping("/{id}")
    Car getCar(@PathVariable Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new CarApiException(HttpStatus.NOT_FOUND.value()));
    }

    /**
     * Create new car in H2 database
     * @param customer
     * @return Car
     */
    @PostMapping("")
    Car createCar(@Valid @RequestBody Car customer) {
        return carRepository.save(customer);
    }

    /**
     * Update car details in the H2 database for provided car id
     * @param inputCustomer
     * @param id
     * @return Car
     */
    @PutMapping("/{id}")
    Car updateCar(@Valid @RequestBody Car inputCustomer, @PathVariable Long id) {

        return carRepository.findById(id)
                .map(customer -> {
                    customer.setMake(inputCustomer.getMake());
                    customer.setModel(inputCustomer.getModel());
                    customer.setVersion(inputCustomer.getVersion());
                    customer.setNumberOfDoors(inputCustomer.getNumberOfDoors());
                    customer.setGrossPrice(inputCustomer.getGrossPrice());
                    customer.setNettPrice(inputCustomer.getNettPrice());
                    customer.setMileage(inputCustomer.getMileage());
                    customer.setCo2Emission(inputCustomer.getCo2Emission());
                    return carRepository.save(customer);
                }).orElseThrow(() ->
                        new CarApiException(HttpStatus.NOT_FOUND.value()));
    }

    /**
     * Delete car from H2 database for provided car id
     * @param id
     */
    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }
}
