import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    	private User user;
	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setUserName("xiaohong");
		user.setPwd("12345");
	}

	@Test
	public void test() {

		String name=user.getUserName();
		assertEquals("xiaohong", name);
		
		String pwd2=user.getPwd();
		assertEquals("12345", pwd2);
		
	}

}
