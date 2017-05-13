/**
 * @author Alexandre
 */
package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

/**
 * Books class provides the attributes of book object
 *
 */
public class Books
{
	public String title;
	public String releaseDate;
	public String author;
	public long booksId;
	
	public Map<Long, Rating> userRatings = new HashMap<>();

	

	public Books(String title, String releaseDate, String author, long bookId, Map<Long, Rating> userRatings) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.author = author;
		this.booksId = booksId;
		this.userRatings = userRatings;
	}

	/**
	 * Add a particular users rating of this movie
	 * @param userId
	 * @param rating
	 */
	public void addUserRatings(Long userId, Rating rating)
	{
		userRatings.put(userId, rating);
	}

	/**
	 * Get the average user ratings  
	 * @return
	 */
	public double getAverageRating()
	{
		double totalRating = 0.0; 
		double averageRating = 0.0;

		for (Rating rating: userRatings.values())
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
		return "Books [title=" + title + ", releaseDate=" + releaseDate + ", author=" + author + ", bookId=" + booksId
				+ ", userRatings=" + userRatings + ", getAverageRating()=" + getAverageRating() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override  
	public int hashCode()  
	{  
		return Objects.hashCode(this.booksId, this.title, this.releaseDate, this.author);  
	}  

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Books)
		{
			final Books other = (Books) obj;
			return Objects.equal(booksId, other.booksId) 
					&& Objects.equal(title,  other.title)
					&& Objects.equal(releaseDate,  other.releaseDate)
					&& Objects.equal(userRatings,  other.userRatings)
					&& Objects.equal(author,  other.author);
		}
		else
		{
			return false;
		}
	}
}
