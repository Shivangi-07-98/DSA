package OOPs;

import java.io.*;
import java.util.*;

class Main {

  static class P {
    int d = 1;
    int d1 = 10;

    void fun() {
      System.out.println("P fun");
    }

    void fun1() {
      System.out.println("P fun1");
    }
  }

  static class C extends P {
    int d = 2;
    int d2 = 20;

    void fun() {
      System.out.println("C fun");
    }

    void fun2() {
      System.out.println("C fun2");
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    // case 1 => P and P
    P obj1 = new P(); // obj is normal name
    System.out.println(obj1.d); // 1
    System.out.println(obj1.d1); // 10
    obj1.fun(); // P fun
    obj1.fun1(); // P fun1

    // case 2 => C and C
    C obj2 = new C();
    System.out.println(obj2.d); // conflict (object has P.d and C.d, resolved by ref C)
    System.out.println(((P) obj2).d); // conflict (object has P.d and C.d, resolved by ref P), P mai typecast
    System.out.println(obj2.d1); // available only in P
    System.out.println(obj2.d2); // available only in C

    obj2.fun(); // available at C first
    obj2.fun1(); // available only in P
    obj2.fun2(); // available only in C

    // case 3 => P and C
    // compiler sees left side, runtime sees right side
    // compiler P class ko dekh kr allow krega aur chlega C ka kuki ref C ka hai
    P obj3 = new C();
    System.out.println(obj3.d); // conflict (object has P.d and C.d, resolved by ref P)
    System.out.println(obj3.d1); // available only in P
    // System.out.println(obj.d2); // not allowed, because compiler doesn't allow it
    System.out.println(((C) obj3).d2); // typecasting allows it and we see C.d2

    obj3.fun(); // available at C first
    obj3.fun1(); // available only in P
    // obj.fun2(); // not allowed, because compiler won't allow it
    ((C) obj3).fun2(); // typecasting allows it and we see C fun2

    // case 4 => C and p
    // C obj4 = new P();

    // Why not allowed
    // If allowed, we will subsequently get run-time errors because C allows d, d1,
    // d2, f, d1, fun2
    // but P (instance) only has d and d1, f and f1
  }

}
