package dev.spring.boot.HelloWorld;

import dev.spring.boot.HelloWorld.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/create")
    ResponseEntity<Todo> createToDo(@RequestBody Todo todo){
        return new ResponseEntity<>(toDoService.createTodo(todo), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    ResponseEntity<Todo> getToDoById(@PathVariable Long id){
        try{
            Todo CreatedTodo = toDoService.getTodoById(id);
            return new ResponseEntity<>(CreatedTodo, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<List<Todo>>(toDoService.getAllToDo(),HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity <Page<Todo>> getAllTodobyPage(@RequestParam int pageNo, @RequestParam int size){
        return new ResponseEntity<>(toDoService.getAllByPage(pageNo,size),HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Todo> updateToDo(@RequestBody Todo todo){
        return new ResponseEntity<>(toDoService.updateTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    void deleteToDoById(@PathVariable Long id){
        toDoService.deleteById(id);
    }
}
