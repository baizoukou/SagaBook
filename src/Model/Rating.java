package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.io.FileNotFoundException;

/*
 * @author alexandre Baizoukou WIT Bsc Applied Computing
 * @version 1.0
 * @author Eamon Delastar WIT Lecturer
 * @author Franck Walsh WIT Lecturer
 *  This class construct a movie rating and recommend a movie to a user based similarity a user 
 *  has with other users   then check movies that other users have seen that current user has not yet seen  
 *  and recommend based on these criteria.
 * Then calculate and display the top 10 movies base on average viewers
 * @param id the id of the user
 * @param id the id of the movie
 * @param current rating
 * @param average the average rating of a movie 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.google.common.base.Preconditions;

import Utilities.BookLoader;

@SuppressWarnings("unused")
public class Rating

{
	private Users users;
	private Books books;
	int rating;
	double average;

	public Books getBooks() {
		return books;
	}

	public Rating(long usersId, long booksId, int rating) {
		Preconditions.checkArgument(usersId < 1000);
		Preconditions.checkArgument(booksId < 1800);
		Preconditions.checkArgument(rating <= 5);
		this.users = users;
		this.books = books;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(users).addValue(books).addValue(rating).toString();
	}

	public Rating(ArrayList<Rating> rating2) {
		// TODO Auto-generated constructor stub
	}

	public Users getUsers() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public static List<Rating> r = new ArrayList<>();

}