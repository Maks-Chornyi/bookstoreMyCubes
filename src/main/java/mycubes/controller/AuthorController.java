package mycubes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mycubes.domain.Author;
import mycubes.domain.Book;
import mycubes.service.AuthorService;
import mycubes.service.BookService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/author")
	public String getAllAuthors(Model model) {
		List<Author> authors = authorService.findAll();
		Author mostSuccessfullAuthor = authorService.getMostSuccessfulAuthor2(authors);
		Author unSuccessfulAuthor = authorService.getUnSuccessfulAuthor2(authors);
		Author mostProductiveAuthor = authorService.getMostProductiveAuthor(authors);
		model.addAttribute("countOfAllAuthors", authors.size());
		model.addAttribute("oldestAuthor", authorService.getOldestAuthor(authors));
		model.addAttribute("youngestAuthor", authorService.getYoungestAuthor(authors));
		model.addAttribute("mostSuccessfulAuthor", mostSuccessfullAuthor);
		model.addAttribute("countOfBooksOfMostSuccessfulAuthor", authorService.getCountOfBooksOfAuthor(mostSuccessfullAuthor));
		model.addAttribute("lowestPublishedAuthor", unSuccessfulAuthor);
		model.addAttribute("countOfBooksOfUnSuccessfulAuthor", authorService.getCountOfBooksOfAuthor(unSuccessfulAuthor));
		model.addAttribute("mostProductiveAuthor", mostProductiveAuthor);
		model.addAttribute("averageSaleOfMostProductiveAuthor", authorService.getAverageSaleCountOfAuthor(mostProductiveAuthor));
		model.addAttribute("authors", authors);
		return "author";
	}
	
	@PostMapping("/deleteauthor")
	public String deleteAuthorById(@RequestParam int id) {
		authorService.deleteAuthorById(id);
		return "redirect:author";
	}
	
	@RequestMapping(value = "/author/{id}/edit", method = RequestMethod.GET)
	public String editAuthorById(@PathVariable(value="id") int id, Model model) {
		Author author = authorService.getAuthorById(id);
		List<Integer> authorsBooksIds = new ArrayList<>();
		Set<Book> authorsBooks = author.getAuthorsBooks();
		for (Book book : authorsBooks) {
			authorsBooksIds.add(book.getId());
		}
		model.addAttribute("author", author);
		model.addAttribute("books", bookService.getAllBooks());
		model.addAttribute("authorsBooksIds", authorsBooksIds);
		model.addAttribute("countOfAuthorsBooks", authorsBooks.size());
		return "editauthor";
	}
	
	@RequestMapping(value="/author/{id}/edit", method = RequestMethod.POST)
	public String addAuthor(@Valid Author newAuthor, Model model) {
		authorService.addAuthor(newAuthor);
		model.addAttribute("authors", authorService.findAll());
		return "redirect:/author";
	}
	
	@PostMapping("/addAuthor")
	public String addNewAuthor(@Valid Author newAuthor, Model model) {
		authorService.addAuthor(newAuthor);
		model.addAttribute("authors", authorService.findAll());
		return "redirect:/author";
	}
}
