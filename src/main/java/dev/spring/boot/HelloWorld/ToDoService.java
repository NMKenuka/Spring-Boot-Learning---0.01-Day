package dev.spring.boot.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired

    private ToDoRepository toDoRepository;

    public void printTodos(){
        System.out.println(toDoRepository.getAllToDos());
    }
}
