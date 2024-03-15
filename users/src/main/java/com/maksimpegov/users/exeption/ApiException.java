package com.maksimpegov.users.exeption;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@ApiModel(value = "API exception", description = "Api standardized exception format")
public class ApiException {
    private final String error;
    private final String message;
    private final int HttpStatus;
    private final ZonedDateTime timestamp;
}
