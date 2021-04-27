package com.project.DigitalBank.exception;

import java.time.LocalDate;

public class ValidationException extends  ExceptionBase {

    private String Fields;
    private String FieldsMessage;


    public ValidationException(String titulo, int status, String details, String developerMessage, LocalDate timestamp, String fields, String fieldsMessage) {
        super(titulo, status, details, developerMessage, timestamp);
        Fields = fields;
        FieldsMessage = fieldsMessage;
    }

    public String getFields() {
        return Fields;
    }

    public void setFields(String fields) {
        Fields = fields;
    }

    public String getFieldsMessage() {
        return FieldsMessage;
    }

    public void setFieldsMessage(String fieldsMessage) {
        FieldsMessage = fieldsMessage;
    }
}
