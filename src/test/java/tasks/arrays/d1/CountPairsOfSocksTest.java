package tasks.arrays.d1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountPairsOfSocksTest {

    @Test
    public void countPairsOfSocksTest() {
        CountPairsOfSocks test = new CountPairsOfSocks();
        int[] input1 = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int[] input2 = {42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42};
        int[] input3 = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
        int[] input4 = {10, 20, 30};
        assertThat(test.countPairs(input1), is(3));
        assertThat(test.countPairs(input2), is(50));
        assertThat(test.countPairs(input3), is(4));
        assertThat(test.countPairs(input4), is(0));
    }
}