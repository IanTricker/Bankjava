import java.util.*;
import java.io.*;

class SavingsAccount extends CheckingAccount{
  double interestRate = .05;

  public static void main(String[] args){
    SavingsAccount sa = new SavingsAccount();
    sa.start();
  } // end main

  public void calcInterest(){
    double interestAmount = this.balance * this.interestRate;
    this.balance += interestAmount;
    System.out.print("New Balance: " + this.getBalanceString());
  } // end calcInterest

  public void setInterestRate(){
    this.interestRate = interestRate;
  } // end setInterestRate

  public double getInterestRate(){
    return this.interestRate;
  } // end getInterestRate

} // end SavingsAccount
