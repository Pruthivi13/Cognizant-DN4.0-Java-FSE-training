public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println(basicComputer);
        System.out.println();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        System.out.println(gamingComputer);
    }
}
