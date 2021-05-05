package com.fati.exceptionaspect.response.failure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * author @ fati
 * created @ 26.03.2021
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Failure implements Serializable {
    private static final long serialVersionUID = -6868064606712971342L;

    int statusCode;
    String message;
    int errorCode;
    String detailMessage;
}
