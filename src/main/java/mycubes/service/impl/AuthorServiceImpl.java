package mycubes.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	@Override
	public List<Author> findAll() {
		return (ArrayList<Author>) authorRepo.findAll();
	}
	
	public List<Author> sortAuthorsByBirthday2(List<Author> authors) {
		Collections.sort(authors, new Comparator<Author>() {
			public int compare(Author o1, Author o2) {
				if(o1 == null || o2 == null) {
					return 0;
				}
				return o2.getBirthday().compareTo(o1.getBirthday());
			}
		});
		return authors;
	}
	
	@Override
	public Author getOldestAuthor(List<Author> authors) {
		authors = sortAuthorsByBirthday2(authors);
		return authors.get((authors.size()-1));
	}
	
	@Override
	public Author getYoungestAuthor(List<Author> authors) {
		authors = sortAuthorsByBirthday2(authors);
		return authors.get(0);
	}
	
	@Override
	public Author getMostSuccessfulAuthor2(List<Author> authors) {
		int booksCountOfParticularAuthor = 0;
		int booksCountOfMostSuccessfulAuthor = 0;
		Author mostSuccessfulAuthor = authors.get(0);
		
		for(Author author : authors) {
			Set<Book> books = author.getAuthorsBooks();
			for(Book book : books) {
				booksCountOfParticularAuthor += book.getCountOfCopies();
			}
			if(booksCountOfParticularAuthor > booksCountOfMostSuccessfulAuthor) {
				booksCountOfMostSuccessfulAuthor = booksCountOfParticularAuthor;
				mostSuccessfulAuthor = author;
			}
			booksCountOfParticularAuthor = 0;
		}
		return mostSuccessfulAuthor;
	}
	
	@Override
	public Author getUnSuccessfulAuthor2(List<Author> authors) {
		int booksCountOfParticularAuthor = 0;
		Author unsuccessfulAuthor = authors.get(0);
		int booksCountOfUnSuccessfulAuthor = getCountOfBooksOfAuthor(authors.get(0));
		
				
		for(Author author : authors) {
			booksCountOfParticularAuthor = getCountOfBooksOfAuthor(author);
			if(booksCountOfParticularAuthor < booksCountOfUnSuccessfulAuthor) {
				booksCountOfUnSuccessfulAuthor = booksCountOfParticularAuthor;
				unsuccessfulAuthor = author;
			}
			booksCountOfParticularAuthor = 0;
		}
		return unsuccessfulAuthor;
	}
	
	@Override
	public int getCountOfBooksOfAuthor(Author author) {
		int booksCountOfAuthor = 0;
		Set<Book> books = author.getAuthorsBooks();
		for(Book book : books) {
			booksCountOfAuthor += book.getCountOfCopies();
		}
		return booksCountOfAuthor;
	}
	
	@Override
	public Author getMostProductiveAuthor(List<Author> authors) {
		int averageSaleCountOfProductiveAuthor = 0;
		int coefSpecialAuthor = 0;
		Author mostProductiveAuthor = authors.get(0);
		
		for (Author author : authors) {
			coefSpecialAuthor = getAverageSaleCountOfAuthor(author);
			if (coefSpecialAuthor > averageSaleCountOfProductiveAuthor) {
				averageSaleCountOfProductiveAuthor = coefSpecialAuthor;
				mostProductiveAuthor = author;
			}
			coefSpecialAuthor = 0;
		}
		return mostProductiveAuthor;
	}
	
	@Override
	public int getAverageSaleCountOfAuthor(Author author) {
		int booksCountOfParticularAuthor = 0;
		int averageSaleCountOfAuthor = 0;
		Set<Book> books = author.getAuthorsBooks();
		if (books.size() > 0) {
			for (Book book : books) {
				booksCountOfParticularAuthor += book.getCountOfCopies();
			}
			averageSaleCountOfAuthor = booksCountOfParticularAuthor / books.size();
		}
		return averageSaleCountOfAuthor;
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
	public void addAuthor(Author author) {
		authorRepo.save(author);
	}
}
