package IBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HSBC extends Bank{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader  buff = new BufferedReader(isr);
	
	public HSBC() {
		super("HSBC", 1865);
	}
	public HSBC(String bankName, int year) {
		super(bankName, year);
	}
	
	public void createAccount() {
		try {
			System.out.println("!!! Create account in : " + bankName + " !!!");
			
			System.out.print("Enter Name : ");
			String Name = buff.readLine();
			
			System.out.print("Enter Phone Number : ");
			String phone = buff.readLine();
			
			System.out.print("Enter initial deposit : ");
			double balance = Double.parseDouble(buff.readLine());
			
			if(balance < 5000) {
				System.out.println("!! Minimum Rs 5000 required !!");
				return;
			}
			 Customer newCustomer = new Customer(Name, phone);
			 newCustomer.setBankName(bankName);
			 
			 String accNo = "HSBC" + (int)(Math.random() * 900000 + 100000);
			 newCustomer.setAccNo(accNo);
			 
			 newCustomer.setBalance(balance);
			 customers.add(newCustomer);
			 
			 System.out.println("!!! Account created Successfully !!!");
			 newCustomer.displayCustomerInfo();
		}catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	public void depositAmount() {
		try {
			System.out.println("!!! Deposit Money in : " + bankName + " !!!");
			System.out.print("Enter bank account : ");
			String accNo = buff.readLine();
			
			Customer c = findCustomer(accNo);
			
			if(c == null) {
				System.out.println("!! Account not found !!");
				return;
			}
			System.out.print("Enter Deposit amount : ");
			double amt = Double.parseDouble(buff.readLine());
			
			if(amt < 0) {
				System.out.println("!! Enter Valid amount !!");
				return;
			}
			c.setBalance(c.getBalance() + amt);
			
			System.out.println("!! Deposit done successfully !!");
			c.displayCustomerInfo();
		}catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	public void withdrawAmount() {
		try {
			System.out.println("!!! Withdraw from : " + bankName + " !!!");
			System.out.print("Enter Account number : ");
			String accNo = buff.readLine();
			
			Customer c = findCustomer(accNo);
			
			if(c == null) {
				System.out.println("!! Account not found !!");
				return;
			}
			
			int failedAttempt = 0;
			while(failedAttempt < 3) {
				System.out.print("Enter withdraw amount : ");
				double amt = Double.parseDouble(buff.readLine());
				
				if(amt < 0) {
					System.out.print("Enter valid amount ");
					return;
				}
				if((c.getBalance() - amt) < 5000) {
					failedAttempt++;
					System.out.println("Minimum balance Rs 5000 required. Attempts : " + failedAttempt +"/3");
					if(failedAttempt == 3) {
						System.out.println("!!! Account blocked !!!");
						return;
					}
				}
				else {
					c.setBalance(c.getBalance() - amt);
					System.out.println("!! Withdraw Successfully done !!");
					c.displayCustomerInfo();
					return;
			}
			}
		}catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	public void openFD() {
		if(!isEligible()) {
			System.out.println(bankName + " is not eligible to offer FD (less than 20 years old)");
			return;
		}
		try {
			System.out.print("Enter account number : ");
			String accNo = buff.readLine();
			
			Customer found = findCustomer(accNo);
			if(found == null) {
				System.out.println("Account not found");
				return;
			}
			
			System.out.print("Enter FD Amount : ");
			double fdAmount = Double.parseDouble(buff.readLine());
			
			System.out.print("Enter FD Duration(In years) : ");
			int years = Integer.parseInt(buff.readLine());
			
			double interest = fdAmount * 0.02 * years;
			double maturity = fdAmount + interest;
			
			System.out.println("FD Created Successfully by : " + bankName);
			
			System.out.println("Principal amount : " + fdAmount);
			System.out.println("Interest : " + interest);
			System.out.println("Maturity amount : " + maturity);
			System.out.println("Duration : " + years + "Years");
			System.out.println("Interest rate is : 2%");
		}catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	public void applyLoan() {
		if(!isEligible()) {
			System.out.println(bankName + " is not eligible to offer loan (less than 20 years old)");
			return;
		}
		try {
			System.out.print("Enter account number : ");
			String accNo = buff.readLine();
			
			Customer found = findCustomer(accNo);
			if(found == null) {
				System.out.println("Account not found");
				return;
			}
			System.out.print("Enter loan amount : ");
			double amount = Double.parseDouble(buff.readLine());
			
			System.out.print("Enter Tenure : ");
			int years = Integer.parseInt(buff.readLine());
			
			double interestRate = 0.10;
			
			double totalInterest = amount * interestRate * years;
			double totalPayable = amount + totalInterest;
			
			System.out.println("Loan Approved by :" + bankName);
			
			System.out.println("Loan amount : " + amount);
			System.out.println("Interest : " + totalInterest);
			System.out.println("Total Payable amount : " + totalPayable);
			System.out.println("Interest rate is : 10%");
			System.out.println("Tenure : " + years + "Years");
		}catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}
