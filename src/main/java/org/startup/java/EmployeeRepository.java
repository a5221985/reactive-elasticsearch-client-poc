package org.startup.java;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

	Flux<Employee> findByOrganizationName(String name);

	Flux<Employee> findByName(String name);
}
