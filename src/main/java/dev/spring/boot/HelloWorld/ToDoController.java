package dev.spring.boot.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/get")
    String getToDo(){
        toDoService.printTodos();
        return "Got the ToDo";
    }

    //Path Variable
    @GetMapping("/{id}")
    String getToDoWithId(@PathVariable long id){
        return "Got the ToDo with ID " + id;
    }

    @PutMapping("/{id}")
    String updateToDoWithId(@PathVariable long id){
        return "Update the ToDo with ID " + id;
    }

    @DeleteMapping("/{id}")
    String deleteToDoWithId(@PathVariable long id){
        return "Deleted the ToDo with ID " + id;
    }

    //Request Param
    @GetMapping("")
    String getToDoWithIdParam(@RequestParam("name") long id){
        return "Got the ToDo with ID " + id;
    }

    @PostMapping("/login")
    String LoginAccount(@RequestBody String body){
        return body;
    }
}
