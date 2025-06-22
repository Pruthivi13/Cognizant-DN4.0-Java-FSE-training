package strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234567890123456", "Pruthiviraj Sahu"));
        context.pay(2500.00);

        System.out.println();

        // Pay using PayPal
        context.setPaymentStrategy(new PayPalPayment("pruthiviraj@example.com"));
        context.pay(1800.50);
    }
}
