package IBS;

import java.util.*;
import java.time.*;
public abstract class Bank implements RBI {
	String bankName;
	List<Customer> customers = new ArrayList<>();
	int establishedYear;
	
	public Bank(String bankName, int establishedYear) {
		this.bankName = bankName;
		this.establishedYear = establishedYear;
	}
	
	public boolean isEligible() {
		int currentYear = Year.now().getValue();
		
		return ((currentYear - establishedYear) >= 20 ? true : false);
	}
	
	Customer findCustomer(String accNo) {
		for(Customer c : customers) {
			if(c.getAccNo().equals(accNo)) {
				return c;
			}
		}
		return null;
	}
}
