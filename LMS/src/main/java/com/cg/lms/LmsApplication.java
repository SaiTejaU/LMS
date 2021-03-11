package com.cg.lms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@ComponentScan(basePackages= {"com.cg.lms.controller","com.cg.lms.servicesimpl","com.cg.lms.service"})
@EnableSwagger2
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}
}