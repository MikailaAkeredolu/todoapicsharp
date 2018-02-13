package io.mikaila.todocsharp;

import io.mikaila.todocsharp.controllers.TodoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodocsharpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodocsharpApplication.class, args);
	}

}








//	public static void main(String[] args) {
//		ApplicationContext ctx = SpringApplication.run(TodocsharpApplication.class, args);
//		TodoController controller = (TodoController) ctx.getBean("todoController");
//		controller.getAll();
//		controller.create(ctx.);
//	}