package mycubes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mycubes.domain.Author;
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
	
	@PostMapping("/deleteauthor")
	public String deleteAuthorById(@RequestParam int id) {
		authorService.deleteAuthorById(id);
		return "redirect:author";
	}
	
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
	public String editAuthorById(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("author", authorService.getAuthorById(id));
		return "editauthor";
	}
	
	@PostMapping("/author")
	public String addAuthor(
			@RequestParam String name, 
			@RequestParam String birthday, 
			@RequestParam String address, 
			@RequestParam String authorInfo, 
			Model model) throws ParseException {
		Date authorBirthday = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
		Author author = new Author(name, authorBirthday, address, authorInfo);
		authorService.addAuthor(author);
		model.addAttribute("authors", authorService.getAllAuthors());
		return "author";
	}
}
