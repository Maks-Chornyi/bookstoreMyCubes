package mycubes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mycubes.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "book";
	}
}
