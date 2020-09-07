package bookstore_project.bookstore_2020;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore_project.bookstore_2020.domain.Book;
import bookstore_project.bookstore_2020.domain.BookRepository;

@SpringBootApplication
public class Bookstore2020Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2020Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		Book b1 = new Book("Kuolleet sielut", " Gogol, Nikolai", 1842, "9780199554669", 39.95);
		Book b2 = new Book("Spiritistinen istunto", "Kaartinen, Marjo", 2020, "9789518581317", 26.90);
		Book b3 = new Book("Homo Fennicus", "Lang, Valter", 2020, "9789518581300", 27.90);
		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
	};
	}

}
