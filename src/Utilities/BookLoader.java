package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import Model.Users;
import Model.Books;
import Model.Rating;
import Model.Users;

@SuppressWarnings("unused")
public class BookLoader {
	/*
	 * * @author alexandre Baizoukou WIT Bsc Applied Computing
	 * 
	 * @version 1.0
	 * 
	 * @author Eamon Delastar WIT Lecturer
	 * 
	 * @author Franck Walsh WIT Lecturer
	 * 
	 * @author Martin Harrigan Assistant Lecturer WIT
	 * 
	 * @author Cormen, Leiserson, Rivest, Stein, Introduction to Algorithms, MIT
	 * Press
	 * 
	 * @author Fotakis. Course of Algorithms and Complexity at the National
	 * Technical University of Athens.
	 * 
	 * @author Tim Roughgarden Coursera
	 * 
	 * 
	 * This class implement a simple loading of text file that will be later on
	 * serialize importMovie is a Hashmap same as importUser meaning while
	 * importRating is an array of ratings this will help mapping class Movie to
	 * class User importMovie token is based on long, String,int and String
	 * importUser token is based on long, String,String, int, String, String
	 * importRating is based on long, int, int
	 * 
	 * @param importMovie<Hashmap>
	 * 
	 * @param importUser<Hashmap>
	 * 
	 * @param importRating<Arrays>
	 * 
	 */

	public static final String r = null;

	public ArrayList<Rating> rating = new ArrayList<Rating>();
	public HashMap<Long, Books> movies = new HashMap<Long, Books>();
	public HashMap<Long, Users> users = new HashMap<Long, Users>();

	@SuppressWarnings("resource")
	public HashMap<Long, Books> importBooks() throws Exception {
		String url = "./books_small/books.dat";

		BufferedReader in = null;
		File moviesFile = new File("books_small/movie.dat");
		Scanner inBooks = new Scanner(moviesFile);
		String delims = "[|]";// each field in the file is separated(delimited)
		// by a space.
		while (inBooks.hasNextLine()) {
			// get books from data source
			String booksDetails = inBooks.nextLine().trim();
			// parse user details string
			String[] booksTokens = booksDetails.split(delims);

			// output user data to console.
			if (booksTokens.length >= 4) {

				long id = Long.parseLong(booksTokens[0]);
				Books b = new Books(booksTokens[1], Integer.parseInt(booksTokens[2]), booksTokens[3]);
				Books.put(new Long(id), b);

			} else {
				throw new Exception("Are you sure doing the right thing?:" + booksTokens.length);
			}
		}
		inBooks.close();

		return Books;
	}

	@SuppressWarnings("resource")
	public HashMap<Long, Users> importUser() throws Exception {
		String url = "./books_small/users.dat";

		BufferedReader in = null;
		File usersFile = new File("./books_small/users.dat");
		Scanner inUsers = new Scanner(usersFile);
		String delims = "[|]";// each field in the file is separated(delimited)
		// by a space
		while (inUsers.hasNextLine()) {
			// get user from data source
			String usersDetails = inUsers.nextLine().trim();

			// parse user details string
			String[] usersTokens = usersDetails.split(delims);

			// output user data to console.
			if (usersTokens.length >= 6) {

				long id = Long.parseLong(usersTokens[0]);
				Users u = new Users(usersTokens[1], usersTokens[2], Integer.parseInt(usersTokens[3]), usersTokens[4],
						usersTokens[5], Integer.parseInt(usersTokens[6]));
				users.put(new Long(id), u);
			} else {
				throw new Exception("Are you sure doing the right thing?:" + usersTokens.length);
			}
		}
		inUsers.close();

		return users;
	}

	private String url = "./data/rating.dat";

	public ArrayList<Rating> getRating() {
		return rating;
	}

	public ArrayList<Rating> importRating() throws Exception {
		BufferedReader in = null;
		File ratingsFile = new File("././data/rating.dat");
		Scanner inRatings = new Scanner(ratingsFile);
		String delims = "[|]";
		// inRatings.nextLine();
		while (inRatings.hasNextLine()) {
			// get rating from data source
			String ratingDetails = inRatings.nextLine().trim();
			// parse user details string
			String[] ratingTokens = ratingDetails.split(delims);

			// output user data to console.
			if (ratingTokens.length == 4) {

				long id = Long.parseLong(ratingTokens[0]);
				Users users = users.get(id);
				long Books = Long.parseLong(ratingTokens[1]);
				Books b = Books.get(id);
				Rating r = new Rating(id, Books, Integer.parseInt(ratingTokens[2]));
				rating.add(r);
			} else {
				throw new Exception("Are you sure doing the right thing?:" + ratingTokens.length);
			}
		}

		inRatings.close();

		return rating;

	}
}
