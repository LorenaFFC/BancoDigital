package com.project.DigitalBank.exception;

import java.time.LocalDate;

public class ExceptionBase {
    protected String Titulo;
    protected int Status;
    protected String Details;
    protected String DeveloperMessage;
    protected LocalDate Timestamp;

    public ExceptionBase() {
    }

    public ExceptionBase(String titulo, int status, String details, String developerMessage, LocalDate timestamp) {
        Titulo = titulo;
        Status = status;
        Details = details;
        DeveloperMessage = developerMessage;
        Timestamp = timestamp;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getDeveloperMessage() {
        return DeveloperMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        DeveloperMessage = developerMessage;
    }

    public LocalDate getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        Timestamp = timestamp;
    }
}
