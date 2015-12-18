package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

import org.apache.poi.ss.formula.functions.FinanceLib;

/**
 * @author Mandy
 * 
 * This class accesses a Rate from the database.
 * 
 * Rates are accessed from the array list and returned
 * based on the category of the credit score given.
 *
 */
public class RateDAL {


		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		
		//FinalExam - obviously change the return value
	
		
	public static ArrayList<RateDomainModel> getRates() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>();
		
		try {
			tx = session.beginTransaction();	
			
			List ratelist = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = ratelist.iterator(); iterator.hasNext();) {
				RateDomainModel rate = (RateDomainModel) iterator.next();
				rates.add(rate);

			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rates;
	}	
	
	
	public static double getRate(int CreditScore) {
		ArrayList<RateDomainModel> rates = getRates();
		double roundedScore = 0;
		double rateGet = 0;
		
		for (int i = 600; i <= 750; i+=50){
			if((CreditScore >= i)&(CreditScore<i+50)){
				roundedScore = i;
			}
		}
		if (CreditScore >= 800){
			roundedScore = 800;
		}
		
		for (RateDomainModel i: rates) {
			if(roundedScore == i.getMinCreditScore()) {
				rateGet = i.getInterestRate();
			}
		}
		
		return rateGet;
	}

}