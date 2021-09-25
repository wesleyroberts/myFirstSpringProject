package com.myproject.projectSpring.resources;

import com.myproject.projectSpring.entities.Profession;
import com.myproject.projectSpring.entities.User;
import com.myproject.projectSpring.repositories.ProfessionRepository;
import com.myproject.projectSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfessionRepository professionRepository;

    @CrossOrigin
    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }

    @CrossOrigin
    @PostMapping(value = "/Post")
    public ResponseEntity<User>save(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("Success");
    }

}
