package tasks.interviews;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

    @Test
    public void firstN() {
        int[] result = new Fibonacci().firstN(10);
        int[] expected = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        assertThat(result, is(expected));
    }

    @Test
    public void numberN() {
        int result = new Fibonacci().numberN(10);
        int expected = 55;
        assertThat(result, is(expected));
    }

    @Test
    public void numberNRecursive() {
        int result = new Fibonacci().numberNRecursive(10);
        int expected = 55;
        assertThat(result, is(expected));
    }
}