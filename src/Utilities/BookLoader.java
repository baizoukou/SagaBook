/**
 * @author Alexandre
 */
package Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Books;
import Model.Rating;
import Model.Users;

/**
 * The parser class ensures the reading in of raw data from specified file paths
 * and the packaging of that data into specific Object types which are then grouped 
 * into specific data structures such as a HashMap or an ArrayList. 
 * @param <RatingByTimeComparator>
 *
 */
public class BookLoader<RatingByTimeComparator>
{
	Map<Long, Users> users = new HashMap<>(); //Stores all the User objects
	Map<Long, Books books = new HashMap<>(); //Stores all the Movie objects 
	List<Rating> ratings = new ArrayList<>(); //Stores all the Rating objects 
	Map<String, Rating> ratingsMap = new HashMap<>(); //Map to ensure unique ratings


	RatingByTimeComparator comparator = new RatingByTimeComparator(); //Initialising the comparator


	public BookLoader()
	{

	}

	/**
	 * Class to parse raw user data and store them in the users map
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public Map<Long, Users> parseUserData(String path) throws Exception
	{
		File usersFile = new File(path);
		In inUsers = new In(usersFile);
		String delims = "[|]";

		while (!inUsers.isEmpty())
		{
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) 
			{
				long userId = Long.parseLong(userTokens[0]);
				String firstName = userTokens[1];
				String lastName = userTokens[2];
				int age = Integer.parseInt(userTokens[3]);
				char gender = userTokens[4].charAt(0);
				String occupation = userTokens[5];
				Users user = new Users(userId, firstName, lastName, age, gender, occupation);
				users.put(userId, user);

			}
			else
			{
				throw new Exception("Invalid member length: "+ userTokens.length);
			}
		}
		inUsers.close();
		return users;
	}

	/**
	 * Parsing of raw movie data
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public Map<Long, Books> parseMovieData(String path) throws Exception 
	{
		File booksFile = new File(path);
		In inBooks = new In(booksFile);
		String delims = "[|]";

		while (!inBooks.isEmpty())
		{
			String booksDetails = inBooks.readLine();
			String[] movieTokens = booksDetails.split(delims);

			if (BooksTokens.length == 4) 
			{
				long booksId = Long.parseLong(movieTokens[0]);
				String title = booksTokens[1];
				String releaseDate = Integer.parseInt(releaseDate(booksTokens[2]);
				String author = booksTokens[3];
			
				Books books = new Books(Long.parseLong(booksId), title, releaseDate, author);
				books.put(booksId, books);
			}
			else
			{
				throw new Exception("Invalid member length: "+ booksTokens.length);
			}
		}
		inBooks.close();
		return books;
	}

	/**
	 * Parsing of raw rating data
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<Rating> parseRatingData(String path) throws Exception
	{
		File ratingsFile = new File(path);
		In inRatings = new In(ratingsFile);
		String delims = "[|]";

		while (!inRatings.isEmpty())
		{
			String ratingDetails = inRatings.readLine();
			String[] ratingTokens = ratingDetails.split(delims);

			if (ratingTokens.length == 4) 
			{
				long userId = Long.parseLong(ratingTokens[0]);
				long movieId = Long.parseLong(ratingTokens[1]);
				Integer rating = Integer.parseInt(ratingTokens[2]);
				long timestamp = Long.parseLong(ratingTokens[3]);
				Rating r = new Rating(userId, movieId, rating, timestamp);

				ratings.add(r);

			}
			else
			{
				throw new Exception("Invalid member length: "+ ratingTokens.length);
			}
		}
		inRatings.close();
		
		//Sort Rating objects based on the stamp to get most recent rating on duplicates	
		Collections.sort(ratings, comparator);

		//Using a Map to filter out duplicates
		for (Rating r: ratings)
		{
			ratingsMap.put(r.userId + "u" + r.booksId + "m", r);
		}

		//Placing duplicates into an ArrayList to sort as Map does not guarantee order
		List<Rating> ratingsFiltered = new ArrayList<>(ratingsMap.values());
		Collections.sort(ratingsFiltered, comparator);

//		System.out.println(users.size());

		//Adds respective ratings to users and movies
		for (Rating rating: ratingsFiltered)
		{
			Users user = getUsers(rating.userId);
			Books books = getBooks(rating.booksId);
			Rating r = new Rating(user.userId, books.booksId, rating.rating);

			users.addRatedBooks(books.booksId, r);
			books.addUsersRatings(users.usersId, r);
		}
		return ratingsFiltered;
	}

	public Users getUser(long l)
	{
		return users.get(l);
	}

	public Books getBooks(long i)
	{
		return books.get(i);
	}
	
	public int getBooksSize()
	{
		return books.size();
	}

}
