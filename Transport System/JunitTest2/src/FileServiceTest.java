import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class FileServiceTest {
	
	private static FileService fileService = new FileService();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRoute() throws IOException {
		fileService.routeFile();
		assertEquals(4,fileService.routeFile().size());
		
	}
	
	public void testJounery() throws IOException {
		fileService.routeFile();
		assertEquals(5,fileService.jouneryFile().size());
		
	}
	public void testTrain() throws IOException {
		fileService.routeFile();
		assertEquals(10,fileService.trainFile().size());
		
	}
	
	public void testDriver() throws IOException {
		fileService.routeFile();
		assertEquals(8,fileService.driverFile().size());
		
	}
}
