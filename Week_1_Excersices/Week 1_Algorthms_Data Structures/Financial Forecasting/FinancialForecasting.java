import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FinancialForecasting {
    // Method to predict future value using recursion with BigDecimal
    public BigDecimal predictFutureValue(BigDecimal currentValue, BigDecimal growthRate, int years) {
        if (years == 0) {
            return currentValue; // Base case: no more years to predict
        } else {
            // Calculate new value: currentValue * (1 + growthRate)
            BigDecimal onePlusGrowthRate = BigDecimal.ONE.add(growthRate);
            BigDecimal newValue = currentValue.multiply(onePlusGrowthRate);
            return predictFutureValue(newValue, growthRate, years - 1); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinancialForecasting forecasting = new FinancialForecasting();

        System.out.print("Enter current value: ");
        BigDecimal currentValue = scanner.nextBigDecimal();

        System.out.print("Enter annual growth rate (as a decimal): ");
        BigDecimal growthRate = scanner.nextBigDecimal();

        System.out.print("Enter number of years to predict: ");
        int years = scanner.nextInt();

        BigDecimal futureValue = forecasting.predictFutureValue(currentValue, growthRate, years);
        System.out.println("Predicted future value after " + years + " years: " + futureValue.setScale(2, RoundingMode.HALF_UP));

        scanner.close();
    }
}
