public class Main {
    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Sending multi-channel notification:\n");
        fullNotifier.send("System maintenance scheduled at 11 PM tonight.");
    }
}
