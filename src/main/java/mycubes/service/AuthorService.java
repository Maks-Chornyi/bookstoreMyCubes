package mycubes.service;

import java.util.List;
import java.util.Map;

import mycubes.domain.Author;

public interface AuthorService {
	Map<String, Object> getModel();
	
	void deleteAuthorById(int id);
	
	Author getAuthorById(int id);
	
	void addAuthor(Author author);
	
	List<Author> getAllAuthors();
}
