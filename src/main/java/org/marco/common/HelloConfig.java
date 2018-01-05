package org.marco.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

	@Bean
	public String greeting() {
		return "World";
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
		String retrievedTextFromContext = "";
		try {
			retrievedTextFromContext = (String) context.getBean("greeting");
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello " + retrievedTextFromContext);
	}
}
