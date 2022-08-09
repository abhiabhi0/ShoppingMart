package com.programmercave.ShoppingMart;

import java.util.ArrayList;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.programmercave.Model.Customer;
import com.programmercave.Validator.Validator;
import com.programmercave.Exception.ShoppingMartException;
/**
 * Hello world!
 *
 */
public class App 
{
	public static final Log LOGGER = LogFactory.getLog(App.class);
	
    public static void main( String[] args )
    {
    	try
    	{
    		App.calculateBillAmount();
    	}
    	catch (Exception e)
    	{
    		LOGGER.error(e);
    	}
 
    }
    
    static ArrayList<Customer> listOfCustomers = new ArrayList<>();
	static {
		
		Customer customerOne = new Customer("Anny", 1723, "7700992133", "Columbia","Silver",5200);
		Customer customerTwo = new Customer("Mark", 3421, "8780992163", "San Diego","Platinum",8800);
		Customer customerThree = new Customer("Fred",3963, "9711992100", "Kansas","Gold",9000);
		listOfCustomers.add(customerOne);
		listOfCustomers.add(customerTwo);
		listOfCustomers.add(customerThree);
	}
	
	/*
	 * This method is used to give validate customer data.
	 */
	private static Customer ValidateCustomer() throws ConfigurationException {
		Customer customerOne = App.listOfCustomers.get(0);
		String response = new Validator().validate(customerOne);
		LOGGER.info(new Configurations().properties("messages.properties").getProperty(response));
		return customerOne;
	}
	
	/*
	 * This method is used to give calculate bill amount of customer.
	 */
	private static void calculateBillAmount() throws ConfigurationException{
		
		// Silver 5%
		// Gold 7% discount on Amount > 5000
		//Platinum 10% discount on Amount > 5000
		
		Customer customerOne = ValidateCustomer();
		if(customerOne.getCartAmount()<0) {
			LOGGER.info(new Configurations().properties("messages.properties").getProperty("App.INVALID_CART_AMOUNT"));
		}
		
		if(customerOne.getMembership().equals("Silver")) {
			Integer discountInPercent = 5;
			Integer billAmount = customerOne.getCartAmount()*discountInPercent;
			Double FinalAmount = customerOne.getCartAmount() - (billAmount*0.01);
			
			String message = new Configurations().properties("messages.properties").getProperty("App.BILLING_SUCCESS")+":"+FinalAmount;
			System.out.println(message);
			LOGGER.info(message);
		}  
		
		/*			
				Similarly write the logic to calculate bill of Gold and Platinum Memberships
		*/		
	}
}
