package dev.spring.boot.HelloWorld;

import org.springframework.stereotype.Component;

@Component
public class ToDoRepository {
    String getAllToDos(){
        return "All ToDos";
    }
}
