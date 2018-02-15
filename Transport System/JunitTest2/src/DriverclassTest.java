import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverclassTest {
	private Driverclass driver;
	@Before
	public void setUp() throws Exception {
	driver = new Driverclass();
	driver.driverName = "D";
	driver.state = "work";
	driver.driverNo = 1;
	driver.setState("idle");
	
	}
	@Test
	public void test() {
		String name = driver.getDriverName();
		assertEquals("D", name);
		
		int no = driver.getDriverNo();
		assertEquals(1, no);
		
		String state = driver.state;
		
		String tostr = driver.toString();
		assertEquals(name +"  "+ state, tostr);
	}

}
