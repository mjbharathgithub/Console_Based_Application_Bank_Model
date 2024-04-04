package consoleBasedApplication;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.ls.LSException;

public class Admin {
    
    public HashMap<String,Bank> banks=new HashMap<>();
    
   public void createBank(String BankName,Long amount){
        if(!banks.containsKey(BankName)){
            banks.put(BankName,new Bank(BankName,amount));
        }else{
            System.out.println("BANK ALREADY EXIST!");
        }
    }

   public void deleteBank(String BankName){
        if(banks.containsKey(BankName)){
            banks.get(BankName).delete();
            banks.remove(BankName);
        }else{
            System.out.println("BANK DOES NOT EXIST!");
        }
    }

   public HashMap<String,Bank> getBanks(){
        return banks;
    }

    public void addCustomer(String AccountNumber,String HoldersName,Long amt,String BankName){
    	if(banks.containsKey(BankName))banks.get(BankName).addCustomer(AccountNumber,HoldersName,amt);
    	else System.out.println("BANK DOES NOT EXIST!");
    }

    public void deleteCustomer(String AccountNumber,String BankName){
        if(banks.containsKey(BankName)){
            banks.get(BankName).deleteCustomer(AccountNumber);
            
        }else{
            System.out.println("BANK DOES NOT EXIST!");
        }
    }


  
}