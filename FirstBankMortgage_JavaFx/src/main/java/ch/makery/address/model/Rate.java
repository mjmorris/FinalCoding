package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import ch.makery.address.view.MortgageController;
import domain.RateDomainModel;

/**
 * 
 * @author Mandy
 * 
 * This method returns the PMT based on the interest
 * rate, present value (what you're going to borrow), future
 * value (which is 0 in this case), compounding, and number of
 * payments.
 * 
 * The present value is determined based on the interest rate,
 * number of payments, amount per individual payment, future value,
 * and compounding. This value is used to determine the PMT.
 *
 */

public class Rate extends RateDomainModel {
	
	public double getPayment(int NumberOfPayments)
	{
		
		//FinalExam
		//	Normally this kind of method would be in a BLL, but alas...
		
		//	Figure out payment based on:
		//	Interest rate
		//	PV
		//	FV (make FV = 0, unless you want a balloon payment
		//	Compounding = True
		//	Number of Payments (passed in)
		
		// PV is what you're going to borrow, FV is 0
		
		double InterestRate = (RateDAL.getRate(MortgageController.CreditScore))/12;
		double FutureValue = 0;
		double Payment = MortgageController.HouseCost / NumberOfPayments;
		boolean Compounding = true;
		
		double PresentValue = FinanceLib.pv(InterestRate, NumberOfPayments, Payment, FutureValue, Compounding);
		double PMT = FinanceLib.pmt(InterestRate, NumberOfPayments, PresentValue, FutureValue, Compounding);
		
		//if (PMT <= (MortgageController.Income * .36) & (PMT <= (MortgageController.Income + MortgageController.Expenses)*.28)) {
			
			return PMT;
		//}
		//else System.err.println("HouseCostTooHigh");
	}
}
