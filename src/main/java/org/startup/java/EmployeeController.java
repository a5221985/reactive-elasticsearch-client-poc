package org.startup.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emplyees")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@PostMapping
	public Mono<Employee> add(@RequestBody Employee employee) {
		return repository.save(employee);
	}

	@GetMapping("/{name}")
	public Flux<Employee> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@GetMapping
	public Flux<Employee> findAll() {
		return repository.findAll();
	}

	@GetMapping("/organization/{organizationName}")
	public Flux<Employee> findByOrganizationName(@PathVariable("organizationName") String organizationName) {
		return repository.findByOrganizationName(organizationName);
	}
}
