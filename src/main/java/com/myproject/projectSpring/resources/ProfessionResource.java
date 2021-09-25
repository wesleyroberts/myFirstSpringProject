package com.myproject.projectSpring.resources;

import com.myproject.projectSpring.entities.Profession;
import com.myproject.projectSpring.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profission")
public class ProfessionResource {

    @Autowired
    private ProfessionRepository professionRepository;

    @CrossOrigin
    @GetMapping(value="/all")
    public ResponseEntity<List<Profession>> findAll(){
        List<Profession> list = professionRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Profession>findById(@PathVariable Long id){
        Profession profession = professionRepository.findById(id).get();
        return ResponseEntity.ok().body(profession);
    }

    @CrossOrigin
    @PostMapping(value = "/post")
    public ResponseEntity<Profession> post(@RequestBody Profession profission){
        professionRepository.save(profission);
        return ResponseEntity.ok().body(profission);
    }

}
