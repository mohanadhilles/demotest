package com.mohanadhilles.demotest.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mohanadhilles.demotest.Security.AppUser;

public abstract  class BaseController {


    public AppUser getCurrentUser()
    {
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AppUser) authentication.getPrincipal();

    }
}

