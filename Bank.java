import java.util.*;
import java.io.*;

class Bank implements HasMenu{

  Admin admin = new Admin();
  ArrayList<Customer> customers = new ArrayList<Customer>();

  public Bank(){
    // uncomment the next two lines to refresh data

    this.loadSampleCustomers();
    this.saveCustomers();
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
    System.out.println();
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
    System.out.println();

    Customer currentCustomer = null;
    for(Customer customer: customers){
      System.out.println(customer.getUserName());
      if(customer.login(userName, pin)){
        currentCustomer = customer;
        currentCustomer.start();
      } // end if
    } // end for

    if(currentCustomer == null){
      System.out.println("No customer found\n");
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
    System.out.println();
    Customer newCustomer = new Customer(userName, pin);
    newCustomer.checking.setBalance(0);
    newCustomer.savings.setBalance(0);
    customers.add(newCustomer);
  } // end addUser

  public void applyInterest(){
    for(Customer customer: customers){
      customer.savings.calcInterest();
    } // end for
  } // end applyInterest

  public void loadSampleCustomers(){
     customers.add(new Customer("Alice", "1234"));
     customers.get(0).checking.setBalance(100);
     customers.get(0).savings.setBalance(100);
     customers.add(new Customer("Bob", "5678"));
     customers.get(1).checking.setBalance(0);
     customers.get(1).savings.setBalance(0);
     customers.add(new Customer("Cindy", "9101"));
     customers.get(2).checking.setBalance(0);
     customers.get(2).savings.setBalance(0);
  } // end loadSampleCustomers

  public void loadCustomers(){
    try{
      FileInputStream fIn = new FileInputStream("SerialBank.dat");
      ObjectInputStream obIn = new ObjectInputStream(fIn);
      customers = (CustomerList)obIn.readObject();
    } catch (Exception e){
      System.out.println(e.getMessage());
    } // end try catch
  } // end loadCustomers

  public void saveCustomers(){
    
    try{
      FileOutputStream fo = new FileOutputStream("SerialBank.dat");
      ObjectOutputStream obOut = new ObjectOutputStream(fo);
      obOut.writeObject(customers);
    } catch (Exception e){
      System.out.println(e.getMessage());
    } // end try catch
  } // end saveCustomers

  class CustomerList extends ArrayList<Customer>{}

} // end Bank
