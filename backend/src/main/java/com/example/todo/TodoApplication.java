package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
public class TodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
class TodoController {
    private List<Todo> todos = new ArrayList<>();
    private Long nextId = 1L;
    
    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }
    
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }
    
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("message", "Backend is running!");
        return status;
    }
}

class Todo {
    private Long id;
    private String title;
    private boolean completed = false;
    
    // Constructors
    public Todo() {}
    public Todo(String title) { this.title = title; }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}