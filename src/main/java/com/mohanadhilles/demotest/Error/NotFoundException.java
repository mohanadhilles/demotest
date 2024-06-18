package com.mohanadhilles.demotest.Error;

import org.springframework.http.HttpStatus;


public class NotFoundException extends ApiBaseException{
    

    /**
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }


    /**
     * @return
     */
    @Override
    public HttpStatus getStatusCode()
    {
        return HttpStatus.NOT_FOUND;
    }

}
