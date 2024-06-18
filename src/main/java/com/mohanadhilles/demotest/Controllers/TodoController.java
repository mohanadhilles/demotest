package com.mohanadhilles.demotest.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohanadhilles.demotest.Models.Todo;
import com.mohanadhilles.demotest.Services.TodoService;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController extends BaseController{

   
    private final TodoService todoService;
    

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * @return
     */
    @GetMapping(value = { "", "/" })
    public ResponseEntity<List<Todo>> index() {
        List<Todo> result = todoService.findByUserId(getCurrentUser().getId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> show(@PathVariable int id) {
        Todo result = todoService.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * @param todo
     * @return
     */
    @PostMapping(value = { "", "/" })
    public ResponseEntity<Todo> insert(@RequestBody Todo todo) {

        todo.setUserId(getCurrentUser().getId());
        Todo result = todoService.insert(todo);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
