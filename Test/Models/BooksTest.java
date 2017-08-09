/**
 * @author alexandre
 */
package Models;

import static org.junit.Assert.*;

import java.awt.print.Book;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Model.Books;
import Model.Rating;

/**
 * Test to verify that a Movie object can be created correctly and 
 * that the methods within it function as per intended
 */
public class BooksTest
{
	Books books;

	@Before
	public void setUp() throws Exception
	{
		books = new Books(2L, "applied", "1996", "Jhon");
	}

	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test to create a Books object
	 */
	@Test
	public void testCreateBooks()
	{
		assertEquals(2,books.ID);
		assertEquals("applied", books.title);
		assertEquals("1996", books.releaseDate);
		assertEquals("Jhon", books.author);
	}

	/**
	 * Test to get the average of all the ratings by users of books
	 */
	@Test
	public void testGetAverageRating()
	{
		books.addUserRatings(1L, new Rating(1L, books.ID, 1, 1L));
		books.addUserRatings(2L, new Rating(1, books.ID, 3, 2L));
		books.addUserRatings(3L, new Rating(1, books.ID, 5, 4L));
		assertEquals(3.0, books.getAverageRating(), 0.01);
	}
}
