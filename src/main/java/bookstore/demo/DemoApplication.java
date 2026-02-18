package bookstore.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.demo.domain.Book;
import bookstore.demo.domain.BookRepository;
import bookstore.demo.domain.Category;
import bookstore.demo.domain.CategoryRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
@Bean
public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
	return (args) -> {
Category category1 = new Category("Runous");
Category category2 = new Category("Novelli");
			
categoryRepository.save(category1);
categoryRepository.save(category2);
Book kirja1 = new Book("Virgil", "Aeneid", 1922, "1000010000", 10.0, category1);
Book kirja2 = new Book("Goethe", "Nuoren Wertherin kärsimykset", 1946, "1000010001", 15.0, category2);
bookRepository.save(kirja1);
bookRepository.save(kirja2);
};
}
}
