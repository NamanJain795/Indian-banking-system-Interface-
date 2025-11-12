package IBS;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class MainApp {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(isr);
		
		while(true) {
			try {
				System.out.println("----------Welcome to Indian Banking System ----------");
				System.out.print("1. ICICI \n2. HDFC \n3. SBI \n4. HSBC \n5. AXIS \n6. EXIT");
				System.out.println("\nSelect bank : ");
				int choice = Integer.parseInt(buff.readLine());
				
				if(choice == 6) {
					System.out.println("Thank you for using INDIAN BANKING SYSTEM");
					break;
				}
				RBI bank = switch(choice) {
				case 1 -> new ICICI();
				case 2 -> new HDFC();
				case 3 -> new SBI();
				case 4 -> new HSBC();
				case 5 -> new AXIS();
				default -> null;
				};
				
				if(bank == null) {
					continue;
				}
				while(true) {
					System.out.print("1. Create Account \n2. Deposit Money \n3. Withdraw Money \n4. Open Fixed Deposit \n5. Apply for Loan \n6. Go back");
					System.out.println("\nSelect Operation : ");
					int op = Integer.parseInt(buff.readLine());
					
					switch(op) {
					case 1 -> bank.createAccount();
					case 2 -> bank.depositAmount();
					case 3 -> bank.withdrawAmount();
					case 4 -> bank.openFD();
					case 5 -> bank.applyLoan();
					case 6 -> {break;}
					default -> System.out.println("Invalid Operation\n");
					}
					if(op == 6) {
						break;
					}
				}
			}catch(IOException e) {
				System.out.println("Error : " + e.getMessage());
			}
		}
	}
}
