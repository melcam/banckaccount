package com.nttdata.bootcamp.banckaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class BanckaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanckaccountApplication.class, args);
	}

}
