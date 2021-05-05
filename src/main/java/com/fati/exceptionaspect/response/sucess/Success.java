package com.fati.exceptionaspect.response.sucess;

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
public class Success<T> implements Serializable {
    private static final long serialVersionUID = -4575140589776660957L;
    T data;
}
