package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import Model.Books;
import Model.Users;
import Utilities.BookLoader;
import Utilities.Serializer;
import Utitities.XMLSerializer;

/*
 * @author alexandre Baizoukou WIT Bsc Applied Computing
 * @version 1.0
 * @author Franck Walsh WIT Lecturer
 * @author Eamon Delastar WIT Lecturer
 * @author Martin Harrigan Assistant Lecturer WIT 
 * @author Cormen, Leiserson, Rivest, Stein, Introduction to Algorithms, MIT Press
 * @author Fotakis. Course of Algorithms and Complexity at the National Technical University of Athens.
 * @author Tim Roughgarden Coursera 
 *  
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

	public SagaBooksAPI SagaAPI;

	public Main() throws Exception
	{
		File  datastore = new File("datastore.xml");// is calling file from data store if file not exist call from prime
		Serializer serializer = new XMLSerializer(datastore);

		tenAPI = new SagaBooksAPI(serializer);

		if (datastore.isFile())
		{
			tenAPI.load();
		} else {
			tenAPI.prime();
		}

	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();


		Shell shell = ShellFactory.createConsoleShell("lm",
				"Welcome to the SagaBooks platform, when you are ready Let get started - ?help for instructions",
				main);
		shell.commandLoop();
	}



	@Command(description = "Add a new User")
	public void addUsers(@Param(name = "firstname") String firstname, @Param(name = "lastname") String lastname,
			@Param(name = "age") int age, @Param(name = "gender") String gender,
			@Param(name = "occupation") String occupation) {
		tenAPI.addUsers(firstname, lastname, age, gender, occupation);
	}

	@Command(description = "Delete a Users")
	public void removeUsers(@Param(name = "id") Long id) {
		tenAPI.removeUsers(id);
	}

	@Command(description = "Add a Movie")
	public void addBooks(@Param(name = "title") String title, @Param(name = "releaseDate") String releaseDate,
			@Param(name = "url") String name) {
		tenAPI.addMovie(title, releaseDate, name);

	}

	@Command(description = "Add a Rating")
	public void addRating(@Param(name = "users") Long user, @Param(name = "books") Long books,
			@Param(name = "rating") int rating, @Param(name = "average") double average) {
		tenAPI.addRating(users, books, rating);
	}

	@Command(description="Get a user rating")
	public void getRating (@Param(name="by id") long id)
	{
		tenAPI.getRating(id);
	}

	@Command(description="Get  user recomendation")// from the movie list iterate through and get top ten movies
	public void getTop10 ()
	{
		List<Books> movies = SagaAPI.getTenHotestBooks();
		for (Books b : books) {
			System.out.println(b);
		}
	}



}