package com.kban.nbaapp.nbascoresapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NbaScoresAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NbaScoresAppApplication.class, args);

//		// Print out the names of all the beans in the context
//		String[] beanNames = context.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}
}
