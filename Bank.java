import java.util.*;
import java.io.*;

class Bank implements HasMenu{

  Admin admin = new Admin();
  ArrayList<Customer> customers = new ArrayList<Customer>();

  public Bank(){
    // uncomment the next two lines to refresh data

    //this.loadSampleCustomers();
    //this.saveCustomers();
    this.loadCustomers();
    this.start();
    this.saveCustomers();
  } // end construstor

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
        loginAsCustomer();
      } // end if
    } // end while
  } // end start

  public void startAdmin(){
    Scanner input = new Scanner(System.in);
    boolean keepGoing=true;
    keepGoing = admin.login();
    while(keepGoing){
      String response = admin.menu();
      if(response.equals("0")){
        keepGoing=false;
      } // end if
      if(response.equals("1")){
        fullCustomerReport();
      } // end if
      if(response.equals("2")){
        addUser();
      } // end if
      if(response.equals("3")){
        applyInterest();
      } // end if
    } // end while
  } // end startAdmin

  public void loginAsCustomer(){
    Scanner input = new Scanner(System.in);
    System.out.println("Customer login");
    System.out.print("User name: ");
    String userName = input.nextLine();
    System.out.print("PIN: ");
    String pin = input.nextLine();

    Customer currentCustomer = null;
    for(Customer customer: customers){
      if(customer.login(userName, pin)){
        currentCustomer = customer;
      } // end if
    } // end for

    if(currentCustomer == null){
      System.out.println("No customer found");
    } // end if
    else{
      currentCustomer.start();
    } // end else
  } // end loginAsCustomer

  public void fullCustomerReport(){
    for(Customer customer: customers){
      System.out.println(customer.getReport());
    } // end for
  } // end fullCustomerReport

  public void addUser(){
    Scanner input = new Scanner(System.in);
    System.out.println("Customer login");
    System.out.print("User name: ");
    String userName = input.nextLine();
    System.out.print("PIN: ");
    String pin = input.nextLine();

    Customer newCustomer = new Customer(userName, pin);
    customers.add(newCustomer);
  } // end addUser

  public void applyInterest(){
    for(Customer customer: customers){
      customer.savings.calcInterest();
    } // end for
  } // end applyInterest

  public void loadSampleCustomers(){
    
  } // end loadSampleCustomers

  public void loadCustomers(){
    
  } // end loadCustomers

  public void saveCustomers(){
    
  } // end saveCustomers

} // end Bank
