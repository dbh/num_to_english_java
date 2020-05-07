package com.davidbharrison.restfun.num_to_english;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan
//@ComponentScan({"com.davidbharrison.restfun.num_to_english.service.NumToEnglishService"})
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.davidbharrison.restfun.num_to_english"})
public class NumToEnglishApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NumToEnglishApplication.class, args);
	}

}
