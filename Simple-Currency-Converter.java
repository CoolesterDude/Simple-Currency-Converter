package Blake;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double yenRate = 157.42;  //Declares Currency rates to Multiply by x
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
                result = calculateFromUSD(currency, yenRate, pesosRate, eurosRate, rupeesRate, input);
                System.out.println("$" + String.format("%.2f", currency) + " is " + String.format("%.2f", result) + " in " + typeOfCurrency);
                break;
            } else if (order.equals("to")) {
                result = calculateToUSD(currency, yenRate, pesosRate, eurosRate, rupeesRate, typeOfCurrency, input);
                System.out.println(String.format("%.2f", currency) + " " + typeOfCurrency + " is " + String.format("%.2f", result) + " USD");
                break;
            }
        }
    }
    public static double calculateFromUSD(float currency, double yenRate, double pesosRate, double eurosRate, double rupeesRate, Scanner input) {
        double value = 0;
        System.out.print("What are you converting to? (Yen, Pesos, Euros, Rupees)\n");
        String typeOfCurrency = input.nextLine().toLowerCase();
        System.out.println("How much are you converting? (USD)");
        currency = input.nextFloat();
        input.nextLine();  //leaves an extra enter so it's not on the same line

        switch (typeOfCurrency) { //depending on which typeofCurrency the equation of the result changes
            case ("yen"):
                value = currency * yenRate;
                break;
            case ("pesos"):
                value = currency * pesosRate;
                break;
            case ("euros"):
                value = currency * eurosRate;
                break;
            case ("rupees"):
                value = currency * rupeesRate;
                break;
            default:
                System.out.println("Please Enter Valid Numbers."); //simple error correction
                break;
        }
        return value;
    }
    public static double calculateToUSD(float currency, double yenRate, double pesosRate, double eurosRate, double rupeesRate, String typeOfCurrency, Scanner input) {
        double value = 0;
        System.out.println("What are you converting from? (Yen, Pesos, Euros, Rupees)");
        typeOfCurrency = input.nextLine().toLowerCase();
        input.nextLine();
        System.out.println("How much are you converting? (USD)");
        currency = input.nextFloat();
        input.nextLine();

        switch (typeOfCurrency) {
            case ("yen"):
                value = currency / yenRate;
                break;
            case ("pesos"):
                value = currency / pesosRate;
                break;
            case ("euros"):
                value = currency / eurosRate;
                break;
            case ("rupees"):
                value =currency / rupeesRate;
                break;
            default:
                System.out.println("Please Enter Valid Numbers."); //simple error correction
                break;
        }
        return value;
    }
}

