package com.fati.exceptionaspect.response;

import com.fati.exceptionaspect.model.ExceptionInformation;
import com.fati.exceptionaspect.response.failure.Failure;
import com.fati.exceptionaspect.response.sucess.Success;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * author @ fati
 * created @ 26.03.2021
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    private static final long serialVersionUID = 1368093464110197845L;

    Success<Object> success;
    Failure error;

    public static Response createSuccessResponse(Object data) {
        Success<Object> success = new Success<>(data);
        return Response.builder().success(success).build();
    }

    public static Response createFailureResponse(ExceptionInformation information) {
        return Response.builder()
                .error(new Failure(
                        information.getStatus(),
                        information.getMessage(),
                        Integer.parseInt(information.getCode()),
                        information.getMessage()))
                .build();
    }
}
