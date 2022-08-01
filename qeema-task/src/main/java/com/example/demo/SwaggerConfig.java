package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	   @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.example")).build()              
	          .apiInfo(apiInfo());
	    }
	    
	    private ApiInfo apiInfo() {
	    	//new Api
	    	
	    	return new ApiInfo("Ecommerce Management System"
	    			, "App For Demo", "Version 1.0", "abc", "ahmed.badry515@gmail.com", "ahmed.badry515@gmail.com", "abc");
	   
	    
	    	
	    }
}
