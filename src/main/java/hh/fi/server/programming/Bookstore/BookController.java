package hh.fi.server.programming.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
//@ResponseBody
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	/*
		//GET method - URL parameters
		@RequestMapping("/index")
		public String greetingRequest(@RequestParam(name="name",required=false, defaultValue="Stranger")String name){
			return "Greetings " + name;
		}
	*/
		
		//shows all the books from the DB in a table
	    @RequestMapping(value ="/booklist")
	    public String bookList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "booklist";
	    }
	    //****to add a new book***
	    
	    //step 1 - create empty book object
	    @RequestMapping(value = "/addbook")
	    public String addStudent(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categorys",crepository.findAll());
	        return "addbook";
	    }
	    
	    //Step 2 - fill object with data from the form with a POST method
	    @RequestMapping(value="/savebook",method =RequestMethod.POST)
	    public String save(Book book){
	    	repository.save(book);
	    	//once the book object filled with the parameters from the form is saved to our 
	    	//repository we redirect back to the main book list page.
	    	return "redirect:booklist";
	    }
	    
	    //delete a book
	    //in value we take the ID
	    @RequestMapping(value="/delete{id}",method = RequestMethod.GET)
	    //@PathVariable indicates that a method parameter should be bound to a URI template variable
	    public String deleteBook(@PathVariable("id")Long bookId,Model model){
			repository.delete(bookId);
	    	return "redirect:booklist";	
	    }
	    
	    //Edit book
	    @RequestMapping(value="/edit{id}", method =RequestMethod.GET)
	    public String editBook(@PathVariable("id") Long bookId,Model model){
	    	model.addAttribute("book",repository.findOne(bookId));
			return "editbook";
	    	
	    }
	    
}
