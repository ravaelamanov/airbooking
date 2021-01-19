package com.airbooking.exceptions;

import com.airbooking.ui.models.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleAppException(Exception ex, WebRequest webRequest) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus status;
        if (ex instanceof ResourceNotFoundException) {
            status = HttpStatus.NOT_FOUND;
            return handleResourceNotFoundException((ResourceNotFoundException) ex, httpHeaders, status, webRequest);
        } else throw ex;
    }

    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                     HttpHeaders httpHeaders,
                                                                     HttpStatus status,
                                                                     WebRequest webRequest) {
        String uri = webRequest.getDescription(false);
        ErrorMessage errorMessage = new ErrorMessage("services-0001", ex.getMessage(), "Ensure you provide correct entity ID!", uri);
        return handleExceptionInternal(ex, errorMessage, httpHeaders, status, webRequest);
    }

}
