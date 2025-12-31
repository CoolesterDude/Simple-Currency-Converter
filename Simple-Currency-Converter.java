package Blake;


import java.util.HashMap;
import java.util.Scanner;

class Main {

    private static final HashMap<String, Double> CURRENCY_RATES = new HashMap<>(); //If I put these variables inside the main method then they can't be updated in separate methods
    static {
        CURRENCY_RATES.put("yen", 157.42);
        CURRENCY_RATES.put("pesos", 18.00);
        CURRENCY_RATES.put("euros", 00.85);
        CURRENCY_RATES.put("rupees", 89.55);
    }
    private static double currency;
    private static String typeOfCurrency;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double result;

        while(true) {
            System.out.println("Are you converting from USD or to USD? (Input 'From' or 'To')");
            String order = input.nextLine().toLowerCase();

            if (order.equals("from")) {
                result = calculateFromUSD(input);
                System.out.println("$" + String.format("%.2f", currency) + " USD is " + String.format("%.2f", result) + " in " + typeOfCurrency);
                break;
            } else if (order.equals("to")) {
                result = calculateToUSD(input);
                System.out.println(String.format("%.2f", currency) + " " + typeOfCurrency + " is " + String.format("%.2f", result) + " USD");
                break;
            }
        }
    }
    public static double calculateFromUSD(Scanner input) {
        double rate;

        while (true) { //Validates Currency
            System.out.print("What are you converting to? (Yen, Pesos, Euros, Rupees)\n");
            typeOfCurrency = input.nextLine().toLowerCase();

            if (CURRENCY_RATES.containsKey(typeOfCurrency)) {
                rate = CURRENCY_RATES.get(typeOfCurrency); break;
            } else {
                System.out.println("Please Enter a Valid Form of Currency.");
            }
        }
        while (true) { //Validates Number
            System.out.println("How much are you converting? (USD)");
            if (input.hasNextDouble()) {
                currency = input.nextDouble();
                input.nextLine(); break;
            } else {
                input.nextLine();
                System.out.println("Please Enter a Valid Number");
            }
        }
        return currency * rate;
    }
    public static double calculateToUSD(Scanner input) {
        double rate;
        while (true) { //Validates Currency
            System.out.println("What are you converting from? (Yen, Pesos, Euros, Rupees)");
            typeOfCurrency = input.nextLine().toLowerCase();
            if (CURRENCY_RATES.containsKey(typeOfCurrency)) {
                rate = CURRENCY_RATES.get(typeOfCurrency); break;
            } else {
                System.out.println("Please Enter a Valid Form of Currency");
                }
        }
        while (true) { //Validates Number
            System.out.println("How much are you converting? (USD)");
            if (input.hasNextDouble()) {
                currency = input.nextDouble();
                input.nextLine(); break;
            } else {
                System.out.println("Please Enter a Valid Number.");
            }
        }
        return currency / rate;
    }
}

