package com.odedia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.fasterxml.jackson.annotation.JsonInclude;

import brave.sampler.Sampler;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		System.out.println(System.getProperty("\n\n\n-----------------\n\n\n"));
		System.out.println(System.getProperty("POSTGRES_URL"));
		System.out.println(System.getProperty("POSTGRES_USER"));
		System.out.println(System.getProperty("POSTGRES_PASS"));
		System.out.println(System.getProperty("\n\n\n-----------------\n\n\n"));
		SpringApplication.run(SpringBootTodoApplication.class, args);
	}

	@GetMapping("/slow")
	public String slowRequest() throws InterruptedException{ 
		Thread.sleep(250);
		return "ok";
	}
}

@Entity
@Data
@NoArgsConstructor
class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@NonNull
	private String title;
	private Boolean completed = false;
}

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
interface TodoRepository extends JpaRepository<Todo, Long> { 
}

@Slf4j
@RepositoryEventHandler(Todo.class)
@Component
class TaskEventHandler {
	@HandleBeforeSave
	public void handleBeforeSave(Todo todo) {
		log.debug("Saving todo: {}", todo.getTitle());
		if (todo.getCompleted()) {
			log.info("This Todo is completed: {}", todo.getTitle());
		}
		log.debug("Completed saving todo: {}", todo.getTitle());
	}
}

@Component
class RestRepositoryConfigurator implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Todo.class);
	}
}


@Component
@Endpoint(id = "todos")
@RequiredArgsConstructor
class AccessLogActuator {
	@Autowired 
	TodoRepository repo;

	@ReadOperation
	public AccessLogActuatorValues get() {
		return new AccessLogActuatorValues(repo.count());
	}
}

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class AccessLogActuatorValues {
	private final long total;
}

/**
 * Export metrics to Micrometer.
 */
@Configuration
@RequiredArgsConstructor
class AccessLogMicrometer {
	
	@Bean
	public Gauge accessLogCounter(MeterRegistry registry, TodoRepository repo) {
		return Gauge.builder("todos.total", () -> repo.count()).tag("kind", "performance")
				.description("Todos total count!").register(registry);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
