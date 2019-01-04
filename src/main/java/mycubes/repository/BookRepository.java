package mycubes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mycubes.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	@Query(nativeQuery = true, value = "select * from book where title like %?1%")
	List<Book> findBooksByName(String searchStr);
}
