package dev.neel.ProductService;

import dev.neel.ProductService.inheritancedemo.singletable.MentorRepository;
import dev.neel.ProductService.inheritancedemo.singletable.Mentor_st;
import dev.neel.ProductService.inheritancedemo.singletable.UserRepository;
import dev.neel.ProductService.inheritancedemo.singletable.User_st;
import dev.neel.ProductService.models.Category;
import dev.neel.ProductService.models.Price;
import dev.neel.ProductService.models.Product;

import dev.neel.ProductService.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	MentorRepository mentorRepository;
	UserRepository userRepository;

	public ProductServiceApplication(MentorRepository mentorRepository,UserRepository userRepository){
		this.mentorRepository =mentorRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		Mentor_st mentor_st=new Mentor_st();
		mentor_st.setName("Neel");
		mentor_st.setEmail("neel@gmail.com");
		mentor_st.setAvgRating(4.65);
		
		mentorRepository.save(mentor_st);

		User_st user_st=new User_st();
		user_st.setName("Namam");
		user_st.setEmail("naman@gmail.com");

		userRepository.save(user_st);
		
	}

	


}
