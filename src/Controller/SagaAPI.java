package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.Books;
import Model.Rating;
import Model.Users;
import Utilities.Serializer;
import Utilities.XMLSerializer;
import utils.BookLoader;

/*
 * *author alexandre Baizoukou WIT Bsc Applied Computing
 * @version 1.0
 * @author Franck Walsh WIT Lecturer
 * @author Eamon Delastar WIT Lecturer
 * @author Martin Harrigan Assistant Lecturer WIT 
 * @author Cormen, Leiserson, Rivest, Stein, Introduction to Algorithms, MIT Press
 * @author Fotakis. Course of Algorithms and Complexity at the National Technical University of Athens.
 * @author Tim Roughgarden Coursera 
 *  
 *  
 *  This class implement the data structured as members of the API class
 *  it defines suitable method signature for each of the features listed here
 *  it does not include the  UX
 *  
 *  
 */



@SuppressWarnings("unused")
public class SagaAPI {
	private Serializer serializer;
	public Map<Long, Users> usersIndex = new HashMap<>();
	public Map<Long, Books> booksIndex = new HashMap<>();
	public ArrayList<Rating> ratings = new ArrayList <>();



	public SagaAPI() {
	}
	  
	  public SagaAPI(Serializer serializer)
	  {
	    this.serializer = serializer;
	  }

	public void prime() throws Exception
	{
		utils.BookLoader loader = new utils.BookLoader();
		usersIndex = loader.importUser();
	    booksIndex = loader.importBooks();
		ratings = loader.importRating();
		store();

	}

// keep track and oto encrement each time
	public Users addUser(String firstname, String lastname,int age, char gender,  String occupation) {
		Users users = new Users(BookLoader.usercounter++, firstname,lastname,age, gender, occupation);
		usersIndex.put(users.userId, users);
		return users;
	}

	public Users removeUser(Long id) {
		usersIndex.remove(id);
		return null;
	}


	public Books addBooks(String title, String releaseDate,String author) {
		Books books = new Books(BookLoader.bookcounter++, title, releaseDate, author);
		booksIndex.put(books.ID, books);
		return books;
	}

	public List<Books> getSagaBook() {
		int n = 10;
		System.out.println(booksIndex.size());
		List<Books> books2 = new ArrayList<Books>(booksIndex.values());
		Collections.sort(books2);
    	return books2.subList(0, n);
	}

	public Rating addRating(Long userid, Long movieid, int therating) {
		Rating rating = new Rating(userid, movieid, therating);
		ratings.add(rating);
		return rating;

	}


	public void store() throws Exception {
		// TODO Auto-generated method stub
		
		serializer.push(booksIndex);
		serializer.push(usersIndex);
		serializer.push(ratings);
			serializer.write();
	

	}
	@SuppressWarnings("unchecked")
	public void load() throws Exception{
	    serializer.read();
		ratings = (ArrayList<Rating>) serializer.pop();
		usersIndex = (Map<Long, Users>) serializer.pop();
		booksIndex = (Map<Long, Books>) serializer.pop();

	}

	public void getRating(long id) {
		// TODO Auto-generated method stub
		
	}




	


}