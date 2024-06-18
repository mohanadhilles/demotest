package com.mohanadhilles.demotest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohanadhilles.demotest.Security.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByEmail(String username);
}
