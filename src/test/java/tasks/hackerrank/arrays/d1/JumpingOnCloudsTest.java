package tasks.hackerrank.arrays.d1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JumpingOnCloudsTest {

    @Test
    public void testJumps() {
        JumpingOnClouds test = new JumpingOnClouds();
        int[] input1 = {0, 0, 1, 0, 0, 1, 0};
        int[] input2 = {0, 0, 0, 0, 1, 0};
        assertThat(test.jumps(input1), is(4));
        assertThat(test.jumps(input2), is(3));
    }
}