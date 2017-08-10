/**
 * @author Alexandre
 */
package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.base.Objects;

/**
 * Rating class provides a model to hold rating objects with userid, bookid and rating id
 * @author Alexandre
 *
 */
public class Rating implements Collection<Rating>
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

	@Override
	public boolean add(Rating arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Rating> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Rating> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
