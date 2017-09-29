package hh.fi.server.programming.Bookstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//JPA Book Entity - maps this class to a table named Book
@Entity 
public class Book {
	//@id is used to create an ID column for the table
	@Id
	//Generates automatically a unique PK for every new entity object
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private int year;
	private int isbn;
	private double price;
	
	//Constructors
	protected Book(){}
	
	public Book(String title, String author, int year, int isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	//setter & getters
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getIsbn() {
		return isbn;
	}



	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}



	public double getPrice() {
		return price;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}



	
}
