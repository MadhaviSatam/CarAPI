package com.mscar.car.repository;

import com.mscar.car.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Car JPA repository
 */
public interface CarRepository extends JpaRepository<Car, Long> {

}
