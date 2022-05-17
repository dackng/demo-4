package com.example.demo.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private ExampleService service;
	
	@GetMapping("/{number}")
	public ResponseEntity<List<String>> getRepresentation(@PathVariable @Valid @Pattern(regexp = "[\\s]*[0-9]*[1-9]+") Long number) {
		return ResponseEntity.ok(service.get(number));
	}
}
