package tasks.algorithm;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExtractMaxHalfSumTest {

    @Test
    public void cannot() {
        boolean canDivideHalfSum = new ExtractMaxHalfSum().canPartitionTwoEqualSums(new int[]{2, 3, 3, 3, 4});
        assertThat(canDivideHalfSum, is(false));
    }

    @Test
    public void can() {
        boolean canDivideHalfSum = new ExtractMaxHalfSum().canPartitionTwoEqualSums(new int[]{2, 3, 3, 4});
        assertThat(canDivideHalfSum, is(true));
    }
}