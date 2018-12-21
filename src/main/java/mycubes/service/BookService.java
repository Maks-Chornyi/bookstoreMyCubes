package mycubes.service;

import java.util.List;

import mycubes.domain.Book;

public interface BookService {
	List<Book> getAllBooks();
	
	void deleteBookById(int id);
	
	Book getBookById(int id);
}
