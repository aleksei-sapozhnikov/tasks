package tasks.arrays.d1;

/**
 * Name: Sock Merchant. From: hackerrank.com. Date: 04.10.2018
 * <p>
 * Find number of pairs in the given array (originally: pairs of socks in the box).
 * Pair is two elements with the same value (color).
 * Each element can be only in one pair.
 * <p>
 * Example: given array = {}10 20 20 10 10 30 50 10 20}
 * We have 3 pairs: 10-10, 10-10, 20-20.
 *
 * <p>
 * Constraints: 1 <= array.length <= 100; 1 <= array[i] <= 100.
 */
public class CountPairsOfSocks {

    /**
     * Idea: we travel through the given array.
     * For each element we search element with matching color in the further part of the array.
     * <p>
     * If pair found, we increment pairs counter.
     * Then we mark both elements as "already used".
     * By constraints arr[i] > 0, so we set their values to -1.
     *
     * @param ar Array of elements with colots.
     * @return Number of pairs found.
     */
    public int countPairs(int[] ar) {
        int pairs = 0;
        int length = ar.length;
        for (int i = 0; i < length; i++) {
            if (ar[i] != -1) {
                for (int j = i + 1; j < length; j++) {
                    if (ar[j] != -1 && ar[i] == ar[j]) {
                        pairs++;
                        ar[i] = -1;
                        ar[j] = -1;
                        break;
                    }
                }
            }
        }
        return pairs;
    }
}
