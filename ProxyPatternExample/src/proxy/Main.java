public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image not loaded yet
        System.out.println("First time display of image1:");
        image1.display();  // Loads and displays

        System.out.println("\nSecond time display of image1:");
        image1.display();  // Only displays, no loading

        System.out.println("\nDisplay image2:");
        image2.display();  // Loads and displays
    }
}
