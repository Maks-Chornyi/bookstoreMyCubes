package mycubes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mycubes.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/author")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorService.getAllAuthors());
		return "author";
	}
}
