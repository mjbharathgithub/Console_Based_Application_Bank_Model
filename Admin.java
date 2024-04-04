import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    
    HashMap<String,Bank> banks=new HashMap<>();
    
    void createBank(String BankName,Long amount){
        if(!banks.containsKey(BankName)){
            banks.put(BankName,new Bank(BankName,amount));
        }else{
            System.out.println("Bank Already Exists!");
        }
    }

    HashMap<String,Bank> getBanks(){
        return banks;
    }

    void addCustomer(String AccountNumber,String HoldersName,Long amt,String BankName){
        banks.get(BankName).addCustomer(AccountNumber,HoldersName,amt);
    }


  
}
