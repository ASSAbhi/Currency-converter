import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Define exchange rates (e.g., 1 unit of the currency to other currencies)
        exchangeRates.put("USD", 1.0); // United States Dollar
        exchangeRates.put("EUR", 0.85); // Euro
        exchangeRates.put("GBP", 0.75); // British Pound Sterling
        exchangeRates.put("JPY", 110.0); // Japanese Yen
        exchangeRates.put("AUD", 1.35); // Australian Dollar
        exchangeRates.put("INR", 75.0); // Indian Rupee
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        // Display available currencies
        System.out.println("Available Currencies:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency);
        }

        // Get input from the user
        System.out.print("Enter the source currency code: ");
        String sourceCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();

        // Convert currency
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        // Display the result
        System.out.println(amount + " " + sourceCurrency + " is equal to " +
                convertedAmount + " " + targetCurrency);
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Perform the conversion
        return amount * (targetRate / sourceRate);
    }
}
