package lu.ethoswarrior.java.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingsControler {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, Warrior!";
	}
}
