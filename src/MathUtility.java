public class MathUtility {

    // 5 Static Methods

    /**
     * Determines if a number is prime or not.
     * @param n The number to verify.
     * @return true if n is a prime number, false otherwise.
     */
    public static boolean checkPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Uses the Euclidean algorithm to find the greatest common divisor of two numbers.
     * @param x First number.
     * @param y Second number.
     * @return The greatest common divisor (GCD) of x and y.
     */
    public static int computeGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    /**
     * Calculates the least common multiple (LCM) of two integers.
     * @param x First integer.
     * @param y Second integer.
     * @return The least common multiple of x and y.
     */
    public static int findLCM(int x, int y) {
        return Math.abs(x * y) / computeGCD(x, y);
    }

    /**
     * Generates the nth Fibonacci number.
     * @param n Position in the Fibonacci sequence.
     * @return The Fibonacci number at position n.
     */
    public static int getFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev1 = 0, prev2 = 1, fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;
        }
        return fib;
    }

    /**
     * Computes the factorial of a given number.
     * @param n The number to calculate the factorial for.
     * @return The factorial of n.
     */
    public static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 5 Non-static Methods

    /**
     * Verifies whether a number is perfect.
     * A perfect number equals the sum of its divisors (excluding itself).
     * @param n The number to verify.
     * @return true if n is a perfect number, false otherwise.
     */
    public boolean isPerfect(int n) {
        int divisorSum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisorSum += i;
                if (i != n / i) {
                    divisorSum += n / i;
                }
            }
        }
        return divisorSum == n && n != 1;
    }

    /**
     * Sums the digits of a number.
     * @param n The number whose digits are to be summed.
     * @return The sum of the digits of n.
     */
    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Reverses the digits of a number.
     * @param n The number to reverse.
     * @return The reversed number.
     */
    public int reverseDigits(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    /**
     * Determines whether a number is an Armstrong number.
     * An Armstrong number is a number that equals the sum of its digits raised to the power of the number of digits.
     * @param n The number to check.
     * @return true if n is an Armstrong number, false otherwise.
     */
    public boolean isArmstrong(int n) {
        int sum = 0, original = n;
        int digitsCount = String.valueOf(n).length();
        while (n > 0) {
            sum += Math.pow(n % 10, digitsCount);
            n /= 10;
        }
        return sum == original;
    }

    /**
     * Finds the next prime number greater than the given number.
     * @param n The number to start from.
     * @return The next prime number greater than n.
     */
    public int nextPrime(int n) {
        n++;
        while (!checkPrime(n)) {
            n++;
        }
        return n;
    }

    // Main method for testing the MathUtility class functionality
    public static void main(String[] args) {
        // Testing static methods
        System.out.println("Testing Static Methods:");
        System.out.println("Is 13 a prime number? " + checkPrime(13));
        System.out.println("GCD of 56 and 98: " + computeGCD(56, 98));
        System.out.println("LCM of 8 and 12: " + findLCM(8, 12));
        System.out.println("The 10th Fibonacci number: " + getFibonacci(10));
        System.out.println("Factorial of 6: " + calculateFactorial(6));

        // Testing non-static methods
        MathUtility mathUtil = new MathUtility();
        System.out.println("\nTesting Non-static Methods:");
        System.out.println("Is 496 a perfect number? " + mathUtil.isPerfect(496));
        System.out.println("Sum of digits in 9876: " + mathUtil.digitSum(9876));
        System.out.println("Reversed number of 1234: " + mathUtil.reverseDigits(1234));
        System.out.println("Is 370 an Armstrong number? " + mathUtil.isArmstrong(370));
        System.out.println("Next prime number after 17: " + mathUtil.nextPrime(17));
    }
}