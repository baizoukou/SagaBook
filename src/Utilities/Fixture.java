package Utilities;

import Model.Books;
import Model.Rating;
import Model.Users;

public class Fixture {



  public static Users[] users =
  {
    new Users (1L, "marge", "simpson", 12,  'm' , "P"),
    new Users (2L, "lisa",  "simpson", 5,   'f', "i"),
    new Users (3L, "bart",  "simpson", 9,   'f', "o"),
    new Users (4L, "maggie","simpson", 47, 'm', "r")
  };

  public static Books[] books =
  {
    new Books (1L, "walk",  "fridge", "hjxzghjgd"),
    new Books (2L, "walk",  "bar",    "hjxzghjgd"),
    new Books (3L, "run",   "work",   "hjxzghjgd"),
    new Books (4L, "walk",  "shop",   "hjxzghjgd"),
    new Books (5L, "cycle", "school", "hjxzghjgd")
  };

  public static Rating[]ratings =
  {
    new Rating(1L, 2L, 1),
    new Rating(1L, 2L, 1),  
    new Rating(1L, 2L, 13),
    new Rating(1L, 2L, 1)       
  };
}