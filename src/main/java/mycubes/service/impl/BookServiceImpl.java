package mycubes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mycubes.domain.Book;
import mycubes.repository.BookRepository;
import mycubes.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Book> getAllBooks() {
		return (ArrayList<Book>)bookRepo.findAll();
	}
}
