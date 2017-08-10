package Controller;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Model.Books;
import Model.Rating;
import Model.Users;
import Utilities.Serializer;
import Utilities.XMLSerializer;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.BookLoader;

/*
 * @author alexandre Baizoukou WIT Bsc Applied Computing
 * @version 1.0
 * @author Franck Walsh WIT Lecturer
 *  This class is the user menu  
 *  add user
 *  delete user
 *  add movie 
 *  get movie detail
 *  rate movie
 *  get a user rating
 *  get recommendation for any given user
 *  give the list of top Ten Hottest Movies
 *  read the movie data base from external file
 *  save file in an XML file 
 *  

 */

@SuppressWarnings("unused")
public class Driver {

	public Controller.SagaAPI SagaAPI = new Controller.SagaAPI(); 

	public Driver()
	{
		File  datastore = new File("datastore.xml");// is calling file from data store if file not exist call from prime
		Serializer serializer = new XMLSerializer(datastore);
        
		SagaAPI = new Controller.SagaAPI(serializer);

		if (datastore.isFile())
		{
			
			try {
				SagaAPI.load();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				SagaAPI.prime();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
	 Driver main = new Driver();


		Shell shell = ShellFactory.createConsoleShell("lm",
				"Welcome to the SagaBooks platform, when you are ready Let get started - ?help for instructions",
				main);
		shell.commandLoop();
	}

	@Command(description="Import all books")// from the books list iterate through and get all books
	public void ImportBooks()
	{
		try {
			BookLoader.importBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Command(description="GetAllBooks")//  all books
	public void GetAllBooks()
	{
		Collection<Books> books = BookLoader.books.values();
		for (Books b : books) {
			System.out.println(b);
		}
	}

	@Command(description="Get a single book")
	public void getBook (@Param(name="by id") long id)
	{
		System.out.println(SagaAPI.getBook(id));
	}
	
	@Command(description="Import all Users")// from the books list iterate through and get all books
	public void ImportUsers()
	{
		try {
			BookLoader.importUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Command(description="GetAllUsers")//  all Users
	public void GetAllUsers()
	{
		Collection<Users> users = BookLoader.users.values();
		for (Users u : users) {
			System.out.println(u);
		}
	}
	
	@Command(description="Get a single user")
	public void getUser (@Param(name="by id") long id)
	{
		System.out.println(SagaAPI.getUser(id));
	}
	

	@Command(description="Import all Rating")// from the books list iterate through and get all books
	public void ImportRating()
	{
		try {
			BookLoader.importRating();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Command(description="GetAllRatings")//  all Users
	public void GetAllRating()
	{
		Collection<Rating> rating = ( BookLoader.rating);
		for (Rating r : rating) {
			System.out.println(r);
		}
	}
	
	
	
	
	@Command(description = "Add a new User")
	public void addUsers(@Param(name = "firstname") String firstname, @Param(name = "lastname") String lastname,
			@Param(name = "age") int age, @Param(name = "gender") String gender,
			@Param(name = "occupation") String occupation) {
		char g = gender.charAt(0);
		SagaAPI.addUser(firstname, lastname, age, g, occupation);
	}

	@Command(description = "Delete a Users")
	public void removeUsers(@Param(name = "id") Long id) {
		SagaAPI.removeUser(id);
	}

	@Command(description = "Add a Book")
	public void addBooks(@Param(name = "title") String title, @Param(name = "releaseDate") String releaseDate,
			@Param(name = "author") String author) {
		SagaAPI.addBooks(title, releaseDate, author);

	}

	@Command(description = "Add a Rating")
	public void addRating(@Param(name = "users") Long user, @Param(name = "books") Long books,
			@Param(name = "rating") int rating) {
		SagaAPI.addRating(user, books, rating);
	}
	

	@Command(description="Get an average rating for a book")
	public void getAverageRating (@Param(name="by id") long id)
	{
		System.out.println(SagaAPI.getAverageRating(id));
	}

	@Command(description="Get  user recomendation")// from the movie list iterate through and get top ten movies
	public void getTop10 ()
	{
		List<Books> books = SagaAPI.getTopTenBook();
		for (Books b : books) {
			System.out.println(b);
		}
	}



}