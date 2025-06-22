public class Main {
    public static void main(String[] args) {
        double presentValue = 10000;      // $10,000
        double growthRate = 0.05;         // 5% annual growth
        int years = 10;

        double futureValue = Forecast.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value (Recursive): $%.2f%n", futureValue);

        double optimized = Forecast.futureValueTail(presentValue, growthRate, years);
        System.out.printf("Future Value (Tail Recursive): $%.2f%n", optimized);
    }
}
