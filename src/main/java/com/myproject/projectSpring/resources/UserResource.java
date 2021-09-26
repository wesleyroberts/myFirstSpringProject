package com.myproject.projectSpring.resources;

import com.myproject.projectSpring.entities.User;
import com.myproject.projectSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<User>save(@RequestBody User user){
        User userResult = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResult);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
