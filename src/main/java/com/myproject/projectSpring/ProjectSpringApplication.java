package com.myproject.projectSpring;

import com.myproject.projectSpring.entities.Profession;
import com.myproject.projectSpring.entities.User;
import com.myproject.projectSpring.repositories.ProfessionRepository;
import com.myproject.projectSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class ProjectSpringApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfessionRepository professionRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {


//		Category cat1 = new Category(null, "Electronics");
//		Category cat2 = new Category(null, "Books");
		Profession profession1 = new Profession(null,"Programmer","Desenvolve programas ");
		Profession profession2 = new Profession(null,"Teacher","Ensinamento e desenvolvimento disciplinar ");
		User user1 = new User(null,"Wesley Roberts",profession1);
		User user2 = new User(null,"Taynam Beatriz",profession2);
//		categoryRepository.save(cat1);
//		categoryRepository.save(cat2);
		professionRepository.save(profession1);
		professionRepository.save(profession2);
		userRepository.save(user1);
		userRepository.save(user2);

	}


}

