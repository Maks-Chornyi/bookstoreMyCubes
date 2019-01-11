package mycubes.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mycubes.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT * from author order by birthday LIMIT 1")
	Author getOldestAuthor();
	
	@Query(nativeQuery = true, value = "SELECT * from author order by birthday desc LIMIT 1")
	Author getYoungestAuthor();
}
