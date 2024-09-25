package com.globallogic.kitchensink.members.infrastructure.config;

import com.globallogic.kitchensink.members.application.exception.MemberAlreadyRegisteredException;
import com.globallogic.kitchensink.members.application.exception.MemberNotFoundException;
import com.globallogic.kitchensink.members.infrastructure.adapter.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MemberControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException exception) {

        FieldError fieldError = (FieldError) exception.getBindingResult()
                .getAllErrors()
                .stream()
                .findFirst()
                .orElseThrow();

        return ResponseEntity.badRequest().body(
                buildErrorResponse(fieldError.getDefaultMessage())
        );
    }

    private ErrorResponse buildErrorResponse(String message) {

        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                message
        );
    }

    @ExceptionHandler(MemberAlreadyRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleMemberAlreadyRegisteredException(
            MemberAlreadyRegisteredException exception) {
        return ResponseEntity.badRequest()
                .body(buildErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMemberNotFoundException(MemberNotFoundException exception) {
        return ResponseEntity.badRequest()
                .body(buildErrorResponse(exception.getMessage()));
    }
}
