package mycubes.service;

import java.util.List;

import mycubes.domain.Author;

public interface AuthorService {
	List<Author> findAll();
	
	void deleteAuthorById(int id);
	
	Author getAuthorById(int id);
	
	void addAuthor(Author author);
	
	Author getOldestAuthor(List<Author> authors);
	
	Author getYoungestAuthor(List<Author> authors);
	
	Author getMostSuccessfulAuthor2(List<Author> authors);
	
	Author getUnSuccessfulAuthor2(List<Author> authors);
	
	Author getMostProductiveAuthor(List<Author> authors);
	
	int getAverageSaleCountOfAuthor(Author author);
	
	int getCountOfBooksOfAuthor(Author author);
}
