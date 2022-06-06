package com.mscar.car.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * JPA Entity - Car
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    private @Id
    @GeneratedValue Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "MAKE_MISSING")
    @Size(max = 50, message = "MAKE_EXCEEDED_MAX_LENGTH")
    private String make;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "MODEL_MISSING")
    @Size(max = 50, message = "MODEL_EXCEEDED_MAX_LENGTH")
    private String model;
    @Column(length = 2)
    @NotBlank(message = "VERSION_MISSING")
    @Size(max = 2, message = "VERSION_EXCEEDED_MAX_LENGTH")
    private String version;
    private int numberOfDoors;
    @Column(precision = 2, scale = 2)
    @DecimalMin(value = "0.0" , inclusive = true , message = "INVALID_CO2_EMISSION")
    @Digits(integer = 2, fraction=2 , message= "INVALID_CO2_EMISSION")
    private double co2Emission;
    @Column(nullable = false , scale = 2)
    @DecimalMin(value = "0.0" , inclusive = false , message = "INVALID_GROSS_PRICE")
    @Digits(integer = 15, fraction=2 , message= "INVALID_GROSS_PRICE")
    private double grossPrice;
    @Column(nullable = false , scale = 2)
    @DecimalMin(value = "0.0" , inclusive = false , message = "INVALID_NETT_PRICE")
    @Digits(integer = 15, fraction=2 , message= "INVALID_NETT_PRICE")
    private double nettPrice;
    @Column(nullable = false)
    private long mileage;

    public Car(String make, String model, String version,
               int numberOfDoors, double co2Emission,
               double grossPrice, double nettPrice,
               long mileage) {
        this.make = make;
        this.model = model;
        this.version = version;
        this.numberOfDoors = numberOfDoors;
        this.co2Emission = co2Emission;
        this.grossPrice = grossPrice;
        this.nettPrice = nettPrice;
        this.mileage = mileage;
    }
}
