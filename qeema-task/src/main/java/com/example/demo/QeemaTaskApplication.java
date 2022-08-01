package com.example.demo;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;



import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
@ComponentScan("com.example.*")
public class QeemaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(QeemaTaskApplication.class, args);
	}

	


}
