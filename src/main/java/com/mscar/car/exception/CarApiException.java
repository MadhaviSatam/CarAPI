package com.mscar.car.exception;

import com.mscar.car.model.ErrorWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Exception for Car API
 */
@AllArgsConstructor
@Data
public class CarApiException extends RuntimeException {
    private ErrorWrapper errors;
    private Integer status;

    public CarApiException(Integer status) {
        super();
        this.status = status;
    }
}
