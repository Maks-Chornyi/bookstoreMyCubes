package mycubes.service;

import java.util.List;

import mycubes.domain.Author;

public interface AuthorService {
	List<Author> getAllAuthors();
	
	void addAuthor(Author newAuthor);
	
	void deleteAuthorById(int id);
	
	Author getAuthorById(int id);
}
