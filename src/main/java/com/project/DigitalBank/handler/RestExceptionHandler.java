package com.project.DigitalBank.handler;
import com.project.DigitalBank.exception.BadRequestDetails;
import com.project.DigitalBank.exception.BadRequestException;
import com.project.DigitalBank.exception.ExceptionBase;
import com.project.DigitalBank.exception.ValidationException;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends  ResponseEntityExceptionHandler {

private BindingResult bindingResult;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestDetails> handleBadRequestException(BadRequestException br) {
        return new ResponseEntity<>(
                new BadRequestDetails(
                        "Bad Request Exception",
                        HttpStatus.BAD_REQUEST.value(),
                        br.getMessage(),
                        br.getClass().getName(),
                        LocalDate.now()
                ), HttpStatus.BAD_REQUEST
        );
    }

    //@ExceptionHandler(MethodArgumentNotValidException.class)
    //public ResponseEntity<ValidationException> handlerMethodArgumentNotValidException(MethodArgumentNotValidException mnv){
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError> fieldsError = ex.getBindingResult().getFieldErrors();
        String fields = fieldsError.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldsError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                new ValidationException(
                        "Bad Request Exception, Invalid Fields",
                        HttpStatus.BAD_REQUEST.value(),
                        "Analise os campos com error",
                        ex.getClass().getName(),
                        LocalDate.now(),
                        fields,
                        fieldsMessage
                ), HttpStatus.BAD_REQUEST
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {


        BadRequestDetails bd = new BadRequestDetails(
                ex.getCause().getMessage(),
                status.value(),
                ex.getMessage(),
                ex.getClass().getName(),
                LocalDate.now()
        );


        return new ResponseEntity<>(bd, headers, status);
    }


    @ExceptionHandler({ DataIntegrityViolationException.class } )
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {

       return  new ResponseEntity<>(
       // ExceptionBase base =
                new ExceptionBase(
                "Operação não permitida",
                HttpStatus.CONFLICT.value(),
                "Analisar campos duplicados",
                ex.getRootCause().getMessage(),
                LocalDate.now()
        ), HttpStatus.CONFLICT);

    }



}





