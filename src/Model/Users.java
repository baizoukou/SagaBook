/**
 * @author Alexandre
 */
package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

/**
 * class User defines a user of the book matcher system
 *
 */
public class Users
{
	public String firstName, lastName, occupation, username;
	public int age;
	public long userId; //User id 
	public char gender;
	
	//Map of movie's and their rating. Using movie`id
	public Map<Long, Rating> ratedBooks = new HashMap<>();
	
	public Users( Long ID, String firstName, String LastName,  
							int age, char gender, String occupation)
	{
		this.userId = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		
	}

	

	/**
	 * Add this users particular rating of a book 
	 * @param bookId
	 * @param rating
	 */
	public void addRatedMovies(Long bookId, Rating rating)
	{
		ratedBooks.put(bookId, rating);
	}
	
  public String toString()
  {
    return toStringHelper(this).addValue(userId)
    		                   	.addValue(firstName)
                               .addValue(lastName)
                               .addValue(age)
                               .addValue(gender)
                               .addValue(occupation)
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.userId, this.firstName, this.lastName, this.age, this.gender,
    		 											this.occupation);  
  }  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Users)
    {
      final Users other = (Users) obj;
      return Objects.equal(userId, other.userId) 
          && Objects.equal(firstName,  other.firstName)
          && Objects.equal(lastName,  other.lastName)
          && Objects.equal(age,  other.age)
          && Objects.equal(gender,  other.gender)
          && Objects.equal(occupation,  other.occupation)
          && Objects.equal(ratedBooks,  other.ratedBooks);
    }
    else
    {
      return false;
    }
  }
}
