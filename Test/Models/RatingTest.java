/**
 * @author alexandre baizoukou
 */
package Models;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Rating;

public class RatingTest
{

	/**
	 * Test to verify that a Rating object can be created correctly
	 */
	@Test
	public void testCreateRating()
	{
		Rating rating = new Rating(1, 10, 5, 234324234);
		assertEquals(1, rating.userId);
		assertEquals(10, rating.booksId);
		assertEquals((Integer) 5, rating.rating);
		
	}

}
