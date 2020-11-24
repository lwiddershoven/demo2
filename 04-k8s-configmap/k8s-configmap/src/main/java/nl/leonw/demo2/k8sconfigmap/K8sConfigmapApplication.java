package nl.leonw.demo2.k8sconfigmap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Configuration
@SpringBootApplication
public class K8sConfigmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sConfigmapApplication.class, args);
	}

	@Bean
	public CommandLineRunner onStartup(Environment env) {
		return args -> log.info("XXX {}", env.getProperty("test.property"));
	}
}
