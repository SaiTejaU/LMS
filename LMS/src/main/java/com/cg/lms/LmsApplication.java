package com.cg.lms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This application is a digital platform for a library.
 * It is developed by a team of four developers lead by Sai Teja U
 * Developers: Monica KB, Shanthiya L, Harhsit S and Sai Teja.
 * Date: 12-03-2021
 * @author Sai Teja
 * @version 1.0
 * 
 *
 */


@SpringBootApplication
@ComponentScan(basePackages= {"com.cg.lms.controller","com.cg.lms.servicesimpl","com.cg.lms.service"})
@EnableSwagger2
public class LmsApplication {
	/**The main class which is the starting point of the entire application
	 * @param args is of type String array. Collects the command line arguments(if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}
}