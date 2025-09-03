import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        double usdToInr = 83.10;
        double usdToEur = 0.92;
        double usdToGbp = 0.78;

        System.out.println("=== Currency Converter ===");
        System.out.println("Available currencies: USD, INR, EUR, GBP");

        
        System.out.print("Enter base currency (USD/INR/EUR/GBP): ");
        String base = sc.next().toUpperCase();

        
        System.out.print("Enter target currency (USD/INR/EUR/GBP): ");
        String target = sc.next().toUpperCase();

        
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        double inUsd = 0; 
        switch (base) {
            case "USD":
                inUsd = amount;
                break;
            case "INR":
                inUsd = amount / usdToInr;
                break;
            case "EUR":
                inUsd = amount / usdToEur;
                break;
            case "GBP":
                inUsd = amount / usdToGbp;
                break;
            default:
                System.out.println(" Invalid base currency.");
                return;
        }

        double converted = 0;
        switch (target) {
            case "USD":
                converted = inUsd;
                break;
            case "INR":
                converted = inUsd * usdToInr;
                break;
            case "EUR":
                converted = inUsd * usdToEur;
                break;
            case "GBP":
                converted = inUsd * usdToGbp;
                break;
            default:
                System.out.println(" Invalid target currency.");
                return;
        }

        System.out.printf(" Converted Amount: %.2f %s\n", converted, target);
        sc.close();
    }
}
