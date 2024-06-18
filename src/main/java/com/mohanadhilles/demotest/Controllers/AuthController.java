package com.mohanadhilles.demotest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohanadhilles.demotest.Request.UserRequest;
import com.mohanadhilles.demotest.Response.JwtResponse;
import com.mohanadhilles.demotest.Security.UserService;
import com.mohanadhilles.demotest.Util.Token;

@RestController
@RequestMapping(value="/api/v1/auth")
public class AuthController {

    @Autowired
    private Token tokenEr;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = { "", "/" })
    public JwtResponse signIn(@RequestBody UserRequest userRequest)
    {
    
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(userRequest.getUsername(),userRequest.getPassword())
        );

  SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService.loadUserByUsername(userRequest.getUsername());
        String token = tokenEr.generateToken(userDetails);
        JwtResponse response = new JwtResponse(token);
        return response;
    }

}
