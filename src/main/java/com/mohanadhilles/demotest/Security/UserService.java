package com.mohanadhilles.demotest.Security;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohanadhilles.demotest.Error.NotFoundException;
import com.mohanadhilles.demotest.Repositories.UserRepository;

@Configuration
@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByEmail(username);
        if (user == null) {
            throw new NotFoundException("user not found");
        }
        return user;
    }

    /**
     * @param user
     */
    public void save(AppUser user)
    {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public List<AppUser> get()
    {
        return userRepository.findAll();
    }


    
}
