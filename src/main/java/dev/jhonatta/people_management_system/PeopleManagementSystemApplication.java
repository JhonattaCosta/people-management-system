package dev.jhonatta.people_management_system;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleManagementSystemApplication {

	public static void main(String[] args) {
		//Load the variables from the .env file.
		Dotenv dotenv = Dotenv.configure().load();

		//Set the environment variables in the system.
		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		SpringApplication.run(PeopleManagementSystemApplication.class, args);
	}

}
