package tasks.hackerrank.strings;

/**
 * Name: Repeated String. From: hackerrank.com. Date: 15.09.2018
 * <p>
 * Given a string of letters, imagine it is repeated infinitely.
 * Find how much times letter 'a' will be found in the first N symbols of such infinite string.
 * <p>
 * Constraints: 1 <= string.length <= 100, 1 <= N <= 10e12.
 * <p>
 * Example: given "aba" and N = 10.
 * We get: firs 10 symbols: "abaabaabaa". Counting a's we get answer = 7.
 */
public class RepeatedString {

    /**
     * Idea: let string length = len.
     * <p>
     * Then, when we take first N characters of infinitely repeated string, the string
     * will fully repeat (N / len) times. Then the rest has (X = N - (N / len) = N % len) symbols.
     * <p>
     * We just need to count needed char in the whole string, multiply it to (N / len)
     * and add count of needed in the first (N % len) symbols of the string.
     *
     * @param s Given string.
     * @param n Number of symbols to take into account.
     * @param c Char to count.
     * @return Number of chars counted.
     */
    public long count(String s, long n, char c) {
        int aFull = 0;
        int aRest = 0;
        long repeated = n / s.length();
        long rest = n % s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                aFull++;
                if (i < rest) {
                    aRest++;
                }
            }
        }
        return repeated * aFull + aRest;
    }

}
