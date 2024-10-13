package gm.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "gm.rh.repositorio")
public class RhApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhApplication.class, args);
	}

}
