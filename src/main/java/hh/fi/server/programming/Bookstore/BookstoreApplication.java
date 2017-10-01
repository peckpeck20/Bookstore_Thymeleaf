package hh.fi.server.programming.Bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookstoreApplication {
	//logger
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	//main method executes
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository){
		return (args) -> {
			
			//save categories
			log.info("save a couple of categories");
			crepository.save(new Category("IT"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Law"));
			//save a couple of books
			log.info("saving books");
			brepository.save(new Book("book1","jk",9999,12343,20.00, crepository.findByName("Law").get(0)));
			brepository.save(new Book("book2","KK",0000,55555,25.00, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("book3","Aa",8888,11111,34.00, crepository.findByName("Business").get(0)));
			
			//fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			log.info("");
			
			// fetch an individual customer by ID
			Book book = brepository.findOne(3L);
			log.info("Book found with findOne(3L):");
			log.info("--------------------------------");
			log.info(book.toString());
			log.info("");
			
			// fetch books by title
			log.info("Book found with findByTitle('book3'):");
			log.info("--------------------------------------------");
			for (Book book3 : brepository.findByTitle("book3")) {
				log.info(book3.toString());
			}
		
		};
	}
}