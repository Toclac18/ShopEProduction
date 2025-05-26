package main.ShopEProduction.Common.Exception;

import main.ShopEProduction.Common.Error.ErrorHandler;
import main.ShopEProduction.Common.Response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value  = Exception.class)
    ResponseEntity<ApiResponse> ExceptionHandler(Exception e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorHandler.UNCATEGORIED_ERROR.getErrorCode());
        apiResponse.setMessage(ErrorHandler.UNCATEGORIED_ERROR.getErrorMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value  = RuntimeException.class)
    ResponseEntity<ApiResponse> RunTimeExceptionHandler(Exception e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(1000);
        apiResponse.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value  = ExceptionFormat.class)
    ResponseEntity<ApiResponse> RunTimeExceptionHandler(ExceptionFormat e) {
        ErrorHandler errorCode = e.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getErrorCode());
        apiResponse.setMessage(errorCode.getErrorMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> ArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String errorKeyCode = e.getBindingResult().getFieldError().getDefaultMessage();
        ErrorHandler errorCode = ErrorHandler.INVALID_KEY;
        try  {
            errorCode = ErrorHandler.valueOf(errorKeyCode);
        } catch (IllegalArgumentException ex) {

        }
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getErrorCode());
        apiResponse.setMessage(errorCode.getErrorMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
