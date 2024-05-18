package org.ptvinh203.bcserver.util.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDataResponse {
    private int errCode;
    private Object data;
    private String message;

    public static ApiDataResponse success(Object data, String message) {
        return ApiDataResponse.builder().errCode(0).data(data).message(message).build();
    }

    public static ApiDataResponse successWithDataOnly(Object data) {
        return ApiDataResponse.builder().errCode(0).data(data).build();
    }

    public static ApiDataResponse error(String message) {
        return ApiDataResponse.builder().errCode(1).message(message).build();
    }
}
