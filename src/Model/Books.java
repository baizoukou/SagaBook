/**
 * @author Alexandre
 */
package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;

/**
 * Books class provides the attributes of book object
 *
 */
public class Books implements Comparable<Books>
{
	public long ID;
	public String title;
	public String releaseDate;
	public String author;
	
	
	public List< Rating> userRatings = new ArrayList<>();//arraylist that just store rating of a book

	

	public Books( Long ID,String title, String releaseDate, String author) {
		super();
		this.ID = ID;
		this.title = title;
		this.releaseDate = releaseDate;
		this.author = author;
		//this.userRatings = userRatings;
	}

	/**
	 * Add a particular users rating of this movie
	 * @param userId
	 * @param rating
	 */
	public void addUserRatings(Long userId, Rating rating)
	{
		//userRatings.put(userId, rating);
	}

	/**
	 * Get the average user ratings  
	 * @return
	 */
	public double getAverageRating()
	{
		double totalRating = 0.0; 
		double averageRating = 0.0;

		for (Rating rating: userRatings)
		{
			totalRating += rating.rating;
		}
		if (userRatings.size() > 0)
		{
			return averageRating = totalRating/userRatings.size();
		}
		return averageRating;
	}
	

	@Override
	public String toString() {
		return "Books [ ID=" + ID
				+ ",title=" + title + ", releaseDate=" + releaseDate + ",author=" + author + ",  userRatings=" + userRatings + ", getAverageRating()=" + getAverageRating() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

//	@Override  
//	public int hashCode()  
//	{  
//		return Objects.hashCode(this.booksId, this.title, this.releaseDate, this.author);  
//	}  

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Books)
		{
			final Books other = (Books) obj;
			return Objects.equal(ID, other.ID) 
					&& Objects.equal(title,  other.title)
					&& Objects.equal(releaseDate,  other.releaseDate)
					&& Objects.equal(author,  other.author);
					//&& Objects.equal(userRatings,  other.userRatings);
					//&& Objects.equal(author,  other.author);
		}
		else
		{
			return false;
		}
	}

	@Override
	public int compareTo(Books b){ // return either o or -1
		
		double b1 =  this.getAverageRating();
		double b2 = b.getAverageRating();
		
		if (b1 < b2){
			return - 1;
		}
		else{
			if(b1 > b2){
				return 1; 
			}else
					return 0;
			}
		}
	
}
