package com.rvweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rvweb.course.entities.Category;
import com.rvweb.course.entities.Order;
import com.rvweb.course.entities.User;
import com.rvweb.course.entities.enums.OrderStatus;
import com.rvweb.course.repositories.CategoryRepositary;
import com.rvweb.course.repositories.OrderRepositary;
import com.rvweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	// ja vai resolver um dependencia e associar a um instancia do userRepository
	private UserRepository userRepository;
	@Autowired
	private OrderRepositary orderRepositary;

	@Autowired
	private CategoryRepositary categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		// tudo que tiver dentro deste metodo vai ser executado

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		userRepository.saveAll(Arrays.asList(u1, u2));

		orderRepositary.saveAll(Arrays.asList(o1, o2, o3));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

	}
}
