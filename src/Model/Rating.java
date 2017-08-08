/**
 * @author Alexandre
 */
package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import com.google.common.base.Objects;

/**
 * Rating class provides a model to hold rating objects with userid, bookid and rating id
 * @author Alexandre
 *
 */
public class Rating
{
	public long userId, booksId, stamp;
	public Integer rating;
	public double averageRating; //Calculated based on the average user ratings of a movie Calculated in the book class

	public Rating(long userId, long booksId, Integer rating, long stamp)
	{
		this.userId = userId;
		this.booksId = booksId;
		this.rating = rating;
		this.stamp = stamp;
	}

	public Rating(long userId, long booksId, int rating)
	{
		this.userId = userId;
		this.booksId = booksId;
		this.rating = rating;
	}
	
	public Rating(long booksId, double averageRating)
	{
		this.booksId = booksId;
		this.averageRating = averageRating;
	}
	public String toString()
	{
		return toStringHelper(this).addValue(userId)
				.addValue(booksId)
				.addValue(rating)
				.toString();
	}

	@Override  
	public int hashCode()  
	{  
		return Objects.hashCode(this.userId, this.booksId, this.rating, this.stamp);  
	}  

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Rating)
		{
			final Rating other = (Rating) obj;
			return Objects.equal(userId, other.userId) 
					&& Objects.equal(booksId,  other.booksId)
					&& Objects.equal(rating,  other.rating)
					&& Objects.equal(stamp,  other.stamp);
		}
		else
		{
			return false;
		}
	}

}
