package com.neoxiontechnologies.neoxAccounting.backend;

import java.util.Properties;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 ** @BMN 2021
 **
 **/
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan("com.neoxiontechnologies.neoxAccounting")
@org.springframework.data.jpa.repository.config.EnableJpaRepositories({ "com.neoxiontechnologies.neoxAccounting.dao" })
@EntityScan("com.neoxiontechnologies.neoxAccounting.entities")
public class MainNeoxAccountingBackend {
	public static void main(String[] args) {
		SpringApplicationBuilder managerApplicationBuilder = new SpringApplicationBuilder(
				MainNeoxAccountingBackend.class);
		managerApplicationBuilder.properties(getProperties());
		managerApplicationBuilder.run(args);
	}

	private static Properties getProperties() {
		Properties managerProperties = new Properties();
		managerProperties.put("spring.config.name", "neox_accounting");
		return managerProperties;
	}
}
