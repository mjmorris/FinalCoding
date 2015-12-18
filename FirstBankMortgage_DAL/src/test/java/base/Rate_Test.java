package base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.RateDomainModel;

/**
 * 
 * @author Mandy
 *
 * This test assures that rates can be accessed from the database.
 *
 */

public class Rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void GetRateTest()
	{
		ArrayList<RateDomainModel> rates = RateDAL.getRates();
		
		assertTrue(rates.size() > 0);
		
	}

}
