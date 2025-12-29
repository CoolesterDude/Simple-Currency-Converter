package Blake;


import java.util.HashMap;
import java.util.Scanner;

class Main {

    private static final HashMap<String, Double> CURRENCY_RATES = new HashMap<>();
    static {
        CURRENCY_RATES.put("yen", 157.42);
        CURRENCY_RATES.put("pesos", 18.00);
        CURRENCY_RATES.put("euros", 00.85);
        CURRENCY_RATES.put("rupees", 89.55);
    }

    public static void main(String[] args) {
        double yenRate = 157.42;
        double pesosRate = 18;
        double eurosRate = .85;
        double rupeesRate = 89.55;

        float currency = 0;
        double result;
        Scanner input = new Scanner(System.in);
        String typeOfCurrency = "50";

        while(true) {
            System.out.println("Are you converting from USD or to USD? (Input 'From' or 'To')");
            String order = input.nextLine().toLowerCase();

            if (order.equals("from")) {
                result = calculateFromUSD(currency, input);
                System.out.println("$" + String.format("%.2f", currency) + " is " + String.format("%.2f", result) + " in " + typeOfCurrency);
                break;
            } else if (order.equals("to")) {
                result = calculateToUSD(currency, input);
                System.out.println(String.format("%.2f", currency) + " " + typeOfCurrency + " is " + String.format("%.2f", result) + " USD");
                break;
            }
        }
    }
    public static double calculateFromUSD(float currency, Scanner input) {
        double value = 0;
        System.out.print("What are you converting to? (Yen, Pesos, Euros, Rupees)\n");
        String typeOfCurrency = input.nextLine().toLowerCase();
        double rate = CURRENCY_RATES.get(typeOfCurrency);
        System.out.println("How much are you converting? (USD)");
        currency = input.nextFloat();
        input.nextLine();  //leaves an extra enter so it's not on the same line

        value = currency * rate;

        return value;
    }
    public static double calculateToUSD(float currency, Scanner input) {
        double value = 0;
        System.out.println("What are you converting from? (Yen, Pesos, Euros, Rupees)\n");
        String typeOfCurrency = input.nextLine().toLowerCase();
        double rate = CURRENCY_RATES.get(typeOfCurrency);
        System.out.println("How much are you converting? (USD)");
        currency = input.nextFloat();
        input.nextLine();

        return value;
    }
}

