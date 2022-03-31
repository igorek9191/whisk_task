package model.getErrorResponse;

import lombok.Data;

@Data
public class GetErrorResponse {
    private String code;
    private String error_code;
    private String message;
}
