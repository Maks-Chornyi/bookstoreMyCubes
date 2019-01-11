package mycubes.service;

import java.util.List;

import mycubes.domain.Author;

public interface AuthorService {
	List<Author> getAllAuthors();
	
	void addAuthor(Author newAuthor);
	
	void deleteAuthorById(int id);
	
	Author getAuthorById(int id);
	
	Author getOldestAuthor();
	
	Author getYoungestAuthor();
	
	int getCountOfBooksOfMostSuccessfulAuthor();
	
	void setCountOfBooksOfMostSuccessfulAuthor(int count);
	
	int getCountOfBooksOfUnSuccessfulAuthor();
	
	void setCountOfBooksOfUnSuccessfulAuthor(int countOfBooksOfUnSuccessfulAuthor);
	
	Author getMostPublishedAuthor();
	
	void setMostPublishedAuthor(Author mostPublishedAuthor);
	
	Author getLowestPublishedAuthor();
	
	void setLowestPublishedAuthor(Author lowestPublishedAuthor);
	
	Author getMostProductiveAuthor();
	
	void setMostProductiveAuthor(Author mostProductiveAuthor);
	
	int getAverageSaleCountOfProductiveAuthor();
	
	void setAverageSaleCountOfProductiveAuthor(int averageSaleCountOfProductiveAuthor);
}
