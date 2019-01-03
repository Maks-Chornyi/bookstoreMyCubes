package mycubes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
	
	@PostMapping("/deletebook")
	public String deleteBookById(@RequestParam Integer id) {
		bookService.deleteBookById(id);
		return "redirect:/book";
	}
	
	@RequestMapping(value="/book/{id}/edit", method = RequestMethod.GET)
	public String editBookById(@PathVariable int id, Model model) {
		Book book = bookService.getBookById(id);
		List<Author> booksAuthors = new ArrayList<>();
		for(Author author : book.getBookAuthors()) {
			booksAuthors.add(author);
		}
		model.addAttribute("book", book);
		model.addAttribute("booksAuthors", booksAuthors);
		return "editbook";
	}
	
	@PostMapping("/addbook")
	public String addBook(@Valid Book newBook, Model model) {
		bookService.addBook(newBook);
		model.addAttribute("book", bookService.getAllBooks());
		return "redirect:/book";
	}
	
	@RequestMapping(value="/book/{id}/edit", method = RequestMethod.POST)
	public String saveUpdatedBookById(@Valid Book book) {
		bookService.addBook(book);
		return "redirect:/book";
	}		
}
