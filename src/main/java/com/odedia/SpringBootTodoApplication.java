package com.odedia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
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
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Configuration
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoApplication.class, args);
	}

	@Bean
	public HttpTraceRepository htttpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

}


@Component
class RestRepositoryConfigurator implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Todo.class);
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
