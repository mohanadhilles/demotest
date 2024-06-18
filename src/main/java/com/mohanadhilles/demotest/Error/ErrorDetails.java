package com.mohanadhilles.demotest.Error;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


public class ErrorDetails {
    
    private String message;
    private String uri;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    private Date timestapm;


    public ErrorDetails()
    {
        this.timestapm = new Date();
    }
    
    public ErrorDetails(String message, String uri) {
        this();
        this.message = message;
        this.uri = uri;
    }
    public String getMessage() {
        
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
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
