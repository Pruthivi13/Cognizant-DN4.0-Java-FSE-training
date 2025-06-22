package strategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
