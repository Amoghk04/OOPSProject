/*This program is meant to create an account in the bank. after the creation
of the account the withdrawals and deposits can be made accordingly. The balance can be checked
kfrom time to time by using the checking master function.*/
/*By
 * Bhavani.A.M
 * Class:- 10 B
 * Roll number:- 8
 */
import java.io.*;           
import java.util.*;
class Account
{
  String Name;
  String Password;
  int AccNo;
  int Money;
  int dd;
  int mm;
  int yy;
  public Account(String n,int an,int d,int m,int y,int mon,String p)
  {
    Name=n;
    AccNo=an;
    dd=d;
    mm=m;
    yy=y;
    Money=mon;
    Password=p;
  }
  public void displayData()
  {
    System.out.println(AccNo+"\t"+Name+"\t\t"+dd+"/"+mm+"/"+yy+"\t"+Money+"\t\t"+Password);
  }
}

public class Bank
 {
  public static Calendar c=Calendar.getInstance();
  public static int date=c.get(Calendar.DATE);
  public static int month=c.get(Calendar.MONTH);
  public static int year=c.get(Calendar.YEAR);
  public static InputStreamReader read=new InputStreamReader(System.in);
  public static BufferedReader in=new BufferedReader(read);
  public static int Ano=1;
  public static Account Acc[]=new Account[100];
  
  public static void main(String[] args) throws IOException
   {
    int ch=1;
    startAccount();
    do
    {
      System.out.println("  Welcome to State Bank   ");
      System.out.println("   --: OPTION MENU :--    ");
      System.out.println("   1. Create Account      ");
      System.out.println("   2. Withdrawl           ");
      System.out.println("   3. Deposit             ");
      System.out.println("   4. Checking Account    ");
      System.out.println("   5. Checking Master     ");
      System.out.println("   6. Close Account     ");
      System.out.println("   7. Exit                ");
      System.out.print(  "Enter Your Choice(1-7) :  ");
      ch=Integer.parseInt(in.readLine());
      switch(ch)
      {
        case 1:
        createAccount();
        break;
        case 2: 
        withdrawl();
        break;
        case 3:
        deposit();
        break;
        case 4: 
        checkAccount();
        break;
        case 5: 
        checkMaster();
        break;
        case 6: 
        closeAccount();
        break;
        
        
      }
    }while(ch<=6);
    }
  private static void createAccount() throws IOException
  {
    Calendar c=Calendar.getInstance();
    int date=c.get(Calendar.DATE);
    int month=c.get(Calendar.MONTH);
    int year=c.get(Calendar.YEAR);
    String n;
    String p;
    int m;
    System.out.println("Your Account Number is : "+Ano);
    System.out.print("Your Name : ");
    n=in.readLine();
    System.out.print("Enter your opening Balance : ");
    m=Integer.parseInt(in.readLine());
    System.out.print("Your Password : ");
    p=in.readLine();
    Acc[Ano]=new Account(n,Ano,date,month,year,m,p);
    Ano++;
  }
  private static void withdrawl() throws IOException
  {
    String p;
    int no;
    int amt;
    System.out.print("Your Account Number : ");
    no=Integer.parseInt(in.readLine());
    System.out.print("Password : ");
    p=in.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
    {
      System.out.println("Welcome "+Acc[no].Name);
      System.out.print("Withdrawl Amount : ");
      amt=Integer.parseInt(in.readLine());
      if(amt<=Acc[no].Money)
       {
           amt=Acc[no].Money-amt;
        System.out.println("Your balance after withdrawal is = " + amt);
        }
      else
        System.out.println("Only "+Acc[no].Money+" amount left in your Account");
    }
    else
      System.out.println("You are a Unauthorized Customer");
  }
  private static void deposit() throws IOException
  {
    String p;
    int no,amt;
    System.out.print("Your Account Number : ");
    no=Integer.parseInt(in.readLine());
    System.out.print("Password : ");
    p=in.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
    {
      System.out.println("Welcome "+Acc[no].Name);
      System.out.print("Deposit Amount : ");
      amt=Integer.parseInt(in.readLine());
      amt=Acc[no].Money+amt;
      System.out.println("Your balance after deposit = " + amt);
    }
    else
      System.out.println("You are Unauthorized Customer");
  }
  private static void checkAccount() throws IOException
  {
    String p;
    int no;
    int amt;
    System.out.print("Your Account No. : ");
    no=Integer.parseInt(in.readLine());
    System.out.print("Password : ");
    p=in.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
    {
      System.out.println("Your Name : "+Acc[no].Name);
      System.out.println("Balance Amount : "+Acc[no].Money);
      int rate=(Acc[no].Money>=20000)?10:5;
      System.out.println("Interest Rate : "+rate+"%");
      int interest=Acc[no].Money*rate/100;
      System.out.println("Current Balance : "+(Acc[no].Money+interest));
    }
    else
      System.out.println("You are a Unauthorized Customer");
  }
  private static void checkMaster()
  {
    System.out.println("Acc\tName\t\tDate\t\tMoney\t\tPassword");
    for(int i=1;i<Ano;i++)
      {
          Acc[i].displayData();
    }
  }      
  private static void startAccount()
  {
    Acc[Ano]=new Account("Amit",Ano,date,month,year,500,"ABC");  Ano++;
    Acc[Ano]=new Account("Sourav",Ano,date,month,year,500,"XYZ");  Ano++;
    Acc[Ano]=new Account("Shewag",Ano,date,month,year,500,"MNO");  Ano++;
  }
  private static void closeAccount() throws IOException
  {
      String p;
    int no;
    Calendar c=Calendar.getInstance();
    int date=c.get(Calendar.DATE);
    int month=c.get(Calendar.MONTH);
    int year=c.get(Calendar.YEAR);
    char z;
   
    int m;
    System.out.println("Enter your account number");
    no=Integer.parseInt(in.readLine());
    System.out.println("Enter your password");
    p=in.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
       {
      System.out.println("Are you sure that you want to close the account?"+Acc[no].Name);
      System.out.println("Enter Y for yes or N for no");
      z=(char)in.read();
      if(z=='Y')
        {
          System.out.println("Balance Amount : "+Acc[no].Money);
          System.out.println("You have" + Acc[no].Money + "money in your account which will be returned and the accout will be closed");
          System.out.println("Please check at the cashier counter for your amount");
          System.out.println("Thank you for operating with this bank");
          
        }
      else
        {
         System.out.println("You have chosen not to close the account");
        }
      }
  }
}
