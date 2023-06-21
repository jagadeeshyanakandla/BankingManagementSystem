package project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class RBI {
public static void main(String[] args) {
	
	System.out.println("Welcome to Banking");
	while(true) {
	System.out.println("Do you want to open an account: 1.Yes 2.No");
	Scanner sc = new Scanner(System.in);
	String choice = sc.nextLine();
	if(choice.equalsIgnoreCase("Yes")) {
		OpenAccount a = new OpenAccount();
		a.createaccount();
	}
	if(choice.equalsIgnoreCase("No")) {
		BankAccount b = new BankAccount();
		b.display();
	}
	
}	
	
}	
}
class OpenAccount{
	
	String Name;
	String Address;
	String Accounttype;
	String Bank;
	int Accountnumber;
	public void createaccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("In which bank you want to open Account : 1.PNB 2.ICICI 3.SBI");
		int choicebank = sc.nextInt();
		if(choicebank == 1) {
			Bank = "PNB";
		}
		 if(choicebank == 2) {
			 Bank = "ICICI";
		 }
		 if(choicebank == 3) {
			 Bank = "SBI";
		 }
		 System.out.println("Enter your Name");
		 sc.nextLine();
		 Name = sc.nextLine();
		 System.out.println("Enter your Address");
		 
		 Address = sc.nextLine();
		System.out.println("What type of Account do yoou want to open: 1.Saving 2.Current");
		int c = sc.nextInt();
		if(c == 1) {
			Accounttype = "Saving";
			
		}
		if(c == 2) {
			Accounttype = "Current";
			
		}
		System.out.println("Your Account has been opened with the following details");
		System.out.println("Bank : " + Bank);
		System.out.println("Name : " + Name);
		System.out.println("Address : " + Address);
		System.out.println("Accounttype : " + Accounttype);
		
		System.out.println("Accountnumber " + Math.random()); 
	}
	
}
class BankAccount {
	int balance;
	int prevoiustransactions;
	String customername;
	int customerid;
	String accounttype;
	double totalinterest;
	
	public void calculateinterest(int balance) {
		System.out.println("what type of account 1.saving 2.current");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		if (c == 1) {
			accounttype = "Saving";
		int r = 5;
	
		System.out.println("enter year to calculate rate of interest");
		  int t = sc.nextInt();
		
		double finalamount = balance * (1 + r * t);
		totalinterest = finalamount - balance;
		System.out.println("Total interest is: " + totalinterest);
		}
		if (c == 2) {
			accounttype = "Current";
			
			int r=8;
			
		 System.out.println("Enter year to calculate rate of interest");
		  int t = sc.nextInt();
		  System.out.println("Enter frequency to  calculate rate of interest");
		  int n = sc.nextInt();
	
		double finalamount = balance * Math.pow(1 + r / n, n * t);
		totalinterest = finalamount - balance;
		System.out.println("Total interst is " + totalinterest);
		
		}

	}
	public void deposit(int amount ) {
		
		if(amount != 0) {
			balance = balance + amount;
			System.out.println("Balance after deposit: " + balance);
			prevoiustransactions = amount;
		}
		
		
	}
	public void withdraw(int amount) {
		

		
		if(amount != 0) {
			balance = balance - amount;
			System.out.println("Balance after withdraw: " + balance);
			prevoiustransactions = - amount;
		}
	}
    public void getprevioustransaction() throws FileNotFoundException {
		
    	FileOutputStream obj = new FileOutputStream("Mytransaction.txt");
    	PrintStream obj1 = new PrintStream(obj);
    	if(prevoiustransactions > 0) {
    		obj1.append( " Deposited " + prevoiustransactions);
    		System.out.println(" Deposited " + prevoiustransactions);
    	}
    	else if(prevoiustransactions < 0) {
    		obj1.append( " Withdraw " + prevoiustransactions);
    		System.out.println(" Withdraw " + prevoiustransactions);
    	}
    	obj1.close();
    	
	}
    void display() {
    char option = '\0';
    Scanner sc = new Scanner(System.in);
    
    System.out.println("choose the option ");
    System.out.println("A.check balance");
    System.out.println("B.Deposit");
    System.out.println("C.withdraw");
    System.out.println("D.previoustransactions");
    System.out.println("E.calculate interest");
    System.out.println("F.exit");
    do {
    	System.out.println("Enter option");
    	option = sc.next().charAt(0);
    	switch(option) {
    	case 'A':
    		System.out.println("Balance is:" + balance);
    		break;
    		
    		case 'B':
    		System.out.println("Enter an amount to deposit");
    		int amount = sc.nextInt();
    		deposit(amount);
    		break;
    		
    		case 'C':
    			System.out.println("Enter an amount to withdraw");
    			int amount1 = sc.nextInt();
    			withdraw(amount1);
    		break;
    		case 'D':
			try {
				getprevioustransaction();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
    		case 'E':
    			calculateinterest(balance);
    		break;
    		default:
    			System.out.println("Enter proper option");
    			
    	}
    	
    }
    while(option != 'F');
    System.out.println("Thank you for banking");
    
    }
}

	
