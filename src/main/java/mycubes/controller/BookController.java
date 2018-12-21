package mycubes.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mycubes.domain.Book;
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
	
	@DeleteMapping("book/{id}")
	public String deleteBookById(@PathVariable("id") int id) {
		bookService.deleteBookById(id);
		return "book";
	}
	
	@GetMapping("book/{id}")
	public String getBookById(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "book";
	}
	
	@PostMapping("/book")
	public String addBook(
			@RequestParam String isbn, 
			@RequestParam String title, 
			@RequestParam Date publishDate, 
			@RequestParam int countOfCopies) {
		Book newBook = new Book();
		newBook.setBookId(isbn);
		newBook.setTitle(title);
		newBook.setPublishDate(publishDate);
		newBook.setCountOfCopies(countOfCopies);
		bookService.addBook(newBook);
		return "book";
	}
	
	
	
	
}
