package mycubes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String getWelcomePage() {
		return "index";
	}
	
	@GetMapping("includeTest")
	public String getTest() {
		return "includeTest";
	}
}
