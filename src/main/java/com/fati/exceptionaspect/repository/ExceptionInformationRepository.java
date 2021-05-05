package com.fati.exceptionaspect.repository;

import com.fati.exceptionaspect.model.ExceptionInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * author @ fati
 * created @ 25.03.2021
 */

public interface ExceptionInformationRepository extends CrudRepository<ExceptionInformation, Long> {
    ExceptionInformation getByCode(String code);
}
