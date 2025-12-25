package Blake;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean valid = true;
        double yenRate = 157.42;  //Declares Currency rates to Multiply by x
        double pesosRate = 18;
        double eurosRate = .85;
        double rupeesRate = 89.55;

        float currency;
        String typeOfCurrency;
        double result = 0.0;  //Must be set to 0 otherwise it won't know if it's initialized or not and gives an error

        while(valid) {
            Scanner input = new Scanner(System.in);
            System.out.println("Are you converting from USD or to USD? (Input 'From' or 'To')");
            String order = input.nextLine().toLowerCase();  //takes from or to and sets to lowercase to avoid error

            if (order.equals("from")) { //if user chooses to convert from then it assigns value to typeofCurrency variable and the amount of money to be converted
                System.out.print("What are you converting to? (Yen, Pesos, Euros, Rupees)");
                typeOfCurrency = input.nextLine().toLowerCase();
                System.out.println("How much are you converting? (USD)");
                currency = input.nextFloat();
                input.nextLine();  //leaves an extra enter so it's not on the same line

                switch (typeOfCurrency) { //depending on which typeofCurrency the equation of the result changes
                    case ("yen"):
                        result = currency * yenRate;
                        break;
                    case ("pesos"):
                        result = currency * pesosRate;
                        break;
                    case ("euros"):
                        result = currency * eurosRate;
                        break;
                    case ("rupees"):
                        result = currency * rupeesRate;
                        break;
                    default:
                        System.out.println("Please Enter Valid Numbers."); //simple error correction
                        break;
                }
                System.out.println("$" + String.format("%.2f", currency) + " is " + String.format("%.2f", result) + " in " + typeOfCurrency); //outputs at the end inside of if statement to keep code clean


            } else if (order.equals("to")) { //if user chooses to convert from x to usd then it will assing value to type of currency and amount of USD being converted
                System.out.println("What are you converting from? (Yen, Pesos, Euros, Rupees)");
                typeOfCurrency = input.nextLine().toLowerCase();
                System.out.println("How much are you converting? (USD)");
                currency = input.nextFloat();
                input.nextLine(); //leaves an extra enter so it's not on the same line

                switch (typeOfCurrency) { //depending on which currency the user chose it will divide the USD by the rate currency chosen
                    case ("yen"):
                        result = currency / yenRate;
                        break;
                    case ("pesos"):
                        result = currency / pesosRate;
                        break;
                    case ("euros"):
                        result = currency / eurosRate;
                        break;
                    case ("rupees"):
                        result = currency / rupeesRate;
                        break;
                    default:
                        System.out.println("Please Enter Valid Numbers."); //simple error correction
                        valid = false;
                        break;
                }
                System.out.println(String.format("%.2f", currency) + " " + typeOfCurrency + " is " + String.format("%.2f", result) + " USD");
                    /*
                    Output of result at the bottom inside of else if statement for cleaner code
                    Also I used String.format("%.2f", x) because the % means to print variable instead of string, .2 means it will only show 2 digits after the decimal and f turns it into a float which roads it up from 00.000000000 to 00.00
                     */
            }
        }
    }
}