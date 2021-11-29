import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("F to C (print 'F') or C to F (print 'C') ?");
        String mode = scanner.next();
        if (mode.equals("C") || mode.equals("c")) {
            cToF(scanner);
        } else if (mode.equals("F") || mode.equals("f")) {
            fToC(scanner);
        } else {
            System.out.println("error mode (C or F)");
        }
    }

    static void cToF(Scanner scanner) {
        System.out.println(getTemperature(scanner) * 9 / 5.0 + 32);
    }

    static void fToC(Scanner scanner) {
        System.out.println((getTemperature(scanner) - 32) * 5 / 9.0);
    }

    static long getTemperature(Scanner scanner) {
        long temperature;
        while (true) {
            System.out.println("Print value:");
            String value = scanner.next();
            try {
                temperature = Long.parseLong(value);
                break;
            } catch (Exception e) {
                System.out.println("Wrong input value");
            }
        }
        return temperature;
    }

}
