package com.example.springreactsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.springreactsecurity.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringReactSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactSecurityApplication.class, args);
	}

}
