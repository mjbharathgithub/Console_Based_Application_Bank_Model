import java.util.*;
public class Bank {
    HashMap<String, Long> banks= new HashMap<>();
    Bank(String name){
        if(banks.containsKey(name)){
            System.out.println("Bank already Exist!");
        }
        else
        {
            banks.put(name, (long)0);
            System.out.println("Bank added!");
        }
    }

    Bank(String name, long amount){
        if(!banks.containsKey(name)){
            System.out.println("Bank doesn't Exist");
        }
        else{
            banks.put(name, banks.get(name)+amount);
        }
    }
}
