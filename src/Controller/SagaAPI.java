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
//	public Map<Long, Users> usersIndex = new HashMap<>();
//	public Map<Long, Books> booksIndex = new HashMap<>();
//	public ArrayList<Rating> ratings = new ArrayList <>();



	public SagaAPI() {
	}
	  
	  public SagaAPI(Serializer serializer)
	  {
	    this.serializer = serializer;
	  }

	public void prime() throws Exception
	{
		BookLoader.importUser();
		BookLoader.importBooks();
		BookLoader.importRating();
		store();

	}

// keep track and oto encrement each time
	public Users addUser(String firstname, String lastname,int age, char gender,  String occupation) {
		Users users = new Users(BookLoader.usercounter++, firstname,lastname,age, gender, occupation);
		BookLoader.users.put(users.userId, users);
		return users;
	}

	public Users removeUser(Long id) {
		BookLoader.users.remove(id);
		return null;
	}


	public Books addBooks(String title, String releaseDate,String author) {
		Books books = new Books(BookLoader.bookcounter++, title, releaseDate, author);
		BookLoader.books.put(books.ID, books);
		return books;
	}
	
	public Users removeBooks(Long id) {
		BookLoader.books.remove(id);
		return null;
	}
// Book recommender
	
	public List<Books> getTopTenBook() {// Sort books by ratings class as user recommender
		int n = 10;
		List<Books> books = new ArrayList<Books>(BookLoader.books.values());
		Collections.sort(books);
    	return books.subList(0, n);
	}

	public Rating addRating(Long userid, Long Bookid, int therating) {
		Rating rating = new Rating(userid, Bookid, therating);
		rating.add(rating);
		return rating;

	}


	public void store() throws Exception {
		
		System.out.println("Storing...");
		serializer.push(BookLoader.books);
		serializer.push(BookLoader.users);
		serializer.push(BookLoader.rating);
			serializer.write();
	

	}
	@SuppressWarnings("unchecked")
	public void load() throws Exception{
	    serializer.read();
		BookLoader.rating = (ArrayList<Rating>) serializer.pop();
		BookLoader.users = (HashMap<Long, Users>) serializer.pop();
		BookLoader.books = (HashMap<Long, Books>) serializer.pop();

	}
	
    public Books getBook(Long id ) {
    return 	BookLoader.books.get(id);
    	
    }
    
    public Users getUser(Long id ) {
        return 	BookLoader.users.get(id);
        	
        }
    
    // look up book id in the hashmap then return the average rating
    
	public double getAverageRating(long id) {
		Books b = getBook (id);// calling getBook method
		double d = b.getAverageRating();// calling getAverageRating store in d
		return d;
	}


}