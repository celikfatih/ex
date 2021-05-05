package com.fati.exceptionaspect.aspect;

import com.fati.exceptionaspect.configuration.ExceptionAspectProperties;
import com.fati.exceptionaspect.model.ExceptionInformation;
import com.fati.exceptionaspect.repository.ExceptionInformationRepository;
import com.fati.exceptionaspect.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * author @ fati
 * created @ 25.03.2021
 */

@Aspect
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(ExceptionAspectProperties.class)
public class ExceptionAspect {
    protected final ExceptionAspectProperties properties;
    protected final ExceptionInformationRepository repository;

    @Pointcut(value = "@annotation(com.fati.exceptionaspect.annotation.CustomizedException)")
    public void annotatedMethods() {}

    @Pointcut(value = "execution(public * (@com.fati.exceptionaspect.annotation.CustomizedException *).*(..))")
    public void annotatedClasses() {}

    @Around(value = "annotatedClasses() || annotatedMethods()")
    public Response around(ProceedingJoinPoint jp) throws Throwable {
        Response response;
        try {
            Object proceed = jp.proceed();
            response = Response.createSuccessResponse(proceed);
        } catch (Exception e) {
            ExceptionInformation information = Optional.ofNullable(repository.getByCode(e.getMessage()))
                    .orElseGet(() -> repository.getByCode(properties.getDefaultExceptionCode()));
            log.error("Exception: ", e);
            response = Response.createFailureResponse(information);
        }
        return response;
    }
}
