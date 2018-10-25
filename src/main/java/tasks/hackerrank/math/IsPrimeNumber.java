package tasks.hackerrank.math;

import java.util.List;
import java.util.stream.Collectors;

/**
 * From: hackerrank.com. Date: 22.10.2018.
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem
 * <p>
 * Find if given number is prime.
 * <p>
 * Constraints: 1 <= n <= 2*10e9
 */
public class IsPrimeNumber {

    /**
     * We try to make number of compares as low as possible.
     * Complexity: O(sqrt(n))
     * <p>
     * We use property of prime numbers:
     * "Let's take any not-prime number n with its least divisor p. Then p^2 <= n".
     * So we need to check not all divisors 2...n-1 but only 2...sqrt(n) inclusive.
     * <p>
     * First, we check if n is divisible by 2 using bitwise operation: n & 1.
     * If not, we take step == 2 and check from 3 to sqrt(n)
     * <p>
     * The only improvement of this method can be if we check division
     * by ALL PRIMES only, from 2 to sqrt(n). But we don't know them.
     *
     * @param n Given number.
     * @return true if prime, false if not.
     */
    public boolean oneOfBestWays(int n) {
        if (n == 2) {
            return true;
        }
        if (n == 1 || ((n & 1) == 0)) {
            return false;
        }
        boolean result = true;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Just simplifies usage for list of values.
     *
     * @param numbers List of numbers.
     * @return List of result.
     */
    public List<Boolean> listOneOfTheBestWays(List<Integer> numbers) {
        return numbers.stream()
                .map(this::oneOfBestWays)
                .collect(Collectors.toList());
    }
}
