package com.tjudream.sharding.jdbc;

import com.tjudream.sharding.jdbc.service.ExampleExecuteTemplate;
import com.tjudream.sharding.jdbc.service.ExampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@EntityScan(basePackages = "com.tjudream.sharding.jdbc.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class JdbcApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(JdbcApplication.class, args);
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(JdbcApplication.class, args)) {
            ExampleExecuteTemplate.run(applicationContext.getBean(ExampleService.class));
        }
	}

}
