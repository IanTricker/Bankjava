import java.util.*;
import java.io.*;

class Admin extends User{
  
  public Admin(){
    String userName="Admin";
    String PIN="0000";
  } // end constructer

  public String menu(){
    Scanner input = new Scanner(System.in);
    System.out.println("Admin Menu\n");
    System.out.println("0) Exit this menu");
    System.out.println("1) Full customer report");
    System.out.println("2) Add user");
    System.out.println("3) Apply interest to savings accounts\n");
    System.out.print("Action:");
    String user = input.nextLine();
    return user;
  } // end menu

  public void start(){

  } // end start

  public String getReport(){
    return "Fortnite";
  } // end getReport

} // end Admin
