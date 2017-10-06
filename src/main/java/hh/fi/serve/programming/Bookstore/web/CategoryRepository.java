package hh.fi.serve.programming.Bookstore.web;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {
	//defining query method
	List<Category>findByName(String Name);




	
}