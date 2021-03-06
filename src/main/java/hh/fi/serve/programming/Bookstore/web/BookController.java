package hh.fi.serve.programming.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



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
		// Show all students
	    @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	
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
	    	model.addAttribute("categorys",crepository.findAll());
			return "editbook";
	    	
	    }
	    
	    //REST service - get all books JSON
	    @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book>bookListRest(){
	    	return(List<Book>) repository.findAll();
	    }
	    
	    //REST service - get book by ID
	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Book findBookRest(@PathVariable("id")Long bookid){
	    	return repository.findOne(bookid);
	    }
	       
	    
}
