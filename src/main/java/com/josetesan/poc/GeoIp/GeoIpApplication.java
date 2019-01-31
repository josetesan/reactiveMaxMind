package com.josetesan.poc.GeoIp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.ing.poc.GeoIp.repositories.blocking")
@EnableReactiveCassandraRepositories(basePackages = "com.ing.poc.GeoIp.repositories.reactive")
public class GeoIpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoIpApplication.class, args);
	}

}

