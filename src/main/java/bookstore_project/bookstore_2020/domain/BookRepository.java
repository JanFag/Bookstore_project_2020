package bookstore_project.bookstore_2020.domain;



import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	
}
