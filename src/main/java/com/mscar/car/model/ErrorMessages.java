package com.mscar.car.model;

/**
 * Model for Error messages
 */
public enum ErrorMessages {

    INTERNAL_SERVER_ERROR("Internal server error occurred"),
    MAKE_MISSING("Make field is missing"),
    MAKE_EXCEEDED_MAX_LENGTH("Make field exceeded max length"),
    MODEL_MISSING("Model field is missing"),
    MODEL_EXCEEDED_MAX_LENGTH("Model field exceeded max length"),
    VERSION_MISSING("Version field is missing"),
    VERSION_EXCEEDED_MAX_LENGTH("Version field exceeded max length"),
    INVALID_CO2_EMISSION("Invalid value for CO2 emission"),
    INVALID_GROSS_PRICE("Invalid value for gross price"),
    INVALID_NETT_PRICE("Invalid value for net price");

    private final String value;

    ErrorMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
