import static org.junit.Assert.*;

import org.junit.Test;


public class RegisterServiceTest {
	RegisterService test = new RegisterService();
	User aaa = new User("aaa");//create a manager user with name "aaa"
	@Test
	public void testRegister() {
		test.register(aaa);
		assertEquals(0, test.getValid());
	}

}
