package bookstore_project.bookstore_2020.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore_project.bookstore_2020.domain.Book;
import bookstore_project.bookstore_2020.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/booklist")
	public String index(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model){
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookID, Model model) {
		model.addAttribute("book", repository.findById(bookID).get());
		
		return "edit";
	}
	
	
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	@PostMapping("/saveEdited/{id}")
	public String saveEditedBook(@PathVariable("id") long id, Book book, Model model){
		book.setId(id);
		repository.save(book);
		model.addAttribute("books", repository.findAll());
		return "redirect:../booklist";
	}
}
