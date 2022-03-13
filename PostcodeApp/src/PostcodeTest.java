import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;



class PostcodeTest {
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test //(timeout=1000)
	void testValidation1() throws IOException {
		//there is no such postcode
		String id="C32 0JG";
		PostcodeParser ps= new PostcodeParser(id);
	    assertEquals(false, ps.ValidatePostcode());
	}
	

	@Test //(timeout=1000)
	void testValidation2() throws IOException {
		String id="M32 0JG";
		PostcodeParser ps= new PostcodeParser(id);
	    assertEquals(true, ps.ValidatePostcode());
	}
	
	@Test
	void testInforamtion() throws IOException {
		String id="CB3 0FA";
		String res=
				"\nPostcode ID: CB3 0FA, Country: England, Region: East of England\r\n"
				+ "*List Of The Nearest Postcodes:* \r\n"
				+ "Postcode ID: CB3 0FA, Country: England, Region: East of England\r\n"
				+ "Postcode ID: CB3 0GT, Country: England, Region: East of England\r\n"
				+ "Postcode ID: CB3 0FT, Country: England, Region: East of England\n";
		PostcodeParser ps= new PostcodeParser(id);
		ps.GetPostcodeJsonData();
		//spaces disturbing the check
	    assertEquals(res.replaceAll("\\s",""), ps.toString().replaceAll("\\s",""));
	}

}

