package dev.spring.boot.HelloWorld.Controller;

import dev.spring.boot.HelloWorld.Entity.Todo;
import dev.spring.boot.HelloWorld.Service.ToDoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/create")
    ResponseEntity<Todo> createToDo(@RequestBody Todo todo){
        return new ResponseEntity<>(toDoService.createTodo(todo), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo retrieved Successfully"),
            @ApiResponse(responseCode = "404", description = "Todo is not found in this id")
    })
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
