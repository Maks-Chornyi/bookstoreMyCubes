package mycubes.repository;

import org.springframework.data.repository.CrudRepository;

import mycubes.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	
}
