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
	//main method execute
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
			//save a couple of books
			log.info("saving books");
			repository.save(new Book("book1","jk",9999,12343,20.00));
			repository.save(new Book("book2","KK",0000,55555,25.00));
			repository.save(new Book("book3","Aa",8888,11111,34.00));
			
			//fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("");
			
			// fetch an individual customer by ID
			Book book = repository.findOne(1L);
			log.info("Book found with findOne(1L):");
			log.info("--------------------------------");
			log.info(book.toString());
			log.info("");
			
			// fetch books by title
			log.info("Book found with findByTitle('book3'):");
			log.info("--------------------------------------------");
			for (Book book3 : repository.findByTitle("book3")) {
				log.info(book3.toString());
			}
			log.info("");			
		};
		
	}
	
}
