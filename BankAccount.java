import java.util.*;



public class BankAccount {
    private int AccountNumber;
    private String name; 
    private int balance;


    BankAccount(int acc_num, String name, int balance){
        AccountNumber=acc_num;
        this.name=name;
        this.balance=balance;
    }
    public int getNum(){
        return AccountNumber;
    }
    public String getName(){
        return name;
    }
    public int getBalance(){
        return balance;
    }
    public void BalanceAddition(int amt){
        this.balance+=amt;
    }
    public void WithdrawAmount(int amt){
        this.balance-=amt;
    }

    public String toString(){
        return "\n" + "ACCOUNT NUMBER: " + AccountNumber + "\n" +
               "NAME: " + name + "\n" +
               "BALANCE: " + balance;

    }

    
}

class History{
    private int transfeered_account;
    private int received_account;
    private int amount_transferred;

    History(int acc, int acc1, int amt){
        transfeered_account=acc;
        received_account=acc1;
        amount_transferred=amt;
    }
    public String toString(){
        return "AMOUNT TRANSFERRED FROM: " + transfeered_account + "\n" +
               "AMOUNT RECEIVED BY     :"  + received_account + "\n" +
               "AMOUNT TRANSFERRED     : " + amount_transferred;
    }



}






class Menu21{
    static HashMap<Integer, BankAccount> h1 = new HashMap<>();
    static ArrayList<History> a1 = new ArrayList<>();
    
    static{
        h1.put(101, new BankAccount(101, "SABIN", 1000));
        h1.put(102, new BankAccount(102, "RITA", 10000));
        h1.put(103, new BankAccount(103, "SABIN", 5000));
        
    }




    public void DepositMoney(Scanner sc){
        System.out.println("ENTER THE ACCOUNT NUMBER:");

        
        int account_num= Validate.intValidate(sc);
        
        while(!h1.containsKey(account_num)){
    
            System.out.println("NO SUCH ACCOUNT EXISTS: TRY AGAIN");
            account_num=Validate.intValidate(sc);
            
            

        }
        
        
    
        if(h1.containsKey(account_num)){
            System.out.println("ACCOUNT FOUND: DIPLAYING INFORMATION");
            System.out.println(h1.get(account_num));
            BankAccount b1 = h1.get(account_num);
            System.out.println("ENTER THE AMOUNT THAT YOU WANT TO DEPOSIT: MUST BE GREATER THAN NRS 100");
            int deposit_amt = Validate.intValidate(sc);
            
            while (deposit_amt<=100) {
                
                System.out.println("THE DEPOSIT AMOUNT CANNOT BE LESS THAN 100");
                deposit_amt=Validate.intValidate(sc);

                
            }
            if (deposit_amt>100) {
                
                b1.BalanceAddition(deposit_amt);
                System.out.println("DEPOSIT SUCCESFUL");

                
                
            }
            


       }
        
    }

    

