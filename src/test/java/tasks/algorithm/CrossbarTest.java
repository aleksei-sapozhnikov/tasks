package tasks.algorithm;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CrossbarTest {

    @Test
    public void maxSum() {
        Crossbar crossbar = new Crossbar();
        assertThat(crossbar.maxSum(new int[]
                {}), is(0));
        assertThat(crossbar.maxSum(new int[]
                {1, 2}), is(0));
        assertThat(crossbar.maxSum(new int[]
                {1, 2, 3, 6}), is(12));
        assertThat(crossbar.maxSum(new int[]
                {1, 2, 3, 4, 6}), is(16));
        assertThat(crossbar.maxSum(new int[]
                {3, 4, 3, 3, 2}), is(12));
        assertThat(crossbar.maxSum(new int[]
                {1, 2, 3, 4, 5, 6}), is(20));
        assertThat(crossbar.maxSum(new int[]
                {4, 10, 18, 22}), is(44));
    }
}