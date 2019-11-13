package com.example.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PropertiesApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(PropertiesApplication.class)
				.listeners(new StartupEventListener())
				.run(args);
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

class StartupEventListener implements ApplicationListener<ApplicationEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(StartupEventListener.class);
	private long startTime;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationStartingEvent) {
			startTime = System.nanoTime();
		}
		if (event instanceof ApplicationReadyEvent) {
			long readyTime = System.nanoTime();
			Duration duration = Duration.ofNanos(readyTime - startTime);
			LOG.info("Application started in {}m {}s",
					duration.toMinutes(),
					duration.getSeconds() - TimeUnit.MINUTES.toSeconds(duration.toMinutes()));
		}
	}
}