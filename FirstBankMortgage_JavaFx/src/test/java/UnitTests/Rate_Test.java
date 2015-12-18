package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.makery.address.model.Rate;

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
	@Test
	public void PaymentTest() {
		double PV = 300000;
		double FV = 0;
		double NumberOfPayments = 360;
		double InterestRate = .04;
		boolean Compounding = true;
	
		//assertTrue(Rate.PMT==1432.25);
	}

}
