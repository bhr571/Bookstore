package bookstore.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;
import bookstore.demo.domain.CategoryRepository;



@Controller
public class BookController {

private final BookRepository bookRepository;
private final CategoryRepository categoryRepository;
public BookController (BookRepository bookRepository, CategoryRepository categoryRepository){
    this.bookRepository = bookRepository;
    this.categoryRepository= categoryRepository;
}
@GetMapping("/booklist")
public String getAllBooks(Model model){
model.addAttribute("kirjat", bookRepository.findAll());
return "booklist";
}
@GetMapping("/add")
public String openAddBookForm(Model model){
    System.out.println("Categories: " + categoryRepository.findAll());
    model.addAttribute("kirja", new Book());
    model.addAttribute("kategoriat", categoryRepository.findAll());
    return "addBook";
}


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model, RequestMethod method) {
    	bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
    @GetMapping("/edit/{id}")
public String editBook(@PathVariable("id") Long id, Model model) {
    Book kirja = bookRepository.findById(id).orElse(null);
     model.addAttribute("kategoriat", categoryRepository.findAll());
    if (kirja == null) {
        return "redirect:/booklist";
    }
    model.addAttribute("kirja", kirja);
    return "editBook";

}
@PostMapping("/save")
public String save(Book kirja) {
    bookRepository.save(kirja);
    return "redirect:/booklist";
}

}
