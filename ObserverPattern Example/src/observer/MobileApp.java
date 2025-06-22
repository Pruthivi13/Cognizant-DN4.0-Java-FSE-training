public class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("MobileApp [" + user + "]: " + stockName + " updated to $" + newPrice);
}
}