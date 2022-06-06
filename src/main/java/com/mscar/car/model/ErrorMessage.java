package com.mscar.car.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Model for Error message
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private String code;
    private String message;

}
