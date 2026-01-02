package blake;


import java.util.HashMap;
import java.util.Scanner;

import static blake.Conversion.calculateFromUSD;
import static blake.Conversion.calculateToUSD;

public class Main {

    public static final HashMap<String, Double> CURRENCY_RATES = new HashMap<>(); //If I put these variables inside the main method then they can't be updated in separate methods
    static {
        CURRENCY_RATES.put("yen", 157.42);
        CURRENCY_RATES.put("pesos", 18.00);
        CURRENCY_RATES.put("euros", 00.85);
        CURRENCY_RATES.put("rupees", 89.55);
    }
    public static double currency;
    public static String typeOfCurrency;

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
}

