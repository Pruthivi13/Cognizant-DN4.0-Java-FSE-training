public class Forecast {

    // Recursive method
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized tail-recursive version (optional)
    public static double futureValueTail(double presentValue, double growthRate, int years) {
        return helper(presentValue, growthRate, years);
    }

    private static double helper(double value, double rate, int years) {
        if (years == 0) return value;
        return helper(value * (1 + rate), rate, years - 1);
    }
}
