package com.myproject.projectSpring.repositories;

import com.myproject.projectSpring.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,Long> {

}
