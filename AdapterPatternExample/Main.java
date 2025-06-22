public class Main {
    public static void main(String[] args) {
        // Use PayPal via Adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(150.75);

        // Use Stripe via Adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(300.00);
    }
}
