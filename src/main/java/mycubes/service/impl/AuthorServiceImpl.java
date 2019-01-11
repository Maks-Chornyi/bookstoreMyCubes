package mycubes.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mycubes.domain.Author;
import mycubes.domain.Book;
import mycubes.repository.AuthorRepository;
import mycubes.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	private int countOfBooksOfMostSuccessfulAuthor;
	private int countOfBooksOfUnSuccessfulAuthor = 2000000000;
	private int averageSaleCountOfProductiveAuthor;
	private Author youngestAuthor;
	private Author oldestAuthor;
	private Author mostPublishedAuthor;
	private Author lowestPublishedAuthor;
	private Author mostProductiveAuthor;
	private List<Author> allAuthors;
	private Map<String, Object> model;
	
	public void getAllAuthorsFromDB() {
		this.allAuthors = (ArrayList<Author>)authorRepo.findAll();
	}
	
	public int getCountOfAllAuthors() {
		return this.allAuthors.size();
	}
	
	public void sortAuthorsByBirthday(List<Author> authors) {
		Collections.sort(authors, new Comparator<Author>() {
			public int compare(Author o1, Author o2) {
				if(o1 == null || o2 == null) {
					return 0;
				}
				return o2.getBirthday().compareTo(o1.getBirthday());
			}
		});
	}
	
	void findOldestAndYoungestAuthors(List<Author> authors) {
		sortAuthorsByBirthday(authors);
		this.oldestAuthor = authors.get(authors.size()-1);
		this.youngestAuthor = authors.get(0);
	}
	
	public void getMostSuccessfulAuthor(List<Author> authors) {
		int booksCountOfParticularAuthor = 0;
		for(Author author : authors) {
			Set<Book> books = author.getAuthorsBooks();
			for(Book book : books) {
				booksCountOfParticularAuthor += book.getCountOfCopies();
			}
			if(booksCountOfParticularAuthor > this.countOfBooksOfMostSuccessfulAuthor) {
				setCountOfBooksOfMostSuccessfulAuthor(booksCountOfParticularAuthor);
				this.mostPublishedAuthor = author;
			}
			booksCountOfParticularAuthor = 0;
		}
	}
	
	public void getUnSuccessfulAuthor(List<Author> authors) {
		int booksCountOfParticularAuthor = 0;
		for(Author author : authors) {
			Set<Book> books = author.getAuthorsBooks();
			for(Book book : books) {
				booksCountOfParticularAuthor += book.getCountOfCopies();
			}
			if(booksCountOfParticularAuthor < this.countOfBooksOfUnSuccessfulAuthor) {
				setCountOfBooksOfUnSuccessfulAuthor(booksCountOfParticularAuthor);
				this.lowestPublishedAuthor = author;
			}
			booksCountOfParticularAuthor = 0;
		}
	}
	
	public void findMostProductiveAuthor(List<Author> authors) {
		this.averageSaleCountOfProductiveAuthor = 0;
		int booksCountOfParticularAuthor = 0;
		int coefSpecialAuthor = 0;
		for (Author author : authors) {
			Set<Book> books = author.getAuthorsBooks();
			if  (books.size() > 0) {
				for (Book book : books) {
					booksCountOfParticularAuthor += book.getCountOfCopies();
				}
				coefSpecialAuthor = booksCountOfParticularAuthor / books.size();
			}
			if (coefSpecialAuthor > this.averageSaleCountOfProductiveAuthor) {
				this.averageSaleCountOfProductiveAuthor = coefSpecialAuthor;
				this.mostProductiveAuthor = author;
			}
			coefSpecialAuthor = 0;
			booksCountOfParticularAuthor = 0;
		}
	}

	public int getCountOfBooksOfMostSuccessfulAuthor() {
		return countOfBooksOfMostSuccessfulAuthor;
	}

	public void setCountOfBooksOfMostSuccessfulAuthor(int countOfBooksOfMostSuccessfulAuthor) {
		this.countOfBooksOfMostSuccessfulAuthor = countOfBooksOfMostSuccessfulAuthor;
	}

	public int getCountOfBooksOfUnSuccessfulAuthor() {
		return countOfBooksOfUnSuccessfulAuthor;
	}

	public void setCountOfBooksOfUnSuccessfulAuthor(int countOfBooksOfUnSuccessfulAuthor) {
		this.countOfBooksOfUnSuccessfulAuthor = countOfBooksOfUnSuccessfulAuthor;
	}

	public int getAverageSaleCountOfProductiveAuthor() {
		return averageSaleCountOfProductiveAuthor;
	}

	public void setAverageSaleCountOfProductiveAuthor(int averageSaleCountOfProductiveAuthor) {
		this.averageSaleCountOfProductiveAuthor = averageSaleCountOfProductiveAuthor;
	}

	public Author getYoungestAuthor() {
		return youngestAuthor;
	}

	public void setYoungestAuthor(Author youngestAuthor) {
		this.youngestAuthor = youngestAuthor;
	}

	public Author getOldestAuthor() {
		return oldestAuthor;
	}

	public void setOldestAuthor(Author oldestAuthor) {
		this.oldestAuthor = oldestAuthor;
	}

	public Author getMostPublishedAuthor() {
		return mostPublishedAuthor;
	}

	public void setMostPublishedAuthor(Author mostPublishedAuthor) {
		this.mostPublishedAuthor = mostPublishedAuthor;
	}

	public Author getLowestPublishedAuthor() {
		return lowestPublishedAuthor;
	}

	public void setLowestPublishedAuthor(Author lowestPublishedAuthor) {
		this.lowestPublishedAuthor = lowestPublishedAuthor;
	}

	public Author getMostProductiveAuthor() {
		return mostProductiveAuthor;
	}

	public void setMostProductiveAuthor(Author mostProductiveAuthor) {
		this.mostProductiveAuthor = mostProductiveAuthor;
	}

	public List<Author> getAllAuthors() {
		return allAuthors;
	}

	public void setAllAuthors(List<Author> allAuthors) {
		this.allAuthors = allAuthors;
	}
	
	@Override
	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
}
