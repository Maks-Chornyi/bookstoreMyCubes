package mycubes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mycubes.domain.Book;
import mycubes.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getServerTime")
	public Date getServerTime() {
		return new Date();
	}
	
	@GetMapping("/getBookInfo")
	public Book getBookInfo() {
		Book bookFromRepo = bookService.getBookById(4);
		return bookFromRepo;
	}
	
	@GetMapping("/getBookInfoById/{id}")
	public Book getBookInfoById(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/addBookAjax")
	public void addBookAjaz(Book book) {
		bookService.addBook(book);
	}
	
	@PostMapping("/bookSearch")
	public List<Book> findBooksByName(String search) {
		System.out.println(search);
		return bookService.findBooksByName(search);
	}
}
