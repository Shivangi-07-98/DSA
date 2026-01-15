import java.io.*;
import java.util.*;

class Main {
  static class BankAccount {
    int anum;
    int money;
    static int roi;

    void announce() {
      int anum = 10;
      System.out.println(anum + ", " + this.money + ", " + this.roi);
    }

    static void decreaseROI() {
      roi--;
      // anum and money can't be used
      // Because static functions can be called by class name and in that case we don't know if any object exists and if they do we wont know which objects non-static data members to use.

      // announce(); // not allowed

      BankAccount a = new BankAccount();
      a.announce(); // this is allowed
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BankAccount a1 = new BankAccount();
    a1.anum = 10;
    a1.money = 100;
    // bad practice (static data members should be modified using class and not object)
    a1.roi = 4;
    BankAccount.roi = 5;
    a1.announce();

    BankAccount a2 = new BankAccount();
    a2.anum = 11;
    a2.money = 110;
    a2.roi = 5;

    a2.announce();
    a1.announce();

    BankAccount.decreaseROI();
  }

}