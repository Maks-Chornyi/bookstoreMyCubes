package mycubes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mycubes.domain.Author;
import mycubes.domain.Book;
import mycubes.repository.AuthorRepository;
import mycubes.repository.BookRepository;

@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(BookRepository bookRepo, AuthorRepository authorRepo) {
//		return (args) -> {
//			//Ain Rand's Books 
//			Book book1 = new Book("000-000-005","Dzherelo", new Date(), 5000);
//			Book book2 = new Book("000-000-006","Atlas", new Date(), 5000);
//			Set<Book> books1 = new HashSet<>();
//			books1.add(book1);
//			books1.add(book2);
//			Author author1 = new Author("Ain Rand", new Date(), "Washington st., NY", "egoistic philosophy", books1);
//			authorRepo.save(author1);
//		};
//	}
//	
//	@Bean
//	public CommandLineRunner demo1(BookRepository bookRepo, AuthorRepository authorRepo) {
//		return (args) -> {
//			//Jack London's books
//			Book book3 = new Book("000-000-007","Bile Iklo", new Date(), 1000);
//			Book book4 = new Book("000-000-008","Martin Eden", new Date(), 500);
//			Set<Book> books2 = new HashSet<>();
//			books2.add(book3);
//			books2.add(book4);
//			Author author2 =new Author("Jack London", new Date(), "Patric st., London", "author from GB", books2);
//			authorRepo.save(author2);
//		};
//	}
//	
//	@Bean
//	public CommandLineRunner demo2(AuthorRepository authorRepo) {
//		return (args) -> {
//			Author author3 = new Author("Maks Chornyi", new Date(), "keramichna st, Lviv", "java dev");
//			authorRepo.save(author3);
//		};
//	}
	
	
//	@Bean
//	public CommandLineRunner demo(BookRepository bookRepo, AuthorRepository authorRepo) {
//		return (args) -> {
//			//create books
////			new Book("str1","str2",new Date(44),5000,new HashSet<Author>());
////			Book book1 = new Book("99921-58-10-7", "title1", new Date(10000), 5000, getParticularNumberOfAuthors(1));
////			Book book2 = new Book("960-425-059-0", "title2", new Date(50000), 1000, getParticularNumberOfAuthors(2));
////			Book book3 = new Book("1-84356-028-3", "title3", new Date(96000), 100, getParticularNumberOfAuthors(3));
////			Author author1 = new Author("Ain Rend", new Date(5000000), "500 South Main Street\n" + 
////					"Bishop, CA 93514","Had particular philosophy");
////			Author author2 = new Author("Joahn Rolling", new Date(50000000), "4050 Taylor Street\n" + 
////					"San Diego, CA 92110","Shge wrote best magic story ever");
////			Author author3 = new Author("Jack London", new Date(500000000), "1750 East 4th Street\n" + 
////					"Santa Ana, CA 92705","Shge wrote best magic story ever");
////
////			bookRepo.save(book1);
////			bookRepo.save(book2);
////			bookRepo.save(book3);
////			authorRepo.save(author1);
////			authorRepo.save(author2);
////			authorRepo.save(author3);
//		};
//	}
//	
//	Set<Author> getParticularNumberOfAuthors(int count) {
//		Set<Author> oneAuthor = new HashSet<>();
//		switch(count) {
//			case 3: oneAuthor.add(new Author("Ain Rend", new Date(5000000), "500 South Main Street\n" + 
//				"Bishop, CA 93514","Had particular philosophy"));
//			case 2: oneAuthor.add(new Author("Joahn Rolling", new Date(50000000), "4050 Taylor Street\n" + 
//					"San Diego, CA 92110","Shge wrote best magic story ever"));
//			default: oneAuthor.add(new Author("Jack London", new Date(500000000), "1750 East 4th Street\n" + 
//				"Santa Ana, CA 92705","Shge wrote best magic story ever"));
//		}
//		return oneAuthor;
//	}
}
