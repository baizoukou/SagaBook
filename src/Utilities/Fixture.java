package Utilities;

import Model.Books;
import Model.Rating;
import Model.Users;

public class Fixture {



  public static Users[] users =
  {
    new Users ("marge", "simpson", 12,  "m" , "P", 0),
    new Users ("lisa",  "simpson", 5,   "f", "i", 0),
    new Users ("bart",  "simpson", 9,   "m", "o", 0),
    new Users ("maggie","simpson", 47, "f", "r", 0)
  };

  public static Books[] books =
  {
    new Books ("walk",  "fridge", "hjxzghjgd"),
    new Books ("walk",  "bar",    "hjxzghjgd"),
    new Books ("run",   "work",   "hjxzghjgd"),
    new Books ("walk",  "shop",   "hjxzghjgd"),
    new Books ("cycle", "school", "hjxzghjgd")
  };

  public static Rating[]ratings =
  {
    new Rating(1L, 2L, 1),
    new Rating(1L, 2L, 1),  
    new Rating(1L, 2L, 13),
    new Rating(1L, 2L, 1)       
  };
}