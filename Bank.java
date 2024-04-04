import java.util.*;
public class Bank {
    String bankName;
    long amount;
    HashMap<String, Customer> customers = new HashMap<>();

    Bank(String bankName, long amount){
        this.bankName=bankName;
        this.amount=amount;
        System.out.println("Bank craeted!");
    }

    void addCustomer(String ac_number, String name, long amount){
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

    boolean validate(String ac_number, int pin){
        if(customers.containsKey(ac_number)){
            return customers.get(ac_number).validate(pin);
        }   
        else{
            return false;
        }  
    }
}
