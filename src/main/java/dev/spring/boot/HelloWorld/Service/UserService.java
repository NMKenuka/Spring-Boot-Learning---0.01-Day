package dev.spring.boot.HelloWorld.Service;

import dev.spring.boot.HelloWorld.Entity.User;
import dev.spring.boot.HelloWorld.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser (User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
