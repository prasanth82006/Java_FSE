package week1.Module_2.Data_Structures;

public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years <= 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double annualGrowth = 0.05;
        int forecastYears = 5;

        System.out.printf("Future Value: $%.2f%n", calculateFutureValue(presentValue, annualGrowth, forecastYears));
        System.out.printf("Optimized Value: $%.2f%n", calculateFutureValueOptimized(presentValue, annualGrowth, forecastYears));
    }
}