package com.odedia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
@CrossOrigin(origins = "*")
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoApplication.class, args);
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
@CrossOrigin(origins = "*")
interface TodoRepository extends JpaRepository<Todo, Long> {
}

@Slf4j
@RepositoryEventHandler(Todo.class)
@Component
class TaskEventHandler {
	@Autowired
	private StreamBridge streamBridge;

	@HandleBeforeCreate()
	public void handleBeforeCreate(Todo todo) {
		log.info("Probably fine...");
	}

	@HandleBeforeSave
	public void handleBeforeSave(Todo todo) {
		log.info("Saving todo: {}", todo.getTitle());

		if (todo.getCompleted()) {
			log.info("Sending Completed Todo event for: {}", todo.getTitle());
			streamBridge.send("output", "The following task was completed: " + todo.getTitle());
		}
		log.info("Completed saving todo: {}", todo.getTitle());
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
		return Gauge.builder("todos.total", repo::count).tag("kind", "performance")
				.description("Todos total count!!!").register(registry);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

    @Bean
    public HttpTraceRepository htttpTraceRepository() {
            return new InMemoryHttpTraceRepository();
    }
}

@Configuration 
@EnableWebMvc 
class CorsConfig implements WebMvcConfigurer { 
	@Override 
	public void addCorsMappings(CorsRegistry registry) { 
		registry.addMapping("/**").allowedOrigins("http://todo-ui.default.tanzutime.com/").allowedMethods("*");
	} 
}


