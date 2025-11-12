package IBS;

public class Customer {
	String custName;
	String custPhone;
	String bankName;
	String accountNumber;
	double balance;
	
	public Customer() {}
	
	public Customer(String custName, String custPhone) {
		this.custName = custName;
		this.custPhone = custPhone;
	}
	
	public String getName() {
		return custName;
	}
	
	public void setName(String custName) {
		this.custName = custName;
	}
	
	public String getPhone() {
		return custPhone;
	}
	
	public void setPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getAccNo() {
		return accountNumber;
	}
	
	public void setAccNo(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	void displayCustomerInfo() {
		System.out.println("-------------------------------------");
		System.out.println("Customer name : " + custName);
		System.out.println("Customer phone no. : " + custPhone);
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Bank Name : " + bankName);
		System.out.println("Current balance : " + balance);
		
		System.out.println("-------------------------------------");
	}
	
}
