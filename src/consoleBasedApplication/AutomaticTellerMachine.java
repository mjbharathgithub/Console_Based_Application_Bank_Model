package consoleBasedApplication;

import java.util.Scanner;

import javax.swing.plaf.TextUI;

public class AutomaticTellerMachine {
	
	public static boolean isValid(String acc_no,int user_password) {
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter BANK NAME : ");
		String bank_name=scanner.next();
		System.out.println("Enter ACCOUNT NUMBER : ");
		String acc_no=scanner.next();
		System.out.println("Enter PASSWORD : ");
		int user_password=scanner.nextInt();
		if(isValid(acc_no, user_password)) {
			System.out.println("Select \n1.WITHDRAW\\n2.DEPOSIT\\n3.BALANCE ENQUIRY\\n4.PINCHANGE\\n5.PINGENERATE\\n6.TRANSEFER\\n7.MINISTATEMENT");
			int option=scanner.nextInt();
			switch (option) {
		    case 1:
		        System.out.println("WITHDRAW");
		        break;
		    case 2:
		        System.out.println("DEPOSIT");
		        break;
		    case 3:
		        System.out.println("BALANCE ENQUIRY");
		        break;
		    case 4:
		        System.out.println("PINCHANGE");
		        break;
		    case 5:
		        System.out.println("PINGENERATE");
		        break;
		    case 6:
		        System.out.println("TRANSEFER");
		        break;
		    case 7:
		        System.out.println("MINISTATEMENT");
		        break;
		    default:
		        System.out.println("DEFAULT");
		}

			
		}
		

	}

}
