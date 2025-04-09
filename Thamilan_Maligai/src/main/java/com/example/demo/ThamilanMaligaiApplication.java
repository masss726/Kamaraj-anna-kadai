package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.model"})
@ComponentScan(basePackages= {"com.example.MasilaMainController","com.example.repository"})
public class ThamilanMaligaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThamilanMaligaiApplication.class, args);
	}

}
