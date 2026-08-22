package OOPs;

/*
 * Definition:
 * An interface is like a contract.
 *
 * It tells a class what method it must provide,
 * but the implementing class gives the actual implementation.
 *
 * IMPORTANT SYNTAX:
 *
 * interface Payment {
 *     void pay(double amount);
 * }
 *
 * We write "interface" directly.
 * We do NOT write "class interface".
 *
 * IMPLEMENTING AN INTERFACE:
 * class CardPayment implements Payment
 *
 * We use "implements", NOT "extends".
 *
 * extends:
 * Used when one class inherits from another class.
 *
 * implements:
 * Used when a class implements an interface.
 *
 * Example:
 *
 * Payment
 *    ↓
 * CardPayment
 * UpiPayment
 *
 * CardPayment and UpiPayment implement Payment.
 */

import java.io.*;
import java.util.*;

public class Interface {

  interface Payment {
    // Method declaration.
    // The implementing class must provide its implementation.
    void pay(double amount);
  }

  static class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
      System.out.println("Paid Rs. " + amount + " using card.");
    }
  }

  static class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
      System.out.println("Paid Rs. " + amount + " using UPI.");
    }
  }

  public static void main(String[] args) {
    // Interface reference → CardPayment object
    Payment payment = new CardPayment();
    payment.pay(500);

    // Same Payment reference → UpiPayment object
    payment = new UpiPayment();
    payment.pay(250);
  }
}

/*
 * 
 * Could you write {} and leave it empty?
 * No, not for this normal interface method.
 * 
 * interface Payment {
 *    void pay(double amount) {
 *    }
 * }
 *
 * is not valid for a normal abstract interface method.
 * 
 * You write:
 * void pay(double amount);
 * 
 * The semicolon means:
 * The method is declared here; implementation will be provided by the
 * implementing class.
 * Payment is an interface. Payment says void pay(double amount)
 * So every class implementing Payment must provide pay()
 *
 * CardPayment implements Payment.
 * Therefore CardPayment must write pay().
 *
 * UpiPayment also implements Payment.
 * Therefore UpiPayment must also write pay().
 *
 * @Override tells Java:
 *
 * "I am providing the implementation of a method
 * that already exists in the parent/interface."
 *
 * It is NOT mandatory for overriding to work.
 * But it is strongly recommended because the compiler
 * can catch mistakes.
 *
 * For example, if we accidentally write:
 *
 * @Override
 * void pays(double amount) {
 *
 * }
 *
 * Java will give an error because "pays" does not match
 * the method "pay" from the interface.
 *
 * Interface cannot be instantiated directly:
 *
 * Payment payment = new Payment(); // NOT allowed
 *
 * But an interface reference can point to an object
 * of a class that implements the interface:
 *
 * Payment payment = new CardPayment();
 *
 * The reference is Payment,
 * but the actual object is CardPayment.
 *
 * Therefore:
 * payment.pay(500);
 * runs CardPayment's pay().
 *
 * Then:
 * payment = new UpiPayment();
 * payment.pay(250);
 * runs UpiPayment's pay().
 *
 * SIMPLE INTERVIEW EXPLANATION:
 *
 * "An interface is a contract. It defines what a class must do,
 * and the implementing class provides how it does it."
 */
