package tasks.hackerrank.arrays.d1;

/**
 * Name: Jumping on the Clouds From: hackerrank.com. Date: 18.09.2018
 * <p>
 * You've got an 0's and 1's.
 * '0' means a safe cloud on which you can stand.
 * '1' means unsafe cloud (thunderhead) which is unsafe to stand.
 * <p>
 * You can jump forward onto the next cloud or to the next-next cloud
 * (i. e. if you are standing on the i-th cloud, tou can jump to cloud number i+1 or i+2).
 * <p>
 * You start at the first cloud. Find the minimum number of jumps needed to reach the last cloud.
 * <p>
 * Constraints: first and last cloud are always safe ('0').
 * 2 <= nClouds <= 100, all values are '0' and '1',
 * <p>
 * Example: given array = {0 0 1 0 0 1 0}, we get answer '4': [0] -> [1] -> [3] -> [6]
 */
public class JumpingOnClouds {

    /**
     * Idea: if we are not in the needed position, than we need one more step. Count it to sum.
     * <p>
     * Then, let's check if we can make the longest jump: if it is still inside tha array
     * and the cloud we're landing to is safe (!= 1). If it is aafe, let's make a jump and
     * change our position.
     * <p>
     * If it is not safe, we can make only one step, so let's make it.
     *
     * @param array Given array of 0's and 1's.
     * @return Number of jumps needed.
     */
    public int jumps(int[] array) {
        int jumps = 0;
        int pos = 0;
        while (pos < array.length - 1) {
            jumps++;
            pos = pos + 2 <= array.length - 1 && array[pos + 2] != 1
                    ? pos + 2
                    : pos + 1;
        }
        return jumps;
    }
}
