package mycubes.service.impl;

import java.util.ArrayList;
import java.util.List;
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
	private Author mostPublishedAuthor;
	private Author lowestPublishedAuthor;
	private Author mostProductiveAuthor;
	
	public void getMostSuccessfulAuthor() {
		int booksCountOfParticularAuthor = 0;
		List<Author> authors = (ArrayList<Author>) authorRepo.findAll();
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
	
	public void getUnSuccessfulAuthor() {
		int booksCountOfParticularAuthor = 0;
		List<Author> authors = (ArrayList<Author>) authorRepo.findAll();
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
	
	public void findMostProductiveAuthor() {
		this.averageSaleCountOfProductiveAuthor = 0;
		int booksCountOfParticularAuthor = 0;
		int coefSpecialAuthor = 0;
		List<Author> authors = (ArrayList<Author>) authorRepo.findAll();
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

	@Override
	public List<Author> getAllAuthors() {
		return (ArrayList<Author>) authorRepo.findAll();
	}
	
	@Override
	public void addAuthor(Author newAuthor) {
		authorRepo.save(newAuthor);
	}

	@Override
	public void deleteAuthorById(int id) {
		authorRepo.deleteById(id);
	}

	@Override
	public Author getAuthorById(int id) {
		return authorRepo.findById(id).orElseThrow(RuntimeException::new);
	}

	@Override
	public Author getOldestAuthor() {
		return authorRepo.getOldestAuthor();
	}

	@Override
	public Author getYoungestAuthor() {
		return authorRepo.getYoungestAuthor();
	}
	
	@Override
	public int getCountOfBooksOfMostSuccessfulAuthor() {
		return this.countOfBooksOfMostSuccessfulAuthor;
	}
	
	@Override
	public void setCountOfBooksOfMostSuccessfulAuthor(int count) {
		this.countOfBooksOfMostSuccessfulAuthor = count;
	}
	
	@Override
	public int getCountOfBooksOfUnSuccessfulAuthor() {
		return this.countOfBooksOfUnSuccessfulAuthor;
	}
	
	@Override
	public void setCountOfBooksOfUnSuccessfulAuthor(int countOfBooksOfUnSuccessfulAuthor) {
		this.countOfBooksOfUnSuccessfulAuthor = countOfBooksOfUnSuccessfulAuthor;
	}
	
	@Override
	public Author getMostPublishedAuthor() {
		getMostSuccessfulAuthor();
		return this.mostPublishedAuthor;
	}
	
	@Override
	public void setMostPublishedAuthor(Author mostPublishedAuthor) {
		this.mostPublishedAuthor = mostPublishedAuthor;
	}
	
	@Override
	public Author getLowestPublishedAuthor() {
		getUnSuccessfulAuthor();
		return this.lowestPublishedAuthor;
	}

	@Override
	public void setLowestPublishedAuthor(Author lowestPublishedAuthor) {
		this.lowestPublishedAuthor = lowestPublishedAuthor;
	}

	@Override
	public int getAverageSaleCountOfProductiveAuthor() {
		findMostProductiveAuthor();
		return averageSaleCountOfProductiveAuthor;
	}

	@Override
	public void setAverageSaleCountOfProductiveAuthor(int averageSaleCountOfProductiveAuthor) {
		this.averageSaleCountOfProductiveAuthor = averageSaleCountOfProductiveAuthor;
	}
	
	@Override
	public Author getMostProductiveAuthor() {
		findMostProductiveAuthor();
		return mostProductiveAuthor;
	}
	
	@Override
	public void setMostProductiveAuthor(Author mostProductiveAuthor) {
		this.mostProductiveAuthor = mostProductiveAuthor;
	}
}
