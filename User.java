import java.util.*;
import java.io.*;

abstract class User implements HasMenu{

  String userName;
  String PIN;

  public boolean login(){
    Scanner input = new Scanner(System.in);
    System.out.print("User name: ");
    userName = input.nextLine();
    System.out.print("PIN: ");
    PIN = input.nextLine();
    return true;
    // admin
  } // end login

  public boolean login(userName, PIN){
    if(userName == this.userName){
      if(PIN == this.PIN){
        System.out.print("Login Successful");
	return true;
      } // end if
    } // end if
    return false;
  } // end login

  public void setUserName(String userName){
    this.userName = userName;
  } // end setUserName

  public String getUserName(){
    return this.userName;
  } // end getUserName

  public void setPIN(String pin){
    if(pin.matches("^\\d{4}$)"){
      this.PIN=pin;
    }
    else{
      System.out.print("Not four digits");
    }
  } // end setPIN

  public String getPIN(){
    return this.PIN;
  } // end getPIN

  abstract String getReport(){
    
  } // end getReport
} // end User
