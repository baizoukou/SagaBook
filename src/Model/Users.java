package Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("unused")
public class Users {
	
	private static long counter = 0;
	public final long id;
	public String firstname;
	public String lastname;
	public int age;
	public String gender;
	public String occupation;
	public int rating;

	public List<Rating> ratings = new ArrayList<>();

	public Users(String firstname, String lastname,int age, String gender,  String occupation, int rating) {
		this.id = ++counter;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		
	}
@Override 	
public String toString(){
	  return toStringHelper(this).addValue(id)
              .addValue(firstname)
              .addValue(lastname)
              .addValue(age)
              .addValue(gender) 
              .addValue(occupation)
              .toString();
}



	private Object toStringHelper(Users users2) {
	// TODO Auto-generated method stub
	return null;
}



	public static HashMap<Long, Users> users = new HashMap<Long, Users>();


	@Override
	public int hashCode() {
		return java.util.Objects.hashCode(this.lastname, this.firstname,this.age, this.gender,this.occupation, this.rating);
	}
	

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Users)
		{
			final Users other = (Users) obj;
			return java.util.Objects.equals(firstname, other.firstname)
					&& Objects.equals(lastname, other.lastname)
					&& Objects.equals(gender, other.gender)
					&& Objects.equals(age, other.age)
					&& Objects.equals(occupation, other.occupation)
					&& Objects.equals(ratings, other.ratings);
		}
		else
		{
			return false;}
	}
}