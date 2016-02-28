package org.verizon.userservices.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan(basePackages = { "org.verizon.userservices.service" })
@EnableJpaRepositories(basePackages = { "org.verizon.userservices.service" })
@EntityScan(basePackages = { "org.verizon.userservices.domain" })
public class UserServicesApplication {
	@Autowired
    JdbcTemplate jdbcTemplate;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserServicesApplication.class, args);
	}

}
