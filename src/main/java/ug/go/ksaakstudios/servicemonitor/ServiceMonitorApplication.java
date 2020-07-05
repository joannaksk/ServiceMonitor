package ug.go.ksaakstudios.servicemonitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableScheduling
public class ServiceMonitorApplication {
	private static final Logger log = LoggerFactory.getLogger(ServiceMonitorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceMonitorApplication.class, args);
	}

	@Bean
	public CommandLineRunner run()
			throws Exception {
		return args -> {
			log.info("Hello Service Monitor!");
		};
	}
}
