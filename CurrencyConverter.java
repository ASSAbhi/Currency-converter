import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        
        exchangeRates.put("USD", 1.0); 
        exchangeRates.put("EUR", 0.85); 
        exchangeRates.put("GBP", 0.75); 
        exchangeRates.put("JPY", 110.0); 
        exchangeRates.put("AUD", 1.35); 
        exchangeRates.put("INR", 75.0); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

       
        System.out.println("Available Currencies:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency);
        }

       
        System.out.print("Enter the source currency code: ");
        String sourceCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();

       
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        
        System.out.println(amount + " " + sourceCurrency + " is equal to " +
                convertedAmount + " " + targetCurrency);
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        
        return amount * (targetRate / sourceRate);
    }
}