    public void WithdrawMoney(Scanner sc){
        System.out.println("ENTER THE ACCOUNT NUMBER:");

        
        int account_num= Validate.intValidate(sc);
        
        while(!h1.containsKey(account_num)){
    
            System.out.println("NO SUCH ACCOUNT EXISTS: TRY AGAIN");
            account_num=Validate.intValidate(sc);
            
            

        }
        
        
    
        if(h1.containsKey(account_num)){
            System.out.println("ACCOUNT FOUND: DIPLAYING INFORMATION");
            System.out.println(h1.get(account_num));
            BankAccount b1 = h1.get(account_num);
            System.out.println("ENTER THE AMOUNT THAT YOU WANT TO WITHDRAW: MUST BE GREATER THAN NRS 100");
            int withdraw_amt = Validate.intValidate(sc);
            
            while (withdraw_amt<=100 || withdraw_amt>b1.getBalance()) {
                
                System.out.println("THE DEPOSIT AMOUNT CANNOT BE LESS THAN 100 or MORE THAN THE BALANCE");
                withdraw_amt=Validate.intValidate(sc);

                
            }
            if (withdraw_amt>100) {
                
                b1.WithdrawAmount(withdraw_amt);
                System.out.println("WITHDRAW SUCCESFUL");

                
                
            }
            


       }

        
    }
    public  void TransferMoney(Scanner sc){
        System.out.println("ENTER THE ACCOUNT NUMBER THAT YOU WANT TO TRANSFER FROM:");

        
        int account_num= Validate.intValidate(sc);
        
        while(!h1.containsKey(account_num)){
    
            System.out.println("NO SUCH ACCOUNT EXISTS: TRY AGAIN");
            account_num=Validate.intValidate(sc);
            
            

        }
        
        
    
        if(h1.containsKey(account_num)){
            System.out.println("ACCOUNT FOUND:");
            BankAccount b3 = h1.get(account_num);
            System.out.println(b3);
            System.out.println("ENTER THE ACCOUNT NUMBER THAT YOU WANT TO TRANSTER TO ");
            int account_num2 = Validate.intValidate(sc);
            while(!h1.containsKey(account_num2) || account_num==account_num2){
    
            System.out.println("INVALID ACCOUNT: TRY AGAIN");
            account_num2=Validate.intValidate(sc);

        }
           if(h1.containsKey(account_num2)){
            BankAccount b4 = h1.get(account_num2);
            System.out.println("ACCOUNT FOUNDl:");
            System.out.println("ENTER THE AMOUNT THAT YOU WANT TO TRANSFER:");
            int transferAmount = Validate.intValidate(sc);
            
            while ((transferAmount>b3.getBalance() || transferAmount<100)) {
                
                System.out.println("INVALID TRANSFER AMOUNT: CHECK THE FOLLOWING" + "\n" + 
                                   " 1. TRANSFER AMOUNT CANNOT EXCEED THE BALANCE." + "\n" + 
                                   " 2. TRANSFER AMOUNT IS LESS THAN NRS 100"
                );
                transferAmount=Validate.intValidate(sc);
                
                
            }
            b3.WithdrawAmount(transferAmount);
            b4.BalanceAddition(transferAmount);
            System.out.println("TRANSFER SUCCESS");
            a1.add(new History(account_num, account_num2, transferAmount));

          




           }

            


       }
        
    }
    public void TransactionHistory(Scanner sc){
        System.out.println("DISPLAYING THE TRANSFER HISTORY:");
        if(a1.isEmpty()==true){
                System.out.println("NO TRANSFER HAS OCCURED YET");
                
            }
            else{
        for(History history1 : a1){
           
            System.out.println(history1);

        }

        }
    }
        
        
    
    
    
    
    public void display(){
      for(BankAccount b1 : h1.values()){
        System.out.println(b1);
      }
    }

}





class Validate{
    public static int intValidate(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println("ENTER AN INTEGER ONLY:");
            sc.next();
        }
        return sc.nextInt();
    }
}



class Bank{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu21 m1 = new Menu21();
        int choice;
        do{
             System.out.println("\n" + "WHAT DO YOU WANT TO DO?" + "\n" +
                                "1. DEPOSIT MONEY" + "\n" +
                                "2. WITHDRAW MONEY" + "\n" +
                                "3. TRANSFER MONEY" + "\n" +
                                "4. TRANSACTION HISTORY" + "\n" +
                                "5. DISPLAY THE DATABASE" + "\n" +
                                "6. EXIT"
            
        
         
        );
        choice = Validate.intValidate(sc);
        

        switch (choice) {
            
            case 1:
                m1.DepositMoney(sc);
                
                break;
            case 2:
                m1.WithdrawMoney(sc);
                break;

            case 3:
                m1.TransferMoney(sc);
                break;

            case 4:
                m1.TransactionHistory(sc);
                break;

            case 5: 
                m1.display();
                break;
             
        }
        
    
    
    
    }
        while(choice!=6);
        
    }

   
} 