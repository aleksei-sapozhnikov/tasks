package tasks.simplelogic;

/**
 * Name: Counting Valleys. From: hackerrank.com. Date: 15.09.2018
 * <p>
 * Given string of steps up/down find number of valleys. U means up, D means down.
 * We always start at the sea level.
 * <p>
 * A valley is a sequence of consecutive steps below sea level and ending at sea level.
 * starting with a step down from sea level and ending with a step up to sea level.
 * <p>
 * Constraints: 2 <= string.length <= 10e6. All symbols are either 'D' or 'U'.
 */
/*
 * Example: given string = UDDDUDUU
 * A picture of movement will be like that, where _ means sea level:
 *
 * _/\      _
 *    \    /          == valley
 *     \/\/           == valley
 *
 * Here is only 1 valley. Answer is one.
 */
public class CountValleys {

    /**
     * Just go through every element of string and count current overall height:
     * 'up' means height + 1, 'down' means height - 1.
     * <p>
     * Valley ends only when previous height was "lower sea level" (negative) and
     * current height is "at sea level' (== 0). So we just check previous height
     * and current height after every step.
     *
     * @param s String with steps.
     * @return Number of valleys.
     */
    public int countValleys(String s) {
        int height = 0;
        int valleys = 0;
        for (int i = 0; i < s.length(); i++) {
            int prev = height;
            height = s.charAt(i) == 'D' ? height - 1 : height + 1;
            if (height == 0 && prev < 0) {
                valleys++;
            }
        }
        return valleys;
    }
}
