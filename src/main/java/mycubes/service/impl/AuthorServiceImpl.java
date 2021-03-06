package mycubes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mycubes.domain.Author;
import mycubes.repository.AuthorRepository;
import mycubes.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo;

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
}
