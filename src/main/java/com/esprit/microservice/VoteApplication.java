package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication


@EnableDiscoveryClient

public class VoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}
	
	//Afficher la liste des candidats
	//http://localhost:8181/candidats
	@Bean
	ApplicationRunner init(VoteRepository repository) {
		return args -> {
			Stream.of("Mariem", "Sarra", "Mohamed").forEach(content -> {
				repository.save(new Vote(content, "20/03/2022"));
			});
			repository.findAll().forEach(System.out::println);
		};

	}
}
