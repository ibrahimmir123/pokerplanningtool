package com.example.pokerplanningtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokerPlanningToolApplication {

	public static void main(String[] args) {

		System.out.println("Started");
		SpringApplication.run(PokerPlanningToolApplication.class, args);
		System.out.println("Ended");
	}

}
