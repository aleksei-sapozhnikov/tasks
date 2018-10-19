package tasks.hackerrank.arrays.d2;

/**
 * Name: 2D Array - DS. From: hackerrank.com. Date: 25.09.2018
 * <p>
 * Given a 2d-array, find all 'hourglasses' and return maximum sum of values from hourglass.
 * (see definitions in comment)
 *
 * Constraints: [1][1] <= array.size <= [10][10], -9 <= array[i][j] <= 9
 */
/*
 *
 * We define an hourglass in to be a subset of values with indices falling in this pattern in 's graphical representation:
 *      a b c
 *        d
 *      e f g
 *
 * For example, we have an array:
 *
 *              -9   -9   -9    1    1   -1
 *               0   -9    0    4    3    2
 *              -9   -9   -9    1    2    3
 *               0    0    8    6    6    0
 *               0    0    0   -2    0    0
 *               0    0    1    2    4    0
 *
 * We have 16 hourglasses. Hourglass with max sum = 28:
 *
 *              0 4 3
 *                1
 *              8 6 6
 *
 */
public class HourGlassSumIn2dArray {

    /**
     * Counts maximum sum of all hourglasses.
     * <p>
     * Идея:
     *
     * @param arr Array where we count hourglasses.
     * @return Maximum hourglass sum.
     */
    public int maxHourglass(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                sum = this.sumHourglass(i, j, arr);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * Count one hourglass.
     *
     * @param i   Row coordinate of left-top corner.
     * @param j   Column coordinate of left-top corner.
     * @param arr 2D array where we count hourglasses.
     * @return Sum of the hourglass.
     */
    private int sumHourglass(int i, int j, int[][] arr) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                arr[i + 1][j + 1] +
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }

}
