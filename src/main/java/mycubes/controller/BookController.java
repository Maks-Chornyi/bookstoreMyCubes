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
import org.springframework.web.bind.annotation.RequestParam;

import mycubes.domain.Author;
import mycubes.domain.Book;
import mycubes.service.AuthorService;
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
	
	@PostMapping("/deletebook")
	public String deleteBookById(@RequestParam Integer id) {
		bookService.deleteBookById(id);
		return "redirect:/book";
	}
	
	@PostMapping("/book")
	public String addBook(
			@RequestParam String isbn, 
			@RequestParam String title, 
			@RequestParam String publishDate, 
			@RequestParam int countOfCopies, 
			Model model) throws ParseException {
		Date authorBirthday = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(publishDate);
		Book newBook = new Book(isbn,title,authorBirthday, countOfCopies);
		bookService.addBook(newBook);
		model.addAttribute("book", bookService.getAllBooks());
		return "book";
	}
		
}
