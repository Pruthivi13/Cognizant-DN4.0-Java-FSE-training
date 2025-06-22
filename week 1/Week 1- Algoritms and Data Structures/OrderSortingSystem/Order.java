public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() { return totalPrice; }
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }

    @Override
    public String toString() {
        return orderId + " - " + customerName + " - $" + totalPrice;
    }
}
