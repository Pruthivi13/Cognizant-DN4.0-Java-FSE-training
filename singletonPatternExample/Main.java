public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting Application");

        Logger logger2 = Logger.getInstance();
        logger2.log("Another log message");

        System.out.println("Same instance? " + (logger1 == logger2));
    }
}