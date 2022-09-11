package gvc.application.gvcmanagement;

import gvc.application.gvcmanagement.model.Role;
import gvc.application.gvcmanagement.model.User;
import gvc.application.gvcmanagement.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class GvcmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GvcmanagementApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "MEMBERS"));
			userService.saveRole(new Role(null, "MANAGER"));
			userService.saveRole(new Role(null, "GUEST"));


			userService.saveUser(new User(null, "Cong Nhat", "nhcnguyen", "nhcnguyen@gmail.com", "password@123", new ArrayList<>()));
			userService.saveUser(new User(null, "Cong Nhat 1", "nhcnguyen1", "nhcnguyen@gmail.com", "password@123", new ArrayList<>()));
			userService.saveUser(new User(null, "Cong Nhat 2", "nhcnguyen2", "nhcnguyen@gmail.com", "password@123", new ArrayList<>()));

			userService.addRoleToUser("nhcnguyen", "ADMIN");
			userService.addRoleToUser("nhcnguyen", "MEMBERS");
			userService.addRoleToUser("nhcnguyen1", "MANAGER");
			userService.addRoleToUser("nhcnguyen1", "MEMBERS");
			userService.addRoleToUser("nhcnguyen2", "GUEST");
			userService.addRoleToUser("nhcnguyen2", "MEMBERS");
		};
	}

}
