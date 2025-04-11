package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.model"})
@ComponentScan(basePackages= {"com.example.MasilaMainController"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
public class ThamilanMaligaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThamilanMaligaiApplication.class, args);
	}

}
