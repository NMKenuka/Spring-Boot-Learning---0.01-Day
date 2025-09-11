package dev.spring.boot.HelloWorld;

import dev.spring.boot.HelloWorld.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public Todo createTodo(Todo todo){
        return toDoRepository.save(todo);
    }

    public Todo getTodoById(Long id){
        return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public List<Todo> getAllToDo(){
        return toDoRepository.findAll();
    }

    public Page<Todo> getAllByPage(int pageNo, int size){
        Pageable pageable = PageRequest.of(pageNo-1,size);
        return toDoRepository.findAll(pageable);
    }

    public Todo updateTodo(Todo todo){
        return toDoRepository.save(todo);
    }

    public void deleteById(Long id){
        toDoRepository.delete(getTodoById(id));
    }
}


