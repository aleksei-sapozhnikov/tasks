package tasks.hackerrank.math;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IsPrimeNumberTest {

    private IsPrimeNumber test = new IsPrimeNumber();

    @Test
    public void oneOfBestWays() {
        assertThat(test.oneOfBestWays(1), is(false));
        assertThat(test.oneOfBestWays(2), is(true));
        assertThat(test.listOneOfTheBestWays(Arrays.asList(12, 5, 7)), is(Arrays.asList(false, true, true)));
        assertThat(test.listOneOfTheBestWays(Arrays.asList(31, 33)), is(Arrays.asList(true, false)));
        assertThat(test.listOneOfTheBestWays(Arrays.asList(
                1, 4, 9, 16, 25, 36, 49, 64, 81, 100,
                121, 144, 169, 196, 225, 256, 289, 324, 361, 400,
                441, 484, 529, 576, 625, 676, 729, 784, 841, 907
        )), is(Arrays.asList(
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, true
        )));

    }
}