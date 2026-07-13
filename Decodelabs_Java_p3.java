import java.util.Scanner;
import java.util.InputMismatchException;
class Atm{
    BankAccount bobj = new BankAccount();
    Scanner sc = new Scanner(System.in);
    int e;
    public void menu(){
        do{
        System.out.println("ATM MENU");
        System.out.println("-----------------");
        System.out.println("1. Deposite");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. exit");
        System.out.print("enter your choice:");
        try{
        int n=sc.nextInt();
        System.out.println();
        e=n;
        switch (n){
            case 1: System.out.print("enter deposite amount:");
                    int depo = sc.nextInt();
                    System.out.println("............");
                    bobj.deposit(depo);
                    break;
            case 2: System.out.print("enter withdraw amount:");
                    int wda = sc.nextInt();
                    System.out.println("............");
                    bobj.withdraw(wda);
                    break;
            case 3: bobj.checkbalance();
                    break;
            case 4: System.out.println("thank you for using our ATM.");
                    System.out.println("please remove your card.");
                    break;
            default : System.out.println("invalid input");
                    break;
        }
    } catch (InputMismatchException ex){
        System.out.println("invalid input ! please enter numbers only");
        sc.next();
    }
            }while(e!=4);
        }
    }
class BankAccount{
   private int balance=0;
    public void deposit(int deposite){
        if(deposite <= 0 ){
            System.out.println("Invalid amount");
        }
        else{
        balance = balance + deposite;
        System.out.println(deposite +" deposite successfully ");
        System.out.println("----------------------------");
        System.out.println("current Balance "+ balance);
        System.out.println();
        }
    }
    public void withdraw(int balance){
        if (balance <=0){
            System.out.println("invalid amount");
        }
        else if(balance > this.balance){
            System.out.println("insufficient balance");
        }
        else{
            this.balance=this.balance-balance;
            System.out.println("successfully " + balance + " amount withdraw");
            System.out.println("-------------------------");
            
            
        }
        System.out.println("current balance :" + this.balance );
        System.out.println();
        
    }
    public void checkbalance(){
        System.out.println("--------------------------------");
        System.out.println(" your current balance is " + balance);
        System.out.println("--------------------------------");
        System.out.println();
    }

}
public class Decodelabs_Java_p3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Atm atm = new Atm();
        int card=0;
        System.out.println("welcome our ATM insert your card if inserted press 1 ");
        try{
        card = input.nextInt();
        System.out.println();
        }catch(InputMismatchException ex){
            System.out.println("invalid input !");
        }
        if(card == 1){
            atm.menu();
        }
        else {
            System.out.println("re insert your card.");
        }
        
          input.close();
        
    }
}
