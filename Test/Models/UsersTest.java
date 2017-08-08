/**
 * @author alexandre
 */
package Models;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Users;


public class UsersTest
{

	/**
	 * Test to verify is a user can be created
	 * @throws Exception
	 */
	@Test
	public void testCreateUser() throws Exception
	{
		Users user = new Users(20L, "Bob", "mark", 50, 'M', "carpenter");
		assertEquals(20, user.userId);
		assertEquals("Bob", user.firstName);
		assertEquals("mark", user.lastName);
		assertEquals(50, user.age);
		assertEquals('M', user.gender);
		assertEquals("carpenter", user.occupation);	
		

}
}