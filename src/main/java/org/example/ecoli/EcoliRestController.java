package org.example.ecoli;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoliRestController {

	@Cacheable("echo")
	@GetMapping("/echo/{message}")
	public String echo(@PathVariable String message) {
		return message;
	}

}
