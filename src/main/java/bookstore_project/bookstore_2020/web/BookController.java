package bookstore_project.bookstore_2020.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bookstore_project.bookstore_2020.domain.Book;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
}
