package blake;

import java.util.Scanner;

import static blake.Main.*;

public class Conversion {
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
