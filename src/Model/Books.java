package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

/*
 * * @author alexandre Baizoukou WIT Bsc Applied Computing
 * @version 1.0
 * @author Eamon Delastar WIT Lecturer
 * @author Franck Walsh WIT Lecturer
 *  This class is content a hash map of movie data type
 *  define movie object
 *  generate getters & setters
 *  
 */

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import com.google.common.base.Preconditions;

@SuppressWarnings("unused")
public class Books implements Comparable<Books> {

	private static long counter = 0;
	final long id;
	final String title;
	final int releaseDate;
	final String name;

	private int sumRatings;
	private int sumReviewers;

	public Books(String title, int releaseDate, String name) {

		Preconditions.checkNotNull(title);
		Preconditions.checkNotNull(releaseDate);
		Preconditions.checkNotNull(name);

		this.id = counter++;
		this.title = title;
		this.releaseDate = releaseDate;
		this.name = name;

	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(id).addValue(title).addValue(releaseDate).addValue(name).toString();
	}

	public void addRating(Rating rating) {
		Preconditions.checkNotNull(rating);
		sumRatings += rating.getRating();
		sumReviewers++;
	}

	public double getAverageRating() {
		if (sumReviewers == 0) {
			return Double.NaN;
		} else {
			return (double) sumRatings / sumReviewers;
		}
	}

	public int getTotalRating() {
		return this.sumRatings;
	}

	public long getId() {
		return id;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public String getname() {
		return name;
	}

	@Override
	public int compareTo(Books b) {

		return Double.compare(getAverageRating(), b.getAverageRating());
	}

}
