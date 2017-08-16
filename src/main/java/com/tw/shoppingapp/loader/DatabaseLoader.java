package com.tw.shoppingapp.loader;

import com.tw.shoppingapp.entity.Category;
import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.CategoryRepository;
import com.tw.shoppingapp.gateways.user.inmemory.User;
import com.tw.shoppingapp.gateways.user.inmemory.UserRepository;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.Date;

@Component
public class DatabaseLoader implements CommandLineRunner {


	private final ProductRepository productRepository;

	private final UserRepository userRepository;

	@Autowired
	public DatabaseLoader(ProductRepository productRepository, UserRepository userRepository) {
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.productRepository.save(new Product("Spectacles", "Awesome Spectacles", 10.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
		this.productRepository.save(new Product("Shirt", "Awesome Shirt", 20.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
		this.productRepository.save(new Product("Pants", "Awesome Pants", 30.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));
		this.productRepository.save(new Product("Belt", "Awesome Belt", 40.2D, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLjO4vMxSkwHP4N9i-3FPsbBrJ4oBzYI97LMAHsebHAY_Q_WEL", 2, "Apparels"));

		this.userRepository.save(new User("Someone1", "someone1@fsd.com", "hello1", "mypass1", "myaddress1", "8902342", "sometype", "M", new Date(), "myPan", 2, 2));
		this.userRepository.save(new User("Someone2", "someone2@fsd.com", "hello2", "mypass2", "myaddress2", "8902342", "sometype", "F", new Date(), "myPan", 2, 2));
		this.userRepository.save(new User("Someone3", "someone3@fsd.com", "hello3", "mypass3", "myaddress3", "8902342", "sometype", "F", new Date(), "myPan", 2, 2));
		this.userRepository.save(new User("Someone4", "someone4@fsd.com", "hello4", "mypass4", "myaddress4", "8902342", "sometype", "M", new Date(), "myPan", 2, 2));
		this.userRepository.save(new User("Someone5", "someone5@fsd.com", "hello5", "mypass5", "myaddress5", "8902342", "sometype", "M", new Date(), "myPan", 2, 2));
	}
}