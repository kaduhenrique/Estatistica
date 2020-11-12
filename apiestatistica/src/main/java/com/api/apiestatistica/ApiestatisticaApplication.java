package com.api.apiestatistica;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiestatisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiestatisticaApplication.class, args);
		System.out.println(LocalDateTime.now());
	}

}
