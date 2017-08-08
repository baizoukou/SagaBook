/**
 * Fixture data obtained from small data set provided
 */
package UtilitiesTest;

import Model.Books;
import Model.Rating;
import Model.Users;

public class FixtureTest
{
  public static Users[] usersFixtures =
  {
    new Users (1L, "Leonard", "Hernandez", 24, 'M', "technician"),
    new Users (2L, "Melody", "Roberson", 53, 'F', "other"),
    new Users (3L, "Gregory", "Newton", 23, 'M', "writer"),
    new Users (4L, "Oliver", "George", 24, 'M', "technician"),
    new Users (5L, "Jenna", "Parker", 33, 'F', "other")
  };

  public static Books[] booksFixtures =
  {
  	new Books(1L, "Toy", 1995, "osca"),
  	new Books(2L, "GoldenEye (1995)", 1995, "bray"),
  	new Books(3L, "Four Rooms (1995)", 1995, "rick"),
  	new Books(4L, "Get Shorty (1995)", 1995, "debo"),
  	new Books(5L, "Copycat (1995)", 1995, "staph"),
  	new Books(6L, "waterford", 1995, "martin"),
  	new Books(7L, "Sweet marriage", 1995, "roland"),
  	new Books(8L, "awana", 1995, "alex"),
  	new Books(9L, "man kind", 1995, "brice"),
  	new Books(10L, "Ireland", 1996, "theo")
  };
 
  public static Rating[]ratingsFixtures =
  {
  	new Rating(1, 7, 1, 874965739), 
  	new Rating(1, 2, 5, 875072442), 
  	new Rating(5, 3, 3, 875635225), 
  	new Rating(5, 5, -4, 875635723), 
  	new Rating(5, 1, 3, 875635748), 
  	new Rating(5, 2, 1, 875636053), 
  	new Rating(5, 7, 3, 875636198), 
  	new Rating(5, 10, -5, 875636493), 
  	new Rating(5, 8, 1, 875720691), 
  	new Rating(5, 4, -5, 875721432), 
  	new Rating(1, 5, 3, 878542441), 
  	new Rating(1, 3, 3, 878542699), 
  	new Rating(5, 9, -5, 878844423), 
  	new Rating(1, 10, 3, 887431883), 
  	new Rating(2, 2, 3, 888550774), 
  	new Rating(2, 7, 3, 888550871), 
  	new Rating(2, 3, 3, 888551922), 
  	new Rating(2, 10, 5, 888552084), 
  	new Rating(1, 9, 1, 888732928), 
  	new Rating(2, 4, -5, 888980085), 
  	new Rating(2, 1, 1, 888980240), 
  	new Rating(3, 7, -5, 889236983), 
  	new Rating(3, 4, -3, 889237224), 
  	new Rating(3, 2, -5, 889237224), 
  	new Rating(3, 5, -5, 889237269), 
  	new Rating(3, 3, -3, 889237269), 
  	new Rating(3, 8, 5, 889237455), 
  	new Rating(3, 1, 3, 889237455), 
  	new Rating(1, 1, 5, 889751711), 
  	new Rating(4, 8, 3, 892001445), 
  	new Rating(4, 3, 5, 892002352), 
  	new Rating(4, 1, 5, 892002353), 
  	new Rating(4, 6, 1, 892003459), 
  	new Rating(4, 7, 3, 892003525), 
  	new Rating(4, 10, 3, 892004275), 
  	new Rating(4, 4, 5, 892004409)
	
  };
  
  
  public void ratedMoviesFixtures()
  {
  	
  	usersFixtures[0].ratedBooks.put(1L, new Rating(1L, 1L, 5));
  	usersFixtures[0].ratedBooks.put(2L, new Rating(1L, 2L, 5));
  	usersFixtures[0].ratedBooks.put(3L, new Rating(1L, 3L, 3));
  	usersFixtures[0].ratedBooks.put(5L, new Rating(1L, 5L, 3));
  	usersFixtures[0].ratedBooks.put(7L, new Rating(1L, 7L, 1));
  	usersFixtures[0].ratedBooks.put(9L, new Rating(1L, 9L, 1));
  	usersFixtures[0].ratedBooks.put(10L, new Rating(1L, 10L, 3));
  	
  	usersFixtures[1].ratedBooks.put(1L, new Rating(2L, 1L, 1));
  	usersFixtures[1].ratedBooks.put(2L, new Rating(2L, 2L, 3));
  	usersFixtures[1].ratedBooks.put(3L, new Rating(2L, 3L, 3));
  	usersFixtures[1].ratedBooks.put(4L, new Rating(2L, 4L, -5));
  	usersFixtures[1].ratedBooks.put(7L, new Rating(2L, 7L, 3));
  	usersFixtures[1].ratedBooks.put(10L, new Rating(2L, 10L, 5));
  	
  	usersFixtures[2].ratedBooks.put(1L, new Rating(3L, 1L, 3));
  	usersFixtures[2].ratedBooks.put(2L, new Rating(3L, 2L, -5));
  	usersFixtures[2].ratedBooks.put(3L, new Rating(3L, 3L, -3));
  	usersFixtures[2].ratedBooks.put(4L, new Rating(3L, 4L, -3));
  	usersFixtures[2].ratedBooks.put(5L, new Rating(3L, 5L, -5));
  	usersFixtures[2].ratedBooks.put(7L, new Rating(3L, 7L, -5));
  	usersFixtures[2].ratedBooks.put(8L, new Rating(3L, 8L, 5));
  	
  	usersFixtures[3].ratedBooks.put(1L, new Rating(4L, 1L, 5));
  	usersFixtures[3].ratedBooks.put(3L, new Rating(4L, 3L, 5));
  	usersFixtures[3].ratedBooks.put(4L, new Rating(4L, 4L, 5));
  	usersFixtures[3].ratedBooks.put(6L, new Rating(4L, 6L, 1));
  	usersFixtures[3].ratedBooks.put(7L, new Rating(4L, 7L, 3));
  	usersFixtures[3].ratedBooks.put(8L, new Rating(4L, 8L, 3));
  	usersFixtures[3].ratedBooks.put(10L, new Rating(4L, 10L, 3));
  	
  	usersFixtures[4].ratedBooks.put(1L, new Rating(5L, 1L, 3));
  	usersFixtures[4].ratedBooks.put(2L, new Rating(5L, 2L, 1));
  	usersFixtures[4].ratedBooks.put(3L, new Rating(5L, 3L, 1));
  	usersFixtures[4].ratedBooks.put(4L, new Rating(5L, 4L, -5));
  	usersFixtures[4].ratedBooks.put(5L, new Rating(5L, 5L, -3));
  	usersFixtures[4].ratedBooks.put(7L, new Rating(5L, 7L, 3));
  	usersFixtures[4].ratedBooks.put(8L, new Rating(5L, 8L, 1));
  	usersFixtures[4].ratedBooks.put(9L, new Rating(5L, 9L, -5));
  	usersFixtures[4].ratedBooks.put(10L, new Rating(5L, 10L, -5)); 	
  }

