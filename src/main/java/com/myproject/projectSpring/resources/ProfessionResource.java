package com.myproject.projectSpring.resources;

import com.myproject.projectSpring.entities.Profession;
import com.myproject.projectSpring.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/profission")
public class ProfessionResource {

    @Autowired
    private ProfessionRepository professionRepository;

    @GetMapping
    public ResponseEntity<List<Profession>> findAll(){
        List list = professionRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profession> findById(Long id){
        Profession profession = professionRepository.findById(id).get();
        return ResponseEntity.ok().body(profession);
    }
}
