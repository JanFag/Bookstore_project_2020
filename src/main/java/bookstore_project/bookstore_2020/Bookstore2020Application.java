package bookstore_project.bookstore_2020;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore_project.bookstore_2020.domain.Book;
import bookstore_project.bookstore_2020.domain.BookRepository;
import bookstore_project.bookstore_2020.domain.Category;
import bookstore_project.bookstore_2020.domain.CategoryRepository;

@SpringBootApplication
public class Bookstore2020Application {
	public static final Logger log = LoggerFactory.getLogger(Bookstore2020Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Bookstore2020Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	return (args) -> {
		log.info("save a couple of books");
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Adventure"));
		crepository.save(new Category("Romance"));
		crepository.save(new Category("Mystery"));
		crepository.save(new Category("Horror"));
		Book b1 = new Book("Kuolleet sielut", " Gogol, Nikolai", 1842, "9780199554669", 39.95, crepository.findByName("Adventure").get(0));
		Book b2 = new Book("Spiritistinen istunto", "Kaartinen, Marjo", 2020, "9789518581317", 26.90, crepository.findByName("Fantasy").get(0));
		Book b3 = new Book("Homo Fennicus", "Lang, Valter", 2020, "9789518581300", 27.90, crepository.findByName("Horror").get(0));
		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
	};
	}

}
