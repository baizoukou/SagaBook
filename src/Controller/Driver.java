package Controller;

import java.io.File;
import java.util.List;

import Model.Books;
import Utilities.Serializer;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

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

	public Controller.SagaAPI SagaAPI;

	public void Main() throws Exception
	{
		File  datastore = new File("datastore.xml");// is calling file from data store if file not exist call from prime
		Serializer serializer = new Serializer(datastore);

		SagaAPI = new Controller.SagaAPI(serializer);

		if (datastore.isFile())
		{
			SagaAPI.load();
		} else {
			SagaAPI.prime();
		}

	}

	public static void main(String[] args) throws Exception {
	 Driver main = new Driver();


		Shell shell = ShellFactory.createConsoleShell("lm",
				"Welcome to the SagaBooks platform, when you are ready Let get started - ?help for instructions",
				main);
		shell.commandLoop();
	}



	@Command(description = "Add a new User")
	public void addUsers(@Param(name = "firstname") String firstname, @Param(name = "lastname") String lastname,
			@Param(name = "age") int age, @Param(name = "gender") String gender,
			@Param(name = "occupation") String occupation) {
		SagaAPI.addUser(firstname, lastname, age, gender, occupation);
	}

	@Command(description = "Delete a Users")
	public void removeUsers(@Param(name = "id") Long id) {
		SagaAPI.removeUser(id);
	}

	@Command(description = "Add a Book")
	public void addBooks(@Param(name = "title") String title, @Param(name = "releaseDate") String releaseDate,
			@Param(name = "url") String name) {
		SagaAPI.addBooks(title, releaseDate, name);

	}

	@Command(description = "Add a Rating")
	public void addRating(@Param(name = "users") Long user, @Param(name = "books") Long books,
			@Param(name = "rating") int rating, @Param(name = "average") double average) {
		SagaAPI.addRating(user, books, rating);
	}

	@Command(description="Get a user rating")
	public void getRating (@Param(name="by id") long id)
	{
		SagaAPI.getRating(id);
	}

	@Command(description="Get  user recomendation")// from the movie list iterate through and get top ten movies
	public void getTop10 ()
	{
		List<Books> books = SagaAPI.getSagaBook();
		for (Books b : books) {
			System.out.println(b);
		}
	}



}