  public void userRatingsFixtures()
  {
  	booksFixtures[0].userRatings.put(1L, new Rating(1, booksFixtures[0].ID, 5));
  	booksFixtures[0].userRatings.put(2L, new Rating(2, booksFixtures[0].ID, 1));
  	booksFixtures[0].userRatings.put(3L, new Rating(3, booksFixtures[0].ID, 3));
  	booksFixtures[0].userRatings.put(4L, new Rating(4, booksFixtures[0].ID, 5));
  	booksFixtures[0].userRatings.put(5L, new Rating(5, booksFixtures[0].ID, 3));
  	
  	booksFixtures[1].userRatings.put(1L, new Rating(1, booksFixtures[1].ID, 5));
  	booksFixtures[1].userRatings.put(2L, new Rating(2, booksFixtures[1].ID, 3));
  	booksFixtures[1].userRatings.put(3L, new Rating(3, booksFixtures[1].ID, -5));
  	booksFixtures[1].userRatings.put(5L, new Rating(5, booksFixtures[1].ID, 1));
  	
  	booksFixtures[2].userRatings.put(1L, new Rating(1, booksFixtures[2].ID, 3));
  	booksFixtures[2].userRatings.put(2L, new Rating(2, booksFixtures[2].ID, 3));
  	booksFixtures[2].userRatings.put(3L, new Rating(3, booksFixtures[2].ID, -3));
  	booksFixtures[2].userRatings.put(4L, new Rating(4, booksFixtures[2].ID, 5));
  	booksFixtures[2].userRatings.put(5L, new Rating(5, booksFixtures[2].ID, 1));
  	
  	booksFixtures[3].userRatings.put(2L, new Rating(2, booksFixtures[3].ID, -5));
  	booksFixtures[3].userRatings.put(3L, new Rating(3, booksFixtures[3].ID, -3));
  	booksFixtures[3].userRatings.put(4L, new Rating(4, booksFixtures[3].ID, 5));
  	booksFixtures[3].userRatings.put(5L, new Rating(5, booksFixtures[3].ID, -5));
  	
  	booksFixtures[4].userRatings.put(1L, new Rating(1, booksFixtures[4].ID, 3));
  	booksFixtures[4].userRatings.put(3L, new Rating(3, booksFixtures[4].ID, -5));
  	booksFixtures[4].userRatings.put(5L, new Rating(5, booksFixtures[4].ID, -3));
  	
  	booksFixtures[5].userRatings.put(4L, new Rating(4, booksFixtures[5].ID, 1));
  	
  	booksFixtures[6].userRatings.put(1L, new Rating(1, booksFixtures[6].ID, 1));
  	booksFixtures[6].userRatings.put(2L, new Rating(2, booksFixtures[6].ID, 3));
  	booksFixtures[6].userRatings.put(3L, new Rating(3, booksFixtures[6].ID, -5));
  	booksFixtures[6].userRatings.put(4L, new Rating(4, booksFixtures[6].ID, 3));
  	booksFixtures[6].userRatings.put(5L, new Rating(5, booksFixtures[6].ID, 3));
  	
  	booksFixtures[7].userRatings.put(3L, new Rating(3, booksFixtures[7].ID, 5));
  	booksFixtures[7].userRatings.put(4L, new Rating(4, booksFixtures[7].ID, 3));
  	booksFixtures[7].userRatings.put(5L, new Rating(5, booksFixtures[7].ID, 1));
 
  	booksFixtures[8].userRatings.put(1L, new Rating(1, booksFixtures[8].ID, 1));
  	booksFixtures[8].userRatings.put(5L, new Rating(5, booksFixtures[8].ID, -5));

  	booksFixtures[9].userRatings.put(1L, new Rating(1, booksFixtures[9].ID, 3));
  	booksFixtures[9].userRatings.put(2L, new Rating(2, booksFixtures[9].ID, 5));
  	booksFixtures[9].userRatings.put(4L, new Rating(4, booksFixtures[9].ID, 3));
  	booksFixtures[9].userRatings.put(5L, new Rating(5, booksFixtures[9].ID, -5));
  }
  
}