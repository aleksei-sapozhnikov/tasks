package tasks.hackerrank.anagrams;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Name: Sherlock and Anagrams. From: hackerrank.com. Date: 29.09.2018
 * <p>
 * Find number of unordered anagram pairs in all of the substrings of the given
 * string S.
 * <p>
 * Example: S = "abba". Here are 4 anagram pairs: 'a-a', 'b-b', 'ab-ba', 'abb-bba'.
 * <p>
 * Constraints: 0 <= S.length <= 100. Symbols of S are only small Latin letters
 * [a..z].
 */
public class SherlockAndAnagrams {

    /**
     * Method generates all possible substrings, sorts symbols in them and adds
     * sorted substrings to HashMap. For every current substrings map is checked and
     * counts how many other substrings were found already. Every one of this
     * 'other' substrings makes a pair with current one. So, we add number of
     * 'other' substrings to counter of pairs.
     * <p>
     * Complexity is O(n^2).
     * <p>
     * ==========
     * <p>
     * I wanted to implements a beautiful idea from C++ programmers. Since we only
     * have 26 letters, we take array of 26 elements [a..z] where value is a number
     * of letters in 'this' substring. So for anagrams array will be the same will
     * have the same array.
     * <p>
     * Unfortunately, in java two array objects with same values won't give the same
     * hashcode. So we won't be able to simply put them as keys to the map. That's
     * why there is no big point to make such improvement.
     */
    public int numOfAnagramPairs(String s) {
        int sumCount = 0;
        HashMap<String, Integer> subs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String current = s.substring(i, j);
                String sorted = sortSymbols(current);
                int foundBefore = subs.getOrDefault(sorted, 0);
                sumCount += foundBefore;
                subs.put(sorted, ++foundBefore);
            }
        }
        return sumCount;
    }

    /**
     * Sorts substring characters. Both "ab" and "ba" will be "ab" now.
     */
    private String sortSymbols(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

}