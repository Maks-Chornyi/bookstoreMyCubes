package mycubes.repository;

import org.springframework.data.repository.CrudRepository;

import mycubes.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
}
