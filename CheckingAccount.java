import java.util.*;
import java.io.*;

class CheckingAccount implements HasMenu{
  double balance;

  public static void main(String[] args){
    CheckingAccount ca = new CheckingAccount();
    ca.start();
  } // end main

  public CheckingAccount(){
    this.balance = 0d;
  }  // end CheckingAccount constructor

  public CheckingAccount(double balance){

  } // end CheckingAcount constructor

  public void start(){
    boolean keepGoing=true;
    while(keepGoing){
      String response = menu();
      if(response.equals("0")){
        keepGoing=false;
      } // end if
      if(response.equals("1")){
        System.out.println("Checking balance...");
	this.checkBalance();
      } // end if
      if(response.equals("2")){
        System.out.println("Making a deposit...");
	this.makeDeposit();
      } // end if
      if(response.equals("3")){
        System.out.println("Making a withdrawal...");
	//this.makeWithdrawal
      } // end if

    } // end while
  } // end start
  public String menu(){
    System.out.println("\n\nAccount menu\n");
    Scanner input = new Scanner(System.in);
    System.out.println("0) quit");
    System.out.println("1) check balance");
    System.out.println("2) make a deposit");
    System.out.println("3) make a withdrawal\n");
    System.out.println("Please enter 0-3: ");
    String user = input.nextLine();
    return user;
  } // end menu

  public void checkBalance(){
    System.out.println("Current balance: " + this.getBalanceString());
  } // end checkBalance

  public String getBalanceString(){
    String result = String.format("$%.02f", this.balance);
    return result;
  } // end getBalanceString

  public void makeDeposit(){
    Scanner input = new Scanner(System.in);
    System.out.print("How much to deposit? ");
    double depo = input.nextDouble;
    this.balance = this.balance + depo;
    System.out.println("New balance: " + this.getBalanceString);
  } // end makeDeposit

} // end CheckingAccount
