package com.mohanadhilles.demotest.Error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ValidationError {


    private List<String> errors;

    private String uri;


    public ValidationError() {
        this.timestapm = new Date();
        this.errors = new ArrayList<>();
    }

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    private Date timestapm;


    public void addError(String error)
    {
        this.errors.add(error);
    }
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimestapm() {
        return timestapm;
    }

    public void setTimestapm(Date timestapm) {
        this.timestapm = timestapm;
    }


}
