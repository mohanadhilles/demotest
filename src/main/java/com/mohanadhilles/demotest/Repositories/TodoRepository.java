package com.mohanadhilles.demotest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohanadhilles.demotest.Models.Todo;
import java.util.List;



@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> 
{
    
    /**
     * @param title
     * @return
     */
    Todo findByTitle(String title);

    /**
     * @param description
     * @return
     */
    Todo findByDescription(String description);

    /**
     * @param userId
     * @return
     */
    List<Todo> findByUserId(int userId);
}
