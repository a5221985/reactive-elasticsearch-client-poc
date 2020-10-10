package org.startup.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@SpringBootApplication
@EnableReactiveElasticsearchRepositories
public class ReactiveElasticsearchClientPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveElasticsearchClientPocApplication.class, args);
	}

	@Bean
	@ConditionalOnProperty("initial-import.enabled")
	public SampleDataSet dataSet() {
		return new SampleDataSet();
	}
}
