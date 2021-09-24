package com.myproject.projectSpring.resources;

import com.myproject.projectSpring.entities.User;
import com.myproject.projectSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.EntityReference;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios  ")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<List<User>> findall(){
        List list = userRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(Long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }
}
