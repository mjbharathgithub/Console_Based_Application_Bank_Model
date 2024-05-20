package consoleBasedApplication;
import java.util.*;
class Customer {
    String userName = "";
    int pin = 0;
    long balance =0;
    ArrayList<String> miniStateMent = new ArrayList<>();
    public Customer(String name,int pin){
        userName = name;
        this.pin = pin;
    }
    public Customer(String name,int pin,long amt){
        userName = name;
        this.pin = pin;
        balance = amt;
    }
    public void checkBalance(){
        System.out.println("YOUR CURRENT BALANCE : "+balance);
        miniStateMent.add("Balance enquiry");
    }
    public void deposit(long amt){
        balance+=amt;
        System.out.println("AMOUNT DEPOSITED SUCCESSFULLY!");
        miniStateMent.add("Amount deposited :"+amt+" Balance : "+balance);
    }
    public void withDraw(long amt){
        if(amt<=(balance-1000)){
            balance-=amt;
            System.out.println("COLLECT YOU AMOUNT : "+amt);
            miniStateMent.add("Amount withdrawal :"+amt+" Balance : "+balance);
        }
        else{
            System.out.println("INSUFFICIENT BALANCE!");
        }
    }
    public void pinChange(int oldPin,int newPin){
        if(oldPin == pin){
            if(newPin == pin) {
            System.out.println("NEW PIN SHOULD NOT MATCH WITH THE EXISTING ONE!");
            System.out.println("ATTEMPT FAILED TO CHANGE PIN!");
            miniStateMent.add("Attempt failed to change pin");}
            else {
                pin = newPin;
                System.out.println("PIN CHANGED SUCCESSFULLY!");
                miniStateMent.add("Pin changed Successfully");
            }
        }
    }
    public boolean validate(int npin){
        if(npin == pin) return true;
        else return false;
    }
    public void miniState(){
        int count =0;
        for(String s:miniStateMent){
            System.out.println(++count+" "+s);
        }
    }


}
