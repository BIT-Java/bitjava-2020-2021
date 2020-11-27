package pl.edu.knbit.bitjava.shop.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(basePackages = {"pl.edu.knbit.bitjava.shop.api"})
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception, WebRequest request) {
        return ResponseEntity.badRequest()
                .body("Internal Server Error");
    }

}
