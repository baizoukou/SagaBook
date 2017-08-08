package utils;



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

import Model.Books;
import Model.Rating;
import Model.Users;

@SuppressWarnings("unused")
public class BookLoader {
	/*
	 * * @author alexandre Baizoukou WIT Bsc Applied Computing
	 * @version 1.0
	 * @author Eamon Delastar WIT Lecturer
	 * @author Franck Walsh WIT Lecturer
	 * This class implement a simple loading of text 
	 * file that will be later on serialize
	 * importBooks is a Hashmap same as importUser
	 * meaning while importRating is an array of ratings
	 * this will help mapping class Movie to class User 
	 * importBooks token is based on long, String,int and String
	 * importUser token is based on long, String,String, int, String, String
	 * importRating is based on long, int, int
	 * 
	 * @param importBooks<Hashmap>
	 * @param importUsers<Hashmap>
	 * @param importRating<Arrays>
	 * 
	 */

	public static final String r = null;

	public static  ArrayList<Rating> rating = new ArrayList<Rating>();
	public static HashMap<Long, Books> books = new HashMap<Long, Books>();
	public static  HashMap<Long, Users> users = new HashMap<Long, Users>();

	@SuppressWarnings("resource")
	public   HashMap<Long, Books> importBooks() throws Exception 	
	{
	
		BufferedReader in = null;
		File booksFile = new File("./books_small/books.dat");
		Scanner inBooks = new Scanner(booksFile);
		String delims = "[|]";// each field in the file is separated(delimited)
		// by a space. 
		while (inBooks.hasNextLine()) {
			// get movies from data source
			String BooksDetails = inBooks.nextLine().trim();
			// parse user details string
			String[] BooksTokens = BooksDetails.split(delims);

			// output user data to console.
			if (BooksTokens.length >= 4) {

				long id = Long.parseLong(BooksTokens[0]);
				Books b = new Books( BooksTokens[1],BooksTokens[2],BooksTokens[3], null );
				books.put(new Long(id), b);


			}
			else{
				throw new Exception("Are you sure doing the right thing?:"+ BooksTokens.length);
			}
		}
		inBooks.close();

		return books;
	}

	@SuppressWarnings("resource")
	public HashMap<Long, Users> importUser() throws Exception 
	{
		BufferedReader in = null;
		File usersFile = new File("./books_small/users.dat");
		Scanner inUsers = new Scanner(usersFile);
		String delims = "[|]";// each field in the file is separated(delimited)
		// by a space
		while (inUsers.hasNextLine()) {
			// get user from data source
			String usersDetails =inUsers.nextLine().trim();

			// parse user details string
			String[] usersTokens = usersDetails.split(delims);

			// output user data to console.
			if (usersTokens.length >= 6) {

				long id = Long.parseLong(usersTokens[0]);
				Users u = new Users(usersTokens[1],usersTokens[2],Integer.parseInt(usersTokens[3]), usersTokens[4], usersTokens[5]);
				users.put(new Long(id), u);
			}
			else{
				throw new Exception("Are you sure doing the right thing?:"+ usersTokens.length);
			}
		}
		inUsers.close();

		return users;
	}

	public ArrayList<Rating> getRating() {
		return rating;
	}

	public ArrayList<Rating> importRating() throws Exception {
		BufferedReader in = null;
		File ratingsFile = new File("././books_small/ratings.dat");
		Scanner inRatings = new Scanner(ratingsFile);
		String delims = "[|]";
		//			inRatings.nextLine();
		while (inRatings.hasNextLine()) {
			// get rating from data source
			String ratingDetails = inRatings.nextLine().trim();
			// parse user details string
			String[] ratingTokens = ratingDetails.split(delims);

			// output user data to console.
			if (ratingTokens.length == 4) {

				long id = Long.parseLong(ratingTokens[0]);
				Users user = users.get(id);
				long Books = Long.parseLong(ratingTokens[1]);
				Books book = book.get(Books);
				Rating r = new Rating(id,Books,Integer.parseInt(ratingTokens[2]));
				rating.add(r);
			}
			else{
				throw new Exception("Are you sure doing the right thing?:"+ ratingTokens.length);
			}
		}

		inRatings.close();

		return rating;

	}
}






