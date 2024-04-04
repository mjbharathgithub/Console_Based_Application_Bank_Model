package consoleBasedApplication;

import java.util.*;

public class AutomaticTellerMachine {

	public static void main(String[] args) {
		System.out.println("WELCOME \uD83D\uDE4F TO SAAB PRODUCTIONS");

		Admin admin =new Admin(); // creating a global admin object
		
		while(true) {
		
		
		Scanner scanner=new Scanner(System.in); // global scanner variable
		System.out.println("ENTER IDENTITY:\n1.USER\n2.ADMIN\n");
		int type=scanner.nextInt();
		inner:while(true) {
		if(type==1) // means user
		{
			System.out.print("ENTER BANK NAME : ");
			String bank_name=scanner.next();
			if(!admin.getBanks().containsKey(bank_name)){ // checks whether bank exists??
				System.out.println("BANK DOESN'T EXIST!");
			}
			else
			{
				System.out.print("Enter ACCOUNT NUMBER : ");
				String acc_no=scanner.next();
				System.out.print("ENTER PASSWORD : ");
				int user_password=scanner.nextInt();
				Bank b = admin.getBanks().get(bank_name);
				if(b.validate(acc_no, user_password)) { // checks for ac_nunmber and password
					Customer c = b.getCustomer().get(acc_no);
					System.out.println("SELECT \n1.WITHDRAW\n2.DEPOSIT\n3.BALANCE ENQUIRY\n4.CHANGE PIN\n5.MINI STATEMENT\n6.CANCEL\n");
					int option=scanner.nextInt();
					switch (option) 
					{
						case 1:
						{
							//withdraw
							System.out.print("ENTER THE AMOUNT : ");
							long amt = scanner.nextLong();
							c.withDraw(amt);
							break;
						}
						case 2:
						{
							//deposit
							System.out.print("ENTER THE AMOUNT : ");
							long amt = scanner.nextLong();
							c.deposit(amt);
							break;
						}
						case 3:
						{
							//balance enquiry
							c.checkBalance();
							break;
						}
						case 4:
						{
							//change pin
							System.out.print("ENTER THE CURRENT PIN : ");
							int pin = scanner.nextInt();
							System.out.print("ENTER THE NEW PIN : ");
							int npin = scanner.nextInt();
							c.pinChange(pin, npin);
							break;
						}
						case 5:
						{
							//mini statement
							c.miniState();
							break;
						}
						case 6:{
							System.out.println("TRANSACTION CANCELLED!");
							break inner;
						}
						default:{
							System.out.println("INVALID OPERATION!");
							break;
						}
					}
				}
				else{
					System.out.println("INVALID CREDENTIALS!");
				}
			}
			
		}
		else 
		{
			System.out.println("SELECT \n1.CREATE BANK\n2.DELETE BANK\n3.CREATE CUSTOMER\n4.DELETE CUSTOMER\n5.BANK DETAILS\n6.VIEW CUSTOMER\n7.EXIT\n");
			int choice=scanner.nextInt();
			switch (choice) 
			{
		    case 1: 
				{
					//Create bank
					System.out.print("ENTER THE BANK NAME : ");
					String bankName=scanner.next();
					System.out.print("ENTER THE INITIAL AMOUNT : ");
					Long amount =scanner.nextLong();
		      admin.createBank(bankName,amount);
		      break;
				}
		    case 2 :
				{
					//delete bank
					System.out.print("ENTER THE BANK NAME : ");
					String bankName=scanner.next();
		      admin.deleteBank(bankName);
		      break;
				}
		    case 3:
		    {
					//create customer
					System.out.print("ENTER THE BANK NAME : ");
					String b_name = scanner.next();
					System.out.print("ENTER CUSTOMER NAME : ");
					String c_name = scanner.next();
					System.out.print("ENTER CUSTOMER ACCOUNT NUMBER : ");
					String a_no = scanner.next();
					System.out.print("ENTER THE INITIAL AMOUNT : ");
					long amt = scanner.nextLong();
					admin.addCustomer(a_no, c_name, amt, b_name);
					break;
				}
		    case 4:
		    {
					//delete customer
					System.out.println("ENTER ACCOUNT NUMBER : ");
					String a_no=scanner.next();
					System.out.println("ENTER BANK NAME : ");
					String b_name = scanner.next();
					admin.deleteCustomer(a_no, b_name);
					break;
				}
		    case 5:
				{
					//bank details
					HashMap<String, Bank> b=admin.getBanks();
					for(String i:b.keySet()){
						System.out.println(i+" : "+b.get(i).amount);
					}
					break;
				}
		    case 6:
		    {	
		    	//View custonmer
		    	System.out.print("ENTER BANK NAME : ");
		    	String b_name = scanner.next();
		    	HashMap<String, Customer> b=admin.getBanks().get(b_name).getCustomer();
		    	int count = 1;
				for(String i:b.keySet()){
					System.out.print(count++ +" : ");
					System.out.print("ACCOUNT NUMBER : "+i+"\t");
					System.out.print("NAME : "+b.get(i).userName+"\t");
					System.out.print("BALANCE : "+b.get(i).balance+"\n");
				}
				break;
		    }
				case 7:
				{
					//exit
					break inner;
				}
		    default:
				{
					System.out.println("INVALID OPERATION!");
					break;
				}
			}
		}
		System.out.println("Do You want to continue (Y/N) :");
		String op=scanner.next().toLowerCase();
		if(op.equals("n")) break;
		}
		System.out.println("Do You want to Exit (Y/N) :");
		String ex=scanner.next().toLowerCase();
		if(ex.equals("y")) break;
		}
		System.out.println("THANK YOU FOR VISITING"+"\uD83D\uDE0F");
		System.out.println("copyright@SAAB 2024");
	}
}
