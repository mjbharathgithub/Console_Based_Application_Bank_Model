import java.util.*;

public class Bank {
    String bankName; //name of the bank
    long amount; // balance amount in the bank
    HashMap<String, Customer> customers = new HashMap<>();//customer details of the bank with account number as their key

    Bank(String bankName, long amount){ //creates a bank with a name and an initial amount
        this.bankName=bankName;
        this.amount=amount;
        System.out.println("Bank craeted!");
    }
    void delete(){ // deletes the existing customer data
        customers=new HashMap<>();
        System.out.println("Account deleted Successfully");
    }
    void addCustomer(String ac_number, String name, long amount){ // used to add a customer with (0 balance) or (with some initial balance)
        if(customers.containsKey(ac_number)){
            System.out.println("Customer already exist!");
        }
        else{
            if(amount==0){
                customers.put(ac_number, new Customer(name, 0));
            }
            else{
                customers.put(ac_number, new Customer(name, 0, amount));
            }
            System.out.println("Customer created!");
        }
    }
    void deleteCustomer(String ac_number){ // deletes the customer data(object) from the map
        if(customers.containsKey(ac_number)){
            customers.remove(ac_number);
            System.out.println("Customer deleted!");
        }
        else{
            System.out.println("Customer doesn't exist!");
        }
    }
    
    boolean validate(String ac_number, int pin){ // checks whether a customer with the given account number!
        if(customers.containsKey(ac_number)){
            return customers.get(ac_number).validate(pin);
        }   
        else{
            return false;
        }  
    }
}
        
