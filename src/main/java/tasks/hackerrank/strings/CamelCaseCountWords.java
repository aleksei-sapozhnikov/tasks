package tasks.hackerrank.strings;

/**
 * Name: Camel Case. From: hackerrank.com. Date: 17.10.2018
 * <p>
 * A string contains words written inCamelCase. First word starts with first letter,
 * others start with Capital letter. Find number of words in the string.
 * <p>
 * A valley is a sequence of consecutive steps below sea level and ending at sea level.
 * starting with a step down from sea level and ending with a step up to sea level.
 * <p>
 * Constraints: 1<= string.length <= 10e5; string contains only English letters.
 */
public class CamelCaseCountWords {

    /**
     * Count capital letters using java 8 streams.
     *
     * @param s Given string.
     * @return Number of words.
     */
    public int usingStreams(String s) {
        int first = s.length() > 0 ? 1 : 0;
        int upper = (int) s.chars()
                .filter(c -> c >= 'A' && c <= 'Z')
                .count();
        return first + upper;
    }

    /**
     * Count capital letters by old-fashioned cycle.
     *
     * @param s Given string.
     * @return Number of words.
     */
    public int withoutStreams(String s) {
        int first = s.length() > 0 ? 1 : 0;
        int uppers = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                uppers++;
            }
        }
        return first + uppers;
    }

    /**
     * Split the string by capital letters
     *
     * @param s Given string.
     * @return Number of words.
     */
    public int usingSplitString(String s) {
        return s.length() > 0
                ? s.split("[A-Z]").length
                : 0;
    }

}
