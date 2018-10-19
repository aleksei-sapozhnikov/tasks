package tasks.hackerrank.arrays.d2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HourGlassSumIn2dArrayTest {

    private HourGlassSumIn2dArray test = new HourGlassSumIn2dArray();

    @Test
    public void maxHourglass() {

        int[][] input1 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};
        assertThat(this.test.maxHourglass(input1), is(19));

        int[][] input2 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 9, 2, -4, -4, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };
        assertThat(this.test.maxHourglass(input2), is(13));

        int[][] input3 = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        assertThat(this.test.maxHourglass(input3), is(28));
    }


}