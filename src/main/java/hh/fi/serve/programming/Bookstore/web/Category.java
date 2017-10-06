package hh.fi.serve.programming.Bookstore.web;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	//@id creates an ID column for the table
	@Id
	//Generates automatically a unique PK for every new entity object
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	//Create a 1 to * relationship bet. book & category
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	//constructor
	public Category(){}
	
	public Category(String name){
		super();
		this.name= name;
	
	}
	//Setters & getters 

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + ", books=" + books + "]";
	}

	
}


	
	