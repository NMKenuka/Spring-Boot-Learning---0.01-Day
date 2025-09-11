package dev.spring.boot.HelloWorld;

import dev.spring.boot.HelloWorld.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Long> {

}

