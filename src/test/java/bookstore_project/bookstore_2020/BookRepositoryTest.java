package bookstore_project.bookstore_2020;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstore_project.bookstore_2020.domain.Book;
import bookstore_project.bookstore_2020.domain.BookRepository;
import bookstore_project.bookstore_2020.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByNameShouldReturnBook() {
		List<Book> books = repository.findByTitle("Kuolleet sielut");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Gogol, Nikolai");
		
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Mollin iltahepuli", "Katri Kirkkopelto", 2020, "ZXCv-254-GDS", 15.90, new Category ("Lasten ja nuoret kirjat"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		
	}

}
