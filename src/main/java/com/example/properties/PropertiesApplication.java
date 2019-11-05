package com.example.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PropertiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
	}
}

@Component
class CommandLineAppStartupRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

	private TestProperties properties;

	CommandLineAppStartupRunner(TestProperties properties) {
		this.properties = properties;
	}

	@Override
	public void run(String... args) {
		logger.info("Loaded {} test property containers", properties.getContainers().size());
	}
}
