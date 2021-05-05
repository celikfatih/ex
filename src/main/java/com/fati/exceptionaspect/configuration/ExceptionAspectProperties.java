package com.fati.exceptionaspect.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * author @ fati
 * created @ 24.03.2021
 */

@Setter
@Getter
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = ExceptionAspectProperties.PREFIX)
public class ExceptionAspectProperties {
    public static final String PREFIX = "exception.aspect";

    @NotEmpty String defaultExceptionCode;
}
