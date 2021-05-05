package com.fati.exceptionaspect.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * author @ fati
 * created @ 24.03.2021
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionInformation implements Serializable {

    private static final long serialVersionUID = -76416584089466588L;

    @Id
    Long id;
    Integer status;
    String message;
    String code;
    String language;
}
