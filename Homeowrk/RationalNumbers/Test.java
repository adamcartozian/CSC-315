package Homeowrk.RationalNumbers;

    import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numerator: ");
        int numerator = scanner.nextInt();
        System.out.print("Enter the denominator: ");
        int denominator = scanner.nextInt();
        scanner.close();

        int gcd = findGCD(numerator, denominator);

        int simplifiedNumerator = numerator / gcd;
        int simplifiedDenominator = denominator / gcd;

        System.out.println("Simplified fraction: " + simplifiedNumerator + "/" + simplifiedDenominator);
    }

    // Function to find the greatest common divisor (GCD) using Euclidean algorithm
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
