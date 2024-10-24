package org.example.ecoli;

import com.hazelcast.client.config.ClientConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class EcoliApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcoliApplication.class, args);
	}

	@Bean
	ClientConfig hazelcastClientConfig() {
		return new ClientConfig();
	}

}
