package OOPs;

/*
Question: Create an interface and implement it in child classes.

Idea:
The interface is a contract. It says every Payment must have pay().
Each payment type writes its own implementation. Payment is useful as the
reference type because the caller can work with every payment in one way.
*/
public class InterfaceImplementation {
    interface Payment {
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
        Payment payment = new CardPayment();
        payment.pay(500);

        payment = new UpiPayment();
        payment.pay(250);
    }
}
