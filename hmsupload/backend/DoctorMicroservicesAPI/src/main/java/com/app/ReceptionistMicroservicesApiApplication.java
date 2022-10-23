package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@SpringBootApplication
@EnableEurekaClient
public class ReceptionistMicroservicesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceptionistMicroservicesApiApplication.class, args);
	}
	@Bean
	public WebSecurityConfigurerAdapter webSecurity() {
	    return new WebSecurityConfigurerAdapter() {

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	            http.headers().addHeaderWriter(
	                    new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));


	        }
	    };
	}
}
