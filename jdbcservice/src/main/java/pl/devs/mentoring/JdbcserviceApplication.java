package pl.devs.mentoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class JdbcserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcserviceApplication.class, args);
	}

}
