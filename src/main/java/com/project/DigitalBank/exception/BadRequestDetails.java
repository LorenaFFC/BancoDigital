package com.project.DigitalBank.exception;

import java.time.LocalDate;

public class BadRequestDetails extends ExceptionBase{

    public BadRequestDetails(String titulo, int status, String details, String developerMessage, LocalDate timestamp) {
        super(titulo, status, details, developerMessage, timestamp);

    }
}
