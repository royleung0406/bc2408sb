package com.bootcamp2408.ex.sbex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan

	// 1.Spring Bean // Bean (Object)
		// Something like object, but not created by your written class
		// Unique
	// 2. Spring Context
		// -Separated memory area, besides heap memory
		// -Store beans
	// 3. Spring life cycle
		// jar -> spring-boot:run
		// Before Server start, we will lookup which class is being annotated as component
		// i.e. @Controller is a component, so Spring will create an object for this class 



		// Inversion of control (IoC)
public class Sbex1Application {

	public static ConfigurableApplicationContext context;

	
	public static void main(String[] args) {
		context = SpringApplication.run(Sbex1Application.class, args); //7*24
	}

}
