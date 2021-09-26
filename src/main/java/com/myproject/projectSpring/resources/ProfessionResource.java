package com.myproject.projectSpring.resources;

import com.myproject.projectSpring.entities.Profession;
import com.myproject.projectSpring.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/profission")
public class ProfessionResource {

    @Autowired
    private ProfessionRepository professionRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Profession>> findAll(){
        List<Profession> list = professionRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profession>findById(@PathVariable Long id){
        Profession profission = professionRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(profission);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<Profession> post(@RequestBody Profession profission){
        professionRepository.save(profission);
        return ResponseEntity.status(HttpStatus.CREATED).body(profission);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        professionRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
