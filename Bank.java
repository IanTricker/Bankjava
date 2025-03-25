import java.util.*;
import java.io.*;

class Bank implements HasMenu{

  Admin admin = new Admin();
  ArrayList<Customer> customers = new ArrayList<Customer>();

  public static void main(String[] args){
    Bank ba = new Bank();
    ba.start();
  } // end main

  public String menu(){
    Scanner input = new Scanner(System.in);
    System.out.println("Bank Menu\n");
    System.out.println("0) Exit system");
    System.out.println("1) Login as admin");
    System.out.println("2) Login as customer\n");
    System.out.print("Action: ");
    String user = input.nextLine();
    return user;
  } // end menu

  public void start(){
    boolean keepGoing=true;
    while(keepGoing){
      String response = menu();
      if(response.equals("0")){
        keepGoing=false;
      } // end if
      if(response.equals("1")){
        startAdmin();
      } // end if
      if(response.equals("2")){
        //userlogr
      } // end if
    } // end while
  } // end start

  public void startAdmin(){
    Scanner input = new Scanner(System.in);
    boolean keepGoing=true;
    while(keepGoing){
      String response = admin.menu();
      if(response.equals("0")){
        keepGoing=false;
      } // end if
      if(response.equals("1")){
        System.out.println("John, 1000, 20");
      }
      if(response.equals("2")){
        System.out.println("add bob");
      } // end if
      if(response.equals("3")){
        System.out.print("More money");
      } // end if
    } // end while
  } // end startAdmin

} // end Bank
