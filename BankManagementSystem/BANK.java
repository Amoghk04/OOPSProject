import java.io.*;
import java.util.Scanner;
class Account{ /*Use of private access modifiers to implement Encapsulation [provide data security] */
    private int AccNo;
    private String Password;
    private String Name;
    public double Balance;
    Account(String Name, String Password, int AccNo, double Balance){
        this.Name=Name;
        this.Password=Password;
        this.AccNo=AccNo;
        this.Balance=Balance;
    }
    public int getAccNo(){
        return AccNo;
    }
    public String getName(){
        return Name;
    }
    public String getPassword(){
        return Password;
    }
    public double getBalance(){
        return Balance;
    }
    public void depositAmount(double x){
        Balance+=x;
        System.out.println("Transaction successful, Your account was credited by $"+x+".\nCurrent Balance : $"+Balance);
    }
    public void withdrawAmount(double x){
        if(x<=Balance){
            Balance-=x;
            System.out.println("Transaction successful, Your account was debited by $"+x+".\nCurrent Balance : $"+Balance);
        }
        else
            System.out.println("You have insufficient funds.");
    }
    @Override
    public String toString(){
        return "Account Number\t:\t"+AccNo+"\nAccount Holder\t:\t"+Name+"\nBalance\t:\t$"+Balance+"\nPassword\t:\t"+Password;
    }
}
class FixedDeposit extends Account{ /*Use of Inheritance */
    private double Interest;Scanner in = new Scanner(System.in);
    public FixedDeposit(String Name, String Password, int AccNo, double Balance,double Interest){
        super(Name,Password,AccNo,Balance);
        this.Interest=Interest;
    }
    public double getInterest(){
        return Interest;
    }
    public void FlexiFixedDeposit(){
        System.out.print("Enter the number or years you'd wish to invest for : ");int years=in.nextInt();
        double Increment = (Balance * Interest*years)/12.0;
        System.out.println("The Fixed Deposit plan will increment your account by $"+Math.ceil(Increment)+" in "+years+" year's time.\nPost-increment balance would tally out to : $"+Math.ceil(getBalance()+Increment));
    }
    @Override
    public String toString(){
        return super.toString()+"\nFixed Deposit's Interest Rate\t:\t"+Interest+"%.";
    }
}
public class bank{
    public static int accno=1;
    public static Scanner in = new Scanner(System.in);
    public static void main(String args[])throws IOException{
        FixedDeposit arr[]= new FixedDeposit[11];
        int c=0;String p;
        int no=0;
        do{
            System.out.println("\t      Welcome to RIT-MiniBank!\t\t");
            System.out.println("\t\t  --Options Menu--\t\t");
            System.out.println("   1. Create an account.");
            System.out.println("   2. Deposit into account.");
            System.out.println("   3. Withdraw from account.");
            System.out.println("   4. Estimate your Fixed Deposit's growth.");
            System.out.println("   5. Checking Account.");
            System.out.println("   6. Checking Master[All Accounts].");
            System.out.println("   7. Exit.");
            System.out.print("   Enter your choice : ");c=in.nextInt();
            System.out.println("----------------------------------------------------------");
            switch(c){
                case 1 :
                    createAccount(arr);
                    System.out.println("----------------------------------------------------------");
                    break;
                case 2 :
                    System.out.println("\t   Deposit Transaction Was Requested");
                    System.out.print("Enter your Account Number :");
                    no=in.nextInt();
                    System.out.print("Enter Password : ");
                    p=in.next();
                    if(no<accno && p.equals(arr[no].getPassword()))
                        depositAmount(arr,no); /*Polymorphism */
                    else    
                        System.out.println("\t   Request Denied\n\t   Incorrect credentials.");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 3 :
                    System.out.println("\t   Withdrawl Transaction Was Requested");
                    System.out.print("Enter your Account Number :");
                    no=in.nextInt();
                    System.out.print("Enter Password : ");
                    p=in.next();
                    if(no<accno && p.equals(arr[no].getPassword()))
                        withdrawAmount(arr,no); /*Polymorphism */
                    else    
                        System.out.println("\t\tRequest Denied\n\t\tIncorrect credentials.");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 4 :
                    System.out.print("Enter your Account Number :");
                    no=in.nextInt();
                    System.out.print("Enter Password : ");
                    p=in.next();
                    if(no<accno && p.equals(arr[no].getPassword()))
                        FlexiFixedDeposit(arr,no);
                    else    
                        System.out.println("Wrong credentials.");
                    System.out.println("----------------------------------------------------------");
                    break;
                case 5:
                    System.out.print("Enter your Account Number :");
                    no=in.nextInt();
                    checkAcccount(arr,no);
                    System.out.println("----------------------------------------------------------");
                    break;
                case 6:
                    checkMaster(arr);
                    System.out.println("----------------------------------------------------------");
                    break;
                default:
                    System.out.println("\t     Thank you for chosing us!");
            }
        }while(c<7);
    }
    private static void createAccount(FixedDeposit arr[]) throws IOException{
        String n,p;
        double m,r;
        System.out.println("Your account number is : "+accno);
        System.out.print("Enter your Name : ");
        n=in.next();
        System.out.print("Enter your Initial Balance : $");
        m=in.nextDouble();
        System.out.print("Enter the Interest Rate : ");
        r=in.nextDouble();
        System.out.print("Set Password : ");
        p=in.next();
        System.out.println("Your account was successfully created! Welcome to Citibank.");
        arr[accno] = new FixedDeposit(n,p,accno,m,r);
        accno++;
    }
    private static void depositAmount(FixedDeposit arr[], int no)throws IOException{
        double amt;
        System.out.println("Welcome "+arr[no].getName()+"!");
        System.out.print("Enter the Amount you wish to Deposit : $");
        amt=in.nextDouble();
        for(FixedDeposit fd : arr){
            if(fd!=null && fd.getAccNo()==no){
                fd.depositAmount(amt);
                return;
            }
        }
        System.out.println("There aren't any Accounts associated with this Account Number.");
    }
    private static void withdrawAmount(FixedDeposit arr[], int no)throws IOException{
        double amt;
        System.out.println("Welcome "+arr[no].getName()+"!");
        System.out.print("Enter the Amount you wish to Withdraw : $");
        amt=in.nextDouble();
        for(FixedDeposit fd : arr){
            if(fd!=null && fd.getAccNo()==no){
                fd.withdrawAmount(amt);
                return;
            }
        }
        System.out.println("There aren't any Accounts associated with this Account Number.");
    }
    private static void FlexiFixedDeposit(FixedDeposit arr[], int no)throws IOException{
        for(FixedDeposit fd : arr){
            if(fd!=null && fd.getAccNo()==no){
                fd.FlexiFixedDeposit();
                return;
            }
        }
        System.out.println("There aren't any Accounts associated with this Account Number.");
    }
    private static void checkAcccount(FixedDeposit arr[], int no)throws IOException{
        for(FixedDeposit fd : arr){
            if(fd!=null && fd.getAccNo()==no){
                System.out.println(fd);
                return;
            }
        }
        System.out.println("There aren't any Accounts associated with this Account Number.");
    }
    private static void checkMaster(FixedDeposit arr[])throws IOException{
        System.out.println("Account No.\tName\t\tBalance\t\tPassword");
        for(FixedDeposit fd : arr){
            if(fd==null)
              continue;
            System.out.println(fd.getAccNo()+"\t\t"+fd.getName()+"\t\t"+fd.getBalance()+"\t\t"+fd.getPassword());
        }
    }
}
   
