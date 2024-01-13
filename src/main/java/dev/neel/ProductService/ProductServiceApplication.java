package dev.neel.ProductService;

import dev.neel.ProductService.inheritancedemo.singletable.MentorRepository;
import dev.neel.ProductService.inheritancedemo.singletable.Mentor_st;
import dev.neel.ProductService.inheritancedemo.singletable.UserRepository;
import dev.neel.ProductService.inheritancedemo.singletable.User_st;
import dev.neel.ProductService.models.Category;
import dev.neel.ProductService.models.Price;
import dev.neel.ProductService.models.Product;
import dev.neel.ProductService.repositories.CategoryRepository;
import dev.neel.ProductService.repositories.OrderRepository;
import dev.neel.ProductService.repositories.PriceRepository;
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
	ProductRepository productRepository;
	CategoryRepository categoryRepository;
	OrderRepository orderRepository;
	PriceRepository priceRepository;

	public ProductServiceApplication(MentorRepository mentorRepository,UserRepository userRepository,
	ProductRepository productRepository,CategoryRepository categoryRepository,OrderRepository orderRepository,
	PriceRepository priceRepository){
		this.mentorRepository =mentorRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.orderRepository =	orderRepository;
		this.priceRepository =	priceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// Mentor_st mentor_st=new Mentor_st();
		// mentor_st.setName("Neel");
		// mentor_st.setEmail("neel@gmail.com");
		// mentor_st.setAvgRating(4.65);
		
		// mentorRepository.save(mentor_st);

		// User_st user_st=new User_st();
		// user_st.setName("Namam");
		// user_st.setEmail("naman@gmail.com");

		// userRepository.save(user_st);
		

		Category category=new Category();
		category.setName("Apple Products");
		// Category savedCategory=categoryRepository.save(category);

		Price price=new Price();
		price.setCurrency("Rupee");
		price.setPrice(100000.00);
		// Price savedPrice=priceRepository.save(price);

		Product product=new Product();
		product.setCategory(category);
		product.setPrice(price);
		product.setTitle("iPhone15");
		product.setImage("https://apple.com");
		product.setDescription("New iphone");

		Product saveProduct=productRepository.save(product);

		productRepository.deleteById(UUID.fromString("659cde1a-556f-4a75-b59c-0b777563c10f"));
		System.out.println("product and related price is deleted");

		Optional<Price> getPrice=priceRepository.findById(UUID.fromString("93cf5349-1849-4d9e-8b00-72e3b81b1e78"));
		System.out.println(getPrice.toString());
		System.out.println(saveProduct.getUuid()+" "+saveProduct.getCategory().getUuid()+" "+saveProduct.getPrice().getUuid());





	
		
	}

	


}
