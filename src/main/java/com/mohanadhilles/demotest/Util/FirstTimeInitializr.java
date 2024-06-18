package com.mohanadhilles.demotest.Util;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mohanadhilles.demotest.Security.AppUser;
import com.mohanadhilles.demotest.Security.UserService;

@Component
public class FirstTimeInitializr implements CommandLineRunner{


    private final Log logger = LogFactory.getLog(FirstTimeInitializr.class);

    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        if (userService.get().isEmpty()) {
            logger.info("No users found!");
            AppUser user = new AppUser("muhilles@gmail.com", "12345678", "Mohanad Hilles");
            userService.save(user);
        }
        
    }
    
    
}
