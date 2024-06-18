package com.mohanadhilles.demotest.Services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.mohanadhilles.demotest.Error.ConflictException;
import com.mohanadhilles.demotest.Error.NotFoundException;
import com.mohanadhilles.demotest.Models.Todo;
import com.mohanadhilles.demotest.Repositories.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * @return
     */
    public List<Todo> get() {
        return todoRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    public Todo getById(int id) {
        try {
            return todoRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NotFoundException(String.format("this id [%s] not found", id));
        }

    }

    /**
     * @param todo
     * @return
     */
    public Todo insert(Todo todo) {
        if (todo.getTitle() != null && todoRepository.findByTitle(todo.getTitle()) != null) {
            throw new ConflictException("Another record found");
        }
        return todoRepository.save(todo);
    }

    /**
     * @param id
     * @return
     */
    public void delete(int id) {
        todoRepository.deleteById(id);
    }


    public List<Todo> findByUserId(int userId)
    {
       return todoRepository.findByUserId(userId);
    }
}
