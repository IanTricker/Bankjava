import java.util.*;
import java.io.*;

class Customer extends User{
  
  CheckingAccount checking;
  SavingsAccount savings;

  public Customer(){
   this.userName = "admin";
   this.PIN = "0000";
  } // end Customer

  public Customer(String userName,String PIN){
    this.userName = userName;
    this.PIN = PIN;
    this.checking = new CheckingAccount();
    this.savings = new SavingsAccount();
  } // end Customer
  
  public static void main(String[] args){
    Customer cu = new Customer();
    cu.start();
  } // end main

  public void start(){
    boolean keepGoing=true;
    while(keepGoing){
      String response = menu();
      if(response.equals("0")){
        keepGoing=false;
      } // end if
      if(response.equals("1")){
        checking.start();
      } // end if
      if(response.equals("2")){
        savings.start();
      } // end if
      if(response.equals("3")){
        this.changePin();
      } // end if
    } // end while
  } // end start

  public String menu(){
    Scanner input = new Scanner(System.in);
    System.out.println("0) Exit");
    System.out.println("1) Manage Checking Account");
    System.out.println("2) Manage Savings Account");
    System.out.println("3) change PIN");
    System.out.print("\nAction (0-3): ");
    String user = input.nextLine();
    return user;
  } // end menu

  public void changePin(){
    Scanner input = new Scanner(System.in);
    System.out.print("Change PIN: ");
    String newPin = input.nextLine();
    this.setPIN(newPin);
  } // end changePin

  public String getReport(){
    System.out.println("User: " + this.userName);
    checking.checkBalance();
    savings.checkBalance();
    return "";
  } // end getReport

} // end Customer
