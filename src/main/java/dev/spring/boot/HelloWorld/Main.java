package dev.spring.boot.HelloWorld;

public class Main {
    public static void main(String[] args) {
        ToDoService toDoService = new ToDoService();
        toDoService.printTodos();
    }
}
