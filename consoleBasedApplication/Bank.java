package consoleBasedApplication;
import java.util.*;

public class Bank  {
    String bankName; //name of the bank
    long amount; // balance amount in the bank
    public HashMap<String, Customer> customers = new HashMap<>();//customer details of the bank with account number as their key
    
    public HashMap<String, Customer> getCustomer(){
    	return customers;
    }
    public Bank(String bankName, long amount){ //creates a bank with a name and an initial amount
        this.bankName=bankName;
        this.amount=amount;
        System.out.println("BANK CREATED!");
    }
    public void delete(){ // deletes the existing customer data
        customers=new HashMap<>();
        System.out.println("ACCOUNT DELETED SUCCESSFULLY!");
    }
    public void addCustomer(String ac_number, String name, long amount){ // used to add a customer with (0 balance) or (with some initial balance)
        if(customers.containsKey(ac_number)){
            System.out.println("CUSTOMER ALREADY EXIST!");
        }
        else{
            if(amount==0){
                customers.put(ac_number, new Customer(name, 0));
            }
            else{
                customers.put(ac_number, new Customer(name, 0, amount));
            }
            System.out.println("CUSTOMER CREATED!");
        }
    }
    public void deleteCustomer(String ac_number){ // deletes the customer data(object) from the map
        if(customers.containsKey(ac_number)){
            customers.remove(ac_number);
            System.out.println("CUSTOMER DELETED!");
        }
        else{
            System.out.println("CUSTOMER DOESN'T EXIST!");
        }
    }
    

	public boolean validate(String acc_no, int user_password) {
		// TODO Auto-generated method stub
		if(customers.containsKey(acc_no)){
            return customers.get(acc_no).validate(user_password);
        }   
        else{
            return false;
        }
	}
	
}
        
