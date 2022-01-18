import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Converter {

    private static Scanner scanner;
    private static PrintStream printStream;

    public Converter(InputStream inputStream, PrintStream printStream) {
        scanner = new Scanner(inputStream);
        Converter.printStream = printStream;
    }

    public static void main(String[] args) {
        Converter userInputExample = new Converter(System.in, System.out);
        userInputExample.start();
    }


    public void start() {
        double result;
        while (true) {
            printStream.println("F to C (print 'F') or C to F (print 'C') ?");
            String mode = scanner.nextLine();
            if (!checkModeCorrectness(mode)) printStream.println("error. No such mode (C or F)");
            if (mode.equals("C") || mode.equals("c")) {
                result = convertCelsiusToFahrenheit();
                break;
            } else if (mode.equals("F") || mode.equals("f")) {
                result = convertFahrenheitToCelsius();
                break;
            }
        }
        printStream.println("result: " + (result * 10.0) / 10.0);

    }

    public static boolean checkModeCorrectness(String mode) {
        return mode.equals("C") || mode.equals("c") || mode.equals("F") || mode.equals("f");
    }

    public double convertCelsiusToFahrenheit() {
        double temperature = getTemperature(scanner, printStream);
        return countTemperatureCelsiusToFahrenheit(temperature);
    }

    public static double countTemperatureCelsiusToFahrenheit(double temperature) {
        return temperature * 9.0 / 5.0 + 32.0;
    }

    public double convertFahrenheitToCelsius() {
        double temperature = getTemperature(scanner, printStream);
        return countTemperatureFahrenheitToCelsius(temperature);
    }

    public static double countTemperatureFahrenheitToCelsius(double temperature) {
        return (temperature - 32.0) * 5.0 / 9.0;
    }

    public double getTemperature(Scanner scanner, PrintStream printStream) {
        double temperature;
        while (true) {
            printStream.println("Print value:");
            String value = scanner.nextLine();
            if (!checkValueCorrectness(value)) {
                printStream.println("Wrong input value");
                continue;
            }
            try {
                if (value.contains(".")) {
                    temperature = Double.parseDouble(value);
                } else {
                    temperature = Integer.parseInt(value);
                }
                break;
            } catch (Exception e) {
                printStream.println("Wrong input value");
            }
        }
        return temperature;
    }

    public static boolean checkValueCorrectness(String value) {
        return value.matches("-?\\d+(\\.\\d+)?");
    }
